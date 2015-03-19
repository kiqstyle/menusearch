package menusearch.db;

import menusearch.db.*;
import menusearch.domain.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Interface for accessing and manipulating the nypl_menus database.
 * 
 * @author Professor MacKellar
 * @author Randy Gingeleski
 */
public class MenuDBAccess {
    
    static final class FIELDS {
        static final String menu_id = "menu_id";
        static final String name = "name";
        static final String sponsor = "sponsor";
        static final String event = "event";
        static final String venue = "venue";
        static final String place = "place";
        static final String physical_description = "physical_description";
        static final String occasion = "occasion";
        static final String notes = "notes";
        static final String call_number = "call_number";
        static final String keywords = "keywords";
        static final String language = "language";
        static final String menu_date = "menu_date";
        static final String location = "location";
        static final String location_type = "location_type";
        static final String currency = "currency";
        static final String currency_symbol = "currency_symbol";
        static final String status = "status";
        static final String page_count = "page_count";
        static final String dish_count = "dish_count";
    }
    
    private static Connection conn;
    private static final String QUOTE = "\"";
    
    /**
     * Attempts to find and build a Menu based on a passed-in SQL query.
     * 
     * @param query SQL query
     * @return Menu
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Menu retrieve(String query) throws ClassNotFoundException,
            SQLException {
        
        Menu menu;
        
        conn = DBConnection.getMyConnection();
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        if(!rs.next())
            menu = null;   // If no menu is found.
        else
            menu = buildMenu(rs);

        stmt.close();
        return menu;
    }
    
    /**
     * Returns a single Menu based on menu_id.
     * 
     * @param menu_id
     * @return Menu
     */
    public static Menu retrieveByID(String menu_id) throws ClassNotFoundException, 
            SQLException {
        
        conn = DBConnection.getMyConnection();
        
        String query = ("SELECT * FROM `nypl_menus`.`menus` WHERE menu_id = "
                + menu_id);

        return retrieve(query);
    }
      
    /**
     * Builds one Menu from the current row in the result set.
     * 
     * @param rs a ResultSet
     * @return Menu
     * @throws SQLException 
     */
    private static Menu buildMenu(ResultSet rs) throws SQLException {
        
        int menu_id = rs.getInt(FIELDS.menu_id);
        String name = rs.getString(FIELDS.name);
        String sponsor = rs.getString(FIELDS.sponsor);
        String event = rs.getString(FIELDS.event);
        String venue = rs.getString(FIELDS.venue);
        String place = rs.getString(FIELDS.place);
        String physical_description = rs.getString(FIELDS.physical_description);
        String occasion = rs.getString(FIELDS.occasion);
        String notes = rs.getString(FIELDS.notes);
        String call_number = rs.getString(FIELDS.call_number);
        String keywords = rs.getString(FIELDS.keywords);
        String language = rs.getString(FIELDS.language);
        LocalDate menu_date = LocalDate.parse(rs.getString(FIELDS.menu_date));
        String location = rs.getString(FIELDS.location);
        String location_type = rs.getString(FIELDS.location_type);
        String currency = rs.getString(FIELDS.currency);
        String currency_symbol = rs.getString(FIELDS.currency_symbol);
        String status = rs.getString(FIELDS.status);
        int page_count = rs.getInt(FIELDS.page_count);
        int dish_count = rs.getInt(FIELDS.dish_count);

        Menu menu = new Menu(menu_id, name, sponsor, event, venue, place,
            physical_description, occasion, notes, call_number, keywords,
            language, menu_date, location, location_type, currency,
            currency_symbol, status, page_count, dish_count);
        
        return menu;
    }
    
    /**
     * Builds a list of dishes from a result set.
     * 
     * @param rs
     * @return ArrayList<Dish>
     * @throws SQLException 
     */
    private static ArrayList<Menu> buildMenuList(ResultSet rs) throws 
            SQLException {
        
        ArrayList<Menu> menus = new ArrayList<Menu>();
      
        while (rs.next()) {
            Menu menu = buildMenu(rs);
            menus.add(menu);
        }
        
        return menus;
    }
}
