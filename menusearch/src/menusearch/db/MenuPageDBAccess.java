package menusearch.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import menusearch.domain.*;

/**
 * Interface for accessing and manipulating the nypl_menus database.
 * 
 * @author Chris Dhanapala
 * @author Randy Gingeleski
 */
public class MenuPageDBAccess {

    private static Connection conn;

    public static MenuPage retrieveByID(int id) 
            throws ClassNotFoundException, SQLException {
        
        MenuPage menuPage;
        conn = DBConnection.getMyConnection();
        String query = ("select * from menu_pages where menu_page_id= \"" + id + "\"");
        System.out.println("query is " + query);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if (!rs.next()) {
            menuPage = null;
        } else {
            menuPage = buildMenuPage(rs);
        }
        stmt.close();
        return menuPage;
    }

    public static ArrayList<MenuPage> retrieveByPage(int page) 
            throws ClassNotFoundException, SQLException {
        
        ArrayList<MenuPage> menuPages;
        conn = DBConnection.getMyConnection();
        String query = ("select * from menu_pages where page_number= \"" + page + "\"");
        System.out.println("query is " + query);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        menuPages = buildMenuPageList(rs);

        stmt.close();
        return menuPages;
    }

    public static ArrayList<MenuPage> retrieveByMenuID(int menuID) 
            throws ClassNotFoundException, SQLException {
        
        ArrayList<MenuPage> menuPages;
        conn = DBConnection.getMyConnection();
        String query = ("select * from menu_pages where menu_id= \"" + menuID + "\"");
        System.out.println("query is " + query);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        menuPages = buildMenuPageList(rs);

        stmt.close();
        return menuPages;
    }

    public static ArrayList<MenuPage> retrieveByMenuItemID(int menuItemID) 
            throws ClassNotFoundException, SQLException {
        
        ArrayList<MenuPage> menuPages;
        conn = DBConnection.getMyConnection();
        String query = ("select menu_pages.menu_page_id, menu_pages.menu_id, menu_pages.page_number, menu_pages.image_id, menu_pages.full_height, menu_pages.full_width from menu_pages, menu_items where menu_items_id= \"" + menuItemID + "\"" + "and menu_pages.menu_page_id=menu_items.menu_page_id");
        System.out.println("query is " + query);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        menuPages = buildMenuPageList(rs);

        stmt.close();
        return menuPages;
    }

    /**
     * Populate the ArrayList<MenuItem> of given MenuPage with appropriate
     * objects.
     * 
     * @param page the MenuPage to populate
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static void populateMenuPage(MenuPage page) 
            throws ClassNotFoundException, SQLException {
        
        // Get the ID of the MenuPage
        String menuPageID = Integer.toString( page.getMenu_page_id() );
        System.out.println("Populate MenuPage ID " + menuPageID);
        
        // Get the ArrayList of MenuItems that go with it
        ArrayList<MenuItem> workingItems = 
                MenuItemDBAccess.retrieveByMenuPageID( menuPageID );
        
        // Iterate through each MenuItem, linking its Dish
        Iterator<MenuItem> workingItemsIterator = workingItems.iterator();
        
        while( workingItemsIterator.hasNext() ) {
            
            MenuItemDBAccess.populateMenuItem( workingItemsIterator.next() );
        }
        
        // Set the ArrayList of MenuItems we've been working as the MenuPage's
        page.setMenuItems( workingItems );
    }

    public static MenuPage buildMenuPage(ResultSet rs) throws SQLException {
        
        int menu_page_id = rs.getInt("menu_page_id");
        int menu_id = rs.getInt("menu_id");
        int page_number = rs.getInt("page_number");
        String image_id = rs.getString("image_id");
        int full_height = rs.getInt("full_height");
        int full_width = rs.getInt("full_width");
        Menu menu = new Menu(menu_id);

        MenuPage menuPage = new MenuPage(menu_page_id, menu, page_number, 
                image_id, full_height, full_width);
        
        return menuPage;
    }

    private static ArrayList<MenuPage> buildMenuPageList(ResultSet rs) 
            throws SQLException {
        
        ArrayList<MenuPage> menuPages = new ArrayList<MenuPage>();

        while (rs.next()) {
            MenuPage menuPage = buildMenuPage(rs);
            menuPages.add(menuPage);
        }
        
        return menuPages;
    }
}
