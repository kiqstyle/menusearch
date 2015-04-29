package menusearch.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;
import menusearch.domain.*;

/**
 * Interface for accessing and manipulating the nypl_menus database.
 * 
 * @author Nicole Kim
 * @author Randy Gingeleski
 */
public class MenuItemDBAccess {
    
    static final class FIELDS {
        
        static final String menu_items_id = "menu_items_id";
        static final String name = "name";
        static final String price = "price";
        static final String high_price = "high_price";
        static final String created_at = "created_at";
        static final String updated_at = "updated_at";
        static final String xpos = "xpos";
        static final String ypos = "ypos";
    }
    
    private ArrayList<Dish> dish;
    private ArrayList<MenuPage> menuPage;
   
    private static Connection conn;
    private static final String QUOTE = "\"";
    
    /**
     * Returns a single MenuItem object matching a specified ID.
     * 
     * @param id
     * @return MenuItem object
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static MenuItem retrieveByID(int id) 
            throws ClassNotFoundException, SQLException {
        
        MenuItem menuItem;
        conn = DBConnection.getMyConnection();

        String query = ("SELECT * FROM menu_items WHERE "
                + "menu_items_id = \"" + id + "\"");

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        if (!rs.next()) {   menuItem = null;   /* No menuitem found */  }
        else {      menuItem = buildMenuItem(rs);       }
        
        stmt.close();
        
        return menuItem;
    }
    
    /**
     * Returns a MenuItem constructed from given ResultSet.
     * 
     * @param rs
     * @return
     * @throws SQLException 
     */
    public static MenuItem buildMenuItem(ResultSet rs) throws SQLException {
        
        int menu_items_id = rs.getInt(FIELDS.menu_items_id);
        int menu_page_id = rs.getInt("menu_page_id");
        int dish_id = rs.getInt("dish_id");
        float price = rs.getFloat(FIELDS.price);
        float high_price = rs.getFloat(FIELDS.high_price);
        
        LocalDateTime created_at = 
                rs.getTimestamp(FIELDS.created_at).toLocalDateTime();
        
        LocalDateTime updated_at = 
                rs.getTimestamp(FIELDS.updated_at).toLocalDateTime();
        
        float xpos = rs.getFloat(FIELDS.xpos);
        float ypos = rs.getFloat(FIELDS.ypos);
        
        Dish dish = new Dish(dish_id);
        
        MenuPage menuPage = new MenuPage(menu_page_id);

        MenuItem menuItem = new MenuItem(menu_items_id, price, high_price, 
                created_at, updated_at, xpos, ypos, dish, menuPage);
        
        return menuItem;
    }
    
    /**
     * Returns an ArrayList of MenuItems that belong to a specified MenuPage.
     * 
     * @param menuPage_id
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static ArrayList<MenuItem> retrieveByMenuPageID(String menuPage_id)
            throws ClassNotFoundException, SQLException {
        
        ArrayList<MenuItem> workingItems = new ArrayList<MenuItem>();
        
        conn = DBConnection.getMyConnection();
        
        String query = ("SELECT * FROM menu_items WHERE menu_page_id = \""
                + menuPage_id + "\"");
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        workingItems = buildMenuItemList(rs);
        
        stmt.close();
        return workingItems;
    }
    
    /**
     * Links a given MenuItem to its related Dish.
     * 
     * @param item
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void populateMenuItem(MenuItem item) 
            throws SQLException, ClassNotFoundException {
    
        int menuItemID = item.getMenu_items_id();
        System.out.println("Populate MenuItem ID " + menuItemID);
        
        Dish dish = DishDBAccess.retrieveByID(menuItemID);
        
        item.setDish(dish);
    }
      
    /**
     * Builds a list of MenuItems from a ResultSet.
     * 
     * @param rs
     * @return
     * @throws SQLException 
     */
    private static ArrayList<MenuItem> buildMenuItemList (ResultSet rs) 
            throws SQLException {
        
        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        
        while (rs.next()) {
            
            MenuItem menuItem = buildMenuItem(rs);
            menuItems.add(menuItem);
        }
        
        return menuItems;
    }
}
    
  