package menusearch.db;

import menusearch.db.*;
import menusearch.domain.*;
import java.util.Iterator;
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
 * @author Nicole Kim
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
     * Executes SQL query to build Menu ArrayList.
     * Root of all retrieve- methods.
     * 
     * @param query SQL query
     * @return Menu
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<Menu> retrieve(String query) throws
            ClassNotFoundException, SQLException {
        
        ArrayList<Menu> menus;
        
        conn = DBConnection.getMyConnection();
        
        Statement statement = conn.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE, 
            ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = statement.executeQuery(query);
        
        if(!rs.next()) {   menus = null;   /* If no menu is found. */   }
        else {    menus = buildMenuList(rs);    }
        
        System.out.println("Received ArrayList<Menu>");
        
        statement.close();
        return menus;
    }
    
    /**
     * Returns a single Menu based on menu_id.
     * 
     * @param menu_id
     * @return Menu
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Menu retrieveByMenuID(String menu_id) throws
            ClassNotFoundException, SQLException {
        
        conn = DBConnection.getMyConnection();
        
        String query = ("SELECT * FROM nypl_menus.menus WHERE menu_id = "
                + menu_id);

        return retrieve(query).get(0);
    }
    
    /**
     * Returns the single Menu that contains a specified MenuPage.
     * 
     * @param menuPage_id
     * @return Menu
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Menu retrieveByMenuPageID(String menuPage_id) throws
            ClassNotFoundException, SQLException {
        
        int menuPage_int_id = Integer.parseInt( menuPage_id );
        
        MenuPage workingMenuPage = 
                MenuPageDBAccess.retrieveByID( menuPage_int_id );
        
        return workingMenuPage.getMenu();
    }
    
    /**
     * Returns an ArrayList of Menu objects containing specified Dish.
     * 
     * @param thisDish - Dish to search all Menus for.
     * @return ArrayList<Menu> - an ArrayList of Menu objects with that Dish.
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static ArrayList<Menu> searchByDish(Dish thisDish) throws
            ClassNotFoundException, SQLException {
        
        String dishID = Integer.toString(thisDish.getDish_id());
        
        String query = ("SELECT * FROM nypl_menus.menus "
                + "JOIN nypl_menus.menu_pages ON nypl_menus.menu_pages.menu_id "
                + "= nypl_menus.menus.menu_id JOIN nypl_menus.menu_items ON "
                + "nypl_menus.menu_items.menu_page_id = "
                + "nypl_menus.menu_pages.menu_page_id WHERE "
                + "nypl_menus.menu_items.dish_id = " + dishID
                + " GROUP BY nypl_menus.menus.menu_id;");
        
        return retrieve(query);
    }
    
    /**
     * Based on a dish name search, returns an ArrayList of dish_id numbers
     * with similar names.
     * 
     * @param dishName
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static ArrayList<Integer> getDishIDsByName(String dishName) throws
            ClassNotFoundException, SQLException {
        
        String query = "SELECT dish_id " +
                       "FROM nypl_menus.dishes " +
                       "WHERE name LIKE " + QUOTE + dishName + QUOTE + ";";
        
        ArrayList<Integer> dishIDList = new ArrayList<Integer>();
        
        conn = DBConnection.getMyConnection();
        
        Statement stmt = conn.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE, 
            ResultSet.CONCUR_READ_ONLY );
        
        ResultSet rs = stmt.executeQuery(query);
        
        if(!rs.next()) {    return null;    /* If nothing is found */     } 
        
        rs.beforeFirst();
        
        while (rs.next()) {
            
            int thisDishID = rs.getInt("dish_id");
                
            System.out.println("Adding dish " + thisDishID + " to list");
                
            dishIDList.add(thisDishID);
        }
        
        stmt.close();
        
        return dishIDList;
    }
    
    /**
     * Returns an ArrayList of Menu objects like this venue search term.
     * 
     * @param venue
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static ArrayList<Menu> searchByVenue(String venue) throws
            ClassNotFoundException, SQLException {
        
        String query = ("SELECT * FROM nypl_menus.menus WHERE location LIKE"
            + " '" + venue + "';");
        
        return retrieve(query);
    }
    
    /**
     * Returns an ArrayList of Menu objects like this place search term.
     * 
     * @param place
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static ArrayList<Menu> searchByPlace(String place) throws
            ClassNotFoundException, SQLException {
        
        String query = ("SELECT * FROM nypl_menus.menus WHERE place LIKE " +
            QUOTE + place + QUOTE + ";");
        
        return retrieve(query);
    }
    
    /**
     * Returns an ArrayList of Menu objects like this currency search term.
     * 
     * @param currency
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static ArrayList<Menu> searchByCurrency(String currency) throws
            ClassNotFoundException, SQLException {
        
        String query = ("SELECT * FROM nypl_menus.menus WHERE currency LIKE " +
            "'" + currency + "';");
        
        return retrieve(query);
    }
    
    /**
     * Returns an ArrayList of Menu objects like this event search term.
     * 
     * @param event
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException 
     */    
    public static ArrayList<Menu> searchByEvent(String event) throws
            ClassNotFoundException, SQLException {
        
        String query = ("SELECT * FROM nypl_menus.menus WHERE event LIKE " +
            "'" + event + "';");
        
        return retrieve(query);
    }
    
    /**
     * Returns an ArrayList of Menu objects like this sponsor search term.
     * 
     * @param sponsor
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static ArrayList<Menu> searchBySponsor(String sponsor) throws
            ClassNotFoundException, SQLException {
        
        String query = ("SELECT * FROM nypl_menus.menus WHERE sponsor LIKE "
            + " '" + sponsor + "';");
        
        return retrieve(query);
    }
    
    /**
     * Returns an ArrayList of Menu objects like this occasion search term.
     * 
     * @param occasion
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException 
     */   
    public static ArrayList<Menu> searchByOccasion(String occasion) throws
            ClassNotFoundException, SQLException {
        
        String query = ("SELECT * FROM nypl_menus.menus WHERE occasion LIKE"
            + " '" + occasion + "';");
        
        return retrieve(query);
    }
    
    /**
     * Returns an ArrayList of Menu objects matching given year search limits.
     * 
     * @param yearParams
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<Menu> searchByYear(int[] yearParams) throws
            ClassNotFoundException, SQLException {
        
        String query = "";
        
        // This method shouldn't called with the array [0, 0]
        // Checking for that earlier
        if (yearParams[0] == yearParams[1]) {
            
            query += "SELECT * FROM nypl_menus.menus " +
                "WHERE YEAR(menu_date) = " + Integer.toString(yearParams[0]) +
                ";";
        
        } else if (yearParams[0] == 0) {
            
            query += "SELECT * FROM nypl_menus.menus " +
                "WHERE YEAR(menu_date) < " + Integer.toString(yearParams[1]) +
                ";";
            
        } else if (yearParams[1] == 0) {
            
            query += "SELECT * FROM nypl_menus.menus " +
                "WHERE YEAR(menu_date) > " + Integer.toString(yearParams[0]) +
                ";";
            
        } else {
            
            query += "SELECT * FROM nypl_menus.menus " +
                "WHERE YEAR(menu_date) > " + Integer.toString(yearParams[0]) +
                "AND YEAR(menu_date) < " + Integer.toString(yearParams[1]) +
                ";";  
        }
        
        return retrieve(query);
    }
    
    /**
     * Returns an ArrayList of Menu objects matching given page count limits.
     * 
     * @param pageCountParams
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException 
     */    
    public static ArrayList<Menu> searchByPageCount(int[] pageCountParams)
            throws ClassNotFoundException, SQLException {
        
        String query;
        
        // This method shouldn't called with the array [0, 0]
        // Checking for that earlier
        if (pageCountParams[0] == pageCountParams[1]) {
            
            query = "SELECT * FROM nypl_menus.menus " +
                "WHERE page_count = " + Integer.toString(pageCountParams[0]) +
                ";";
        
        } else if (pageCountParams[0] == 0) {
            
            query = "SELECT * FROM nypl_menus.menus " +
                "WHERE page_count < " + Integer.toString(pageCountParams[1]) +
                ";";
            
        } else if (pageCountParams[1] == 0) {
            
            query = "SELECT * FROM nypl_menus.menus " +
               "WHERE page_count > " + Integer.toString(pageCountParams[0])
               + ";";
            
        } else {
            
            query = "SELECT * FROM nypl_menus.menus " +
                "WHERE page_count > " + Integer.toString(pageCountParams[0]) +
                "AND page_count < " + Integer.toString(pageCountParams[1]) +";"; 
        }
        
        return retrieve(query);
    }
    
    /**
     * Returns an ArrayList of Menu objects matching given dish count limits.
     * 
     * @param dishCountParams
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException 
     */          
    public static ArrayList<Menu> searchByDishCount(int[] dishCountParams)
            throws ClassNotFoundException, SQLException {
        
        String query;
        
        // This method shouldn't called with the array [0, 0]
        // Checking for that earlier
        if (dishCountParams[0] == dishCountParams[1]) {
            
            query = "SELECT * FROM nypl_menus.menus " +
                "WHERE dish_count = " + Integer.toString(dishCountParams[0]) +
                ";";
        
        } else if (dishCountParams[0] == 0) {
            
            query = "SELECT * FROM nypl_menus.menus " +
                "WHERE dish_count < " + Integer.toString(dishCountParams[1]) +
                ";";
            
        } else if (dishCountParams[1] == 0) {
            
            query = "SELECT * FROM nypl_menus.menus " +
               "WHERE dish_count > " + Integer.toString(dishCountParams[0])
               + ";";
            
        } else {
            
            query = "SELECT * FROM nypl_menus.menus " +
                "WHERE dish_count > " + Integer.toString(dishCountParams[0]) +
                "AND dish_count < " + Integer.toString(dishCountParams[1]) +";"; 
        }
        
        return retrieve(query);
    }
    
    /**
     * Returns an ArrayList of Menu objects based on a complex search with
     * numerous parameters.
     * 
     * @param paramSet - SearchParameters object of what to query for.
     * @return MenuList
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static ArrayList<Menu> retrieveByComplexSearch(SearchParameters
            paramSet) throws ClassNotFoundException, SQLException {
        
        ArrayList<Menu> complexSearchResults = new ArrayList<Menu>();
        
        String query = "SELECT * FROM nypl_menus.menus WHERE  ";
        
        // GENERAL QUERY
        //      User can search for this by itself, or with more specific
        //      parameters. This could be any string - word or number. Have to
        //      figure out what the user meant.
        if (paramSet.getGeneralQuery() != null) {
            
            // Test to see if general query is a number
            if ( isNumber(paramSet.getGeneralQuery()) ) { // ** Is a number
                             
                // Could be an ID, year, page count, or dish count.
                query += "(menu_id = " + paramSet.getGeneralQuery() + " OR " +
                    "YEAR(menu_date) = " + paramSet.getGeneralQuery() + " OR " +
                    "page_count = " + paramSet.getGeneralQuery() + " OR " +
                    "dish_count = " + paramSet.getGeneralQuery() + ");" ;
            
            } else { // ** Is not a number
                
                // Could be a venue, place, dish, currency, event, sponsor,
                // or occasion
                
                query += "(venue LIKE '" + paramSet.getGeneralQuery() + "'"
                      + " OR place LIKE '" + paramSet.getGeneralQuery() + "' OR"
                      + " currency LIKE '" + paramSet.getGeneralQuery() + "' OR"
                      + " event LIKE '" + paramSet.getGeneralQuery() + "' OR " +
                        "sponsor LIKE '" + paramSet.getGeneralQuery() + "' OR "
                      + "occasion LIKE '" + paramSet.getGeneralQuery() + "');" ;
                
                // Dish is a special case
                
                ArrayList<Integer> dishIDResults = 
                        getDishIDsByName( paramSet.getGeneralQuery() );
                
                for (int dishID : dishIDResults) {   
                    
                    Dish thisDish = new Dish(dishID);
                    complexSearchResults.addAll( searchByDish(thisDish) );
                
                }   
            }
                             
            // This seems to be how the NYPL Menus site works now - take
            // what the user typed in and just sloppily search everything.
            
            // But before returning results from the general search - were
            // more specific queries made? If not, return. If so, go on and
            // we'll have to filter.
            SearchParameters defaultParams = new
                SearchParameters( paramSet.getGeneralQuery() );
            
            if(defaultParams.equals(paramSet)) { // Checks to see if there was
                                                 // only a general query param
                    
                    ArrayList<Menu> tempList = retrieve(query);
                    
                    if(tempList != null) {
                        
                        complexSearchResults.addAll( tempList );
                        
                    }
                    
                    if ( complexSearchResults.isEmpty() ) { return null; }
                    else { return complexSearchResults; }
                
            }
            
            // Possibly the user made a general query AND one more specific.
            // Method goes on to check for other parameters if so.
        }
        
        // Possibly remove semicolon from the SQL query to append on it
        // and add an AND
        if ( !query.equals(queryOpener( query )) ) {
            
            query = queryOpener( query );
            query += " AND ";
        }
        
        if (paramSet.getMenu_id() != 0) {
                
            query += "(menu_id = " + paramSet.getMenu_id() + ") AND ";
        }
        
        if (paramSet.getVenue() != null) {
            
            query += "(venue LIKE '" + paramSet.getVenue() + "') AND ";
        }
        
        if (paramSet.getPlace() != null) {
            
            query += "(place LIKE '" + paramSet.getPlace() + "') AND ";                     
        }
        
        // This is a special case
        if (paramSet.getDish() != null) {
            
            ArrayList<Integer> dishIDResults2 = 
                   getDishIDsByName( paramSet.getDish() );
                
            for (int dishID : dishIDResults2) {   
                Dish thisDish = new Dish(dishID);
                complexSearchResults.addAll( searchByDish(thisDish) );
            }                      
        }
        
        if ((paramSet.getYear()[0] != 0) && (paramSet.getYear()[1] != 0)) {
            
            query += "(YEAR(menu_date) > " + paramSet.getYear()[0] + ") " +
                  "AND (YEAR(menu_date) < " + paramSet.getYear()[1] + ") AND " ;
        }
        
        if (paramSet.getCurrency() != null) {
            
            query += "(currency LIKE '" + paramSet.getCurrency() + "' AND ";
        }
        
        if (paramSet.getEvent() != null) {

            query += "(event LIKE '" + paramSet.getEvent() + "' AND ";
        }        

        if (paramSet.getSponsor() != null) {
            
            query += "(sponsor LIKE '" + paramSet.getSponsor() + "' AND ";
        }
        
        if (paramSet.getOccasion() != null) {
            
            query += "(occasion LIKE '" + paramSet.getOccasion() + "' AND ";
        }             
        
        if ((paramSet.getPageCount()[0] != 0) || 
                (paramSet.getPageCount()[1] != 0)) {
            
            query += "(page_count > " + paramSet.getPageCount()[0] + ") " +
                  "AND (page_count < " + paramSet.getPageCount()[1] + ") AND " ;          
        }
        
        if ((paramSet.getDishCount()[0] != 0) || 
                (paramSet.getDishCount()[1] != 0)) {
            
            query += "(dish_count > " + paramSet.getDishCount()[0] + ") " +
                  "AND (dish_count < " + paramSet.getDishCount()[1] + ") AND " ;         
        }
        
        query = queryEnder( query );
        complexSearchResults.addAll( retrieve(query) );
                
        if ( complexSearchResults.isEmpty() ) { return null; }
        else { return complexSearchResults; }
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
        
        /* Parsing here, so have to be sensitive of null fields */
        LocalDate menu_date = null;
        String date = rs.getString(FIELDS.menu_date);
        
        if( (date != null) && (!date.isEmpty()) ) {
            
            menu_date = LocalDate.parse( date );
        }
        
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
     * Builds a list of Menus from a ResultSet.
     * 
     * @param rs
     * @return ArrayList<Dish>
     * @throws SQLException 
     */
    private static ArrayList<Menu> buildMenuList(ResultSet rs) throws 
            SQLException {
        
        ArrayList<Menu> menus = new ArrayList<Menu>();
        
        rs.beforeFirst();
      
        while ( rs.next() ) {
            
            Menu menu = buildMenu(rs);
            
            System.out.println("Added menu " + menu.getMenu_id() + " to list");
            
            menus.add(menu);
        }
        
        return menus;
    }   
    
    /**
     * Populates the given Menu's ArrayList<MenuPage> with appropriate objects.
     * 
     * @param menu
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static void populateMenuPages (Menu menu) 
            throws ClassNotFoundException, SQLException {
        
        // Get the Menu ID
        int menuID = menu.getMenu_id();
        
        // Get the ArrayList of MenuPages that go with it
        ArrayList<MenuPage> workingPages = 
                MenuPageDBAccess.retrieveByMenuID(menuID);
        
        // Iterate through each MenuPage, calling populateMenuPage
        Iterator<MenuPage> workingPagesIterator = workingPages.iterator();
        
        while( workingPagesIterator.hasNext() ) {
            
            MenuPageDBAccess.populateMenuPage( workingPagesIterator.next() );
        }
        
        // Set the MenuPage ArrayList we've been working as the Menu's
        menu.setMenuPages(workingPages);
    }
    
    /**
     * Returns a complete Menu object with MenuPages, MenuItems and Dishes.
     * 
     * @param menu
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static Menu retrieveFullMenuByID(Menu menu) throws 
            ClassNotFoundException,SQLException {
        
        // It's possible a "shell" Menu object gets passed in with only
        // an ID. So first we need to make sure we have all the Menu info.
        String menu_id = Integer.toString( menu.getMenu_id() );
        Menu workingMenu = MenuDBAccess.retrieveByMenuID( menu_id );
        
        // Call the populateMenuPages method
        // This sets off a chain reaction - populating this Menu's needed
        // MenuPages, those MenuPages' needed MenuItems, and linking Dishes.
        populateMenuPages( workingMenu );
        
        return workingMenu; // Updated version of the passed Menu, populated
    }

    /**
     * Returns an ArrayList of all MenuPages in a specified Menu.
     * 
     * @param menu_id
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    private static ArrayList<MenuPage> retrievePagesByID (String menu_id) 
            throws ClassNotFoundException, SQLException {
        
        ArrayList<MenuPage> menuPages = null;
        MenuPage menuPage;
        
        conn = DBConnection.getMyConnection();
        
        String query = ("SELECT * FROM menu_pages WHERE menu_id = \""
                + menu_id + "\"");
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        if(!rs.next()) {    menuPages = null;   }
        
        else { 
            while(rs.next()) {
   
                menuPages.add(menuPage = MenuPageDBAccess.buildMenuPage(rs));
            }
        }
        
        stmt.close();
        
        return menuPages;
    }
    
    /**
     * Tests a String to see if it's a number.
     * Used in the complex search method for "general queries" where
     * it's unsure what the user meant.
     * 
     * @param toTest - String that may or may not be a number
     * @return true/false
     */
    private static Boolean isNumber(String toTest) {
        
        try {  double d = Double.parseDouble(toTest);  }
        catch( NumberFormatException nfe ) {  return false;   } 
        
        return true; 
    }
    
    /**
     * Takes a SQL query that may have been "ended" with a semicolon and
     * "opens" it for appending, if necessary.
     * 
     * @param query
     * @return Safe query to add to
     */
    private static String queryOpener(String query) {
        
        int x = query.length();
        
        if (query.substring(x - 2, x - 1).contains(";"))
            {   query = query.substring(0, query.length() - 1);     }
    
        return query;
    }
    
    /**
     * Takes a SQL "query in progress", checks for opens ORs and ANDs,
     * fixes if needed.
     * 
     * @param query
     * @return Safe query to run
     */
    private static String queryEnder(String query) {
        
        int x = query.length();
        
        if ( query.substring( x - 5, x - 1 ).contains("OR") ) {
            
            query = query.substring( x - 4, x - 1 );
            query += ";" ;
        
        } else if ( query.substring( x - 7, x - 1 ).contains("AND") ) {
            
            query = query.substring( x - 5, x - 1 );
            query += ";" ;
        }
        
        return query;
    }
}
