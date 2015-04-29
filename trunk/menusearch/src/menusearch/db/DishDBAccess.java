package menusearch.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import menusearch.domain.Dish;

/**
 * Interface for accessing and manipulating the nypl_menus database (Dish).
 * 
 * @author Kenny Smith
 * @author Randy Gingeleski
 */
public class DishDBAccess {
    
    private static Connection conn;
    private static final String QUOTE = "\"";
    
    /**
     * Returns a single Dish object based on its ID number (primary key).
     * 
     * @param dish_id
     * @return Dish object
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static Dish retrieveByID(int dish_id) throws ClassNotFoundException, 
            SQLException {

        Dish dish;
        conn = DBConnection.getMyConnection();
        
        String query = ("SELECT * FROM dishes WHERE dish_id= \"" 
                + dish_id + "\";");
        
        try (Statement stmt = conn.createStatement()) {
            
            ResultSet rs = stmt.executeQuery(query);
            
            if (!rs.next())
                dish = null;   // No dish found
            else
                dish = buildDish(rs);
        }
    
        return dish;
    }

    /**
     * Returns a single Dish object based on the ID number (primary key) of
     * the MenuItem to which it is linked.
     * 
     * @param menuItemID
     * @return Dish object
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Dish retrieveByMenuItemID(int menuItemID) throws 
            ClassNotFoundException, SQLException {
        
        Dish dish = null;
        conn = DBConnection.getMyConnection();

        String query = ("SELECT dishes.dish_id, name, description, "
                + "menus_appeared, times_appeared, first_appeared, "
                + "last_appeared, lowest_price, highest_price FROM dishes, "
                + "menu_items WHERE menu_items_id= " + menuItemID + " AND "
                + "dishes.dish_id = menu_items.dish_id;");

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
         
        if (!rs.next())
            return null;   // No MenuItem found
        else
            dish = buildDish(rs);

        stmt.close();
        return dish;    
    }

    /**
     * Returns an ArrayList of Dish objects that belong to a specified Menu,
     * by menu ID (primary key).
     * 
     * @param menu_id - ID of the Menu whose Dish objects should be retrieved
     * @return ArrayList<Dish> belonging to specified Menu
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<Dish> retrieveByMenu(int menu_id) throws 
            ClassNotFoundException, SQLException {
        
        ArrayList <Dish> dishes = new ArrayList<>();
        Dish dish;
        
        conn = DBConnection.getMyConnection();

        String query = ("SELECT * FROM dishes, menus, menu_pages, menu_items "
                + "WHERE menus.menu_id = "+ menu_id +" AND menu_pages.menu_id "
                + "= menus.menu_id AND menu_items.menu_page_id = "
                + "menu_pages.menu_page_id AND menu_items.dish_id = "
                + "dishes.dish_id");
        
        try (Statement stmt = conn.createStatement()) {
            
            ResultSet rs = stmt.executeQuery(query);
            
            if(!rs.next())
                return null;
            else
                while(rs.next()) { dishes.add(dish = buildDish(rs)); } 
        }
        
        return dishes;
    }
    
    /**
     * Builds and returns a single Dish object based on a SQL query ResultSet.
     * 
     * @param rs - SQL query ResultSet
     * @return Dish object
     * @throws SQLException 
     */
    private static Dish buildDish(ResultSet rs) throws SQLException {

        int dish_id = rs.getInt("dish_id");
        String name = rs.getString("name");
        String description = rs.getString("description");
        int menus_appeared = rs.getInt("menus_appeared");
        int times_appeared = rs.getInt("times_appeared");
        int first_appeared = rs.getInt("first_appeared");
        int last_appeared = rs.getInt("last_appeared");
        double lowest_price = rs.getDouble("lowest_price");
        double highest_price = rs.getDouble("highest_price");
        
        Dish dish = new Dish(dish_id, name, description, 
                menus_appeared, times_appeared, first_appeared, 
                last_appeared, highest_price, lowest_price);
        
        return dish;
    }
}
      
