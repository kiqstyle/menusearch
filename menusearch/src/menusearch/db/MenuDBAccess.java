package menusearch.db;

import menusearch.domain.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import org.apache.commons.collections4.CollectionUtils;
import java.util.Collection;

/**
 * Interface for accessing and manipulating the nypl_menus database.
 * 
 * @author Professor MacKellar
 * @author Randy Gingeleski
 */
public class MenuDBAccess {
    
    static final class FIELDS {
        static final String MENU_ID = "menu_id";
        static final String NAME = "name";
        static final String SPONSOR = "sponsor";
        static final String EVENT = "event";
        static final String VENUE = "venue";
        static final String PLACE = "place";
        static final String PHYSICAL_DESCRIPTION = "physical_description";
        static final String OCCASION = "occasion";
        static final String NOTES = "notes";
        static final String CALL_NUMBER = "call_number";
        static final String KEYWORDS = "keywords";
        static final String LANGUAGE = "language";
        static final String MENU_DATE = "menu_date";
        static final String LOCATION = "location";
        static final String LOCATION_TYPE = "location_type";
        static final String CURRENCY = "currency";
        static final String CURRENCY_SYMBOL = "currency_symbol";
        static final String STATUS = "status";
        static final String PAGE_COUNT = "page_count";
        static final String DISH_COUNT = "dish_count";
    }
    
    private static Connection conn;
    private static final String QUOTE = "\"";
    
    /**
     * Attempts to find and build a Menu based on a passed-in SQL query.
     * 
     * @param query - a SQL query.
     * @return Menu
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<Menu> retrieve(String query)
            throws ClassNotFoundException, SQLException {
        
        ArrayList<Menu> menus;
        
        conn = DBConnection.getMyConnection();
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        if(!rs.next())
            menus = null; // If no results, ArrayList should be empty.
        else
            menus = buildMenuList(rs);

        stmt.close();
        return menus;
    }
    
    /**
     * Returns a single Menu object based on menu_id.
     * There is a one-to-one relationship between Menu and menu_id.
     * 
     * @param menu_id
     * @return Menu
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static Menu retrieveByID(String menu_id) throws ClassNotFoundException, 
            SQLException {
        
        String query = ("SELECT * FROM `nypl_menus`.`menus` WHERE menu_id = "
                + menu_id);

        return retrieve(query).get(0);
    }
 
    /**
     * Returns an ArrayList of Menu objects matching this venue.
     * 
     * @param venue
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static ArrayList<Menu> searchByVenue(String venue) throws
            ClassNotFoundException, SQLException {
        
        String query = ("SELECT * FROM `nypl_menus`.`menus` WHERE location LIKE"
            + " '" + venue + "';");
        
        return retrieve(query);
    }
 
    /**
     * Returns an ArrayList of Menu objects matching this place.
     * 
     * @param place
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static ArrayList<Menu> searchByPlace(String place) throws
            ClassNotFoundException, SQLException {
        
        String query = ("SELECT * FROM `nypl_menus`.`menus` WHERE place LIKE " +
            "'" + place + "';");
        
        return retrieve(query);
    }

    /**
     * Returns an ArrayList of Menu objects that contain a given Dish.
     * 
     * @param thisDish - Dish to search all Menus for.
     * @return ArrayList<Menu> - an ArrayList of Menu objects with that Dish.
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static ArrayList<Menu> searchByDish(Dish thisDish) throws
            ClassNotFoundException, SQLException {
        
        String dishID = Integer.toString(thisDish.getDish_id());
        
        String query = ("SELECT * "
                + "FROM nypl_menus.menu_items"
                + "JOIN nypl_menus.menu_pages "
                + "ON nypl_menus.menu_pages.menu_page_id = "
                    + "nypl_menus.menu_items.menu_page_id "
                + "WHERE nypl_menus.menu_items.dish_id = " + dishID + " "    
                + "GROUP BY nypl_menus.menu_pages.menu_id;");
        
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
    public static ArrayList<Integer> getDishIDsFromName(String dishName) throws
            ClassNotFoundException, SQLException {
        
        ArrayList<Integer> dishIDList = new ArrayList<Integer>();
        
        String query = "SELECT dish_id " +
                       "FROM `nypl_menus`.`dishes` " +
                       "WHERE name LIKE '" + dishName + "';";
        
        conn = DBConnection.getMyConnection();
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        if(!rs.next()) {
            dishIDList = null; // If no results, ArrayList should be empty.
        } else {
            while (rs.next()) {
                int thisDishID = rs.getInt("dish_id");
                dishIDList.add(thisDishID);
            }
        }
        
        stmt.close();
        return dishIDList;
    }
 
    /**
     * Returns an ArrayList of Menu objects matching given year parameters.
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
            
            query += "SELECT * FROM `nypl_menus`.`menus` " +
                "WHERE YEAR(menu_date) = " + Integer.toString(yearParams[0]) +
                ";";
        
        } else if (yearParams[0] == 0) {
            
            query += "SELECT * FROM `nypl_menus`.`menus` " +
                "WHERE YEAR(menu_date) < " + Integer.toString(yearParams[1]) +
                ";";
            
        } else if (yearParams[1] == 0) {
            
            query += "SELECT * FROM `nypl_menus`.`menus` " +
                "WHERE YEAR(menu_date) > " + Integer.toString(yearParams[0]) +
                ";";
            
        } else {
            
            query += "SELECT * FROM `nypl_menus`.`menus` " +
                "WHERE YEAR(menu_date) > " + Integer.toString(yearParams[0]) +
                "AND YEAR(menu_date) < " + Integer.toString(yearParams[1]) +
                ";";
            
        }
        
        return retrieve(query);
    }
 
    /**
     * Returns an ArrayList of Menu objects matching this currency.
     * 
     * @param currency
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static ArrayList<Menu> searchByCurrency(String currency) throws
            ClassNotFoundException, SQLException {
        
        String query = ("SELECT * FROM `nypl_menus`.`menus` WHERE currency = " +
            "'" + currency + "';");
        
        return retrieve(query);
    }
    
    /**
     * Returns an ArrayList of Menu objects matching this event.
     * 
     * @param event
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException 
     */    
    public static ArrayList<Menu> searchByEvent(String event) throws
            ClassNotFoundException, SQLException {
        
        String query = ("SELECT * FROM `nypl_menus`.`menus` WHERE event = " +
            "'" + event + "';");
        
        return retrieve(query);
    }
    
    /**
     * Returns an ArrayList of Menu objects matching this sponsor.
     * 
     * @param sponsor
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static ArrayList<Menu> searchBySponsor(String sponsor) throws
            ClassNotFoundException, SQLException {
        
        String query = ("SELECT * FROM `nypl_menus`.`menus` WHERE sponsor = " +
            "'" + sponsor + "';");
        
        return retrieve(query);
    }
    
    /**
     * Returns an ArrayList of Menu objects matching this occasion.
     * 
     * @param occasion
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException 
     */   
    public static ArrayList<Menu> searchByOccasion(String occasion) throws
            ClassNotFoundException, SQLException {
        
        String query = ("SELECT * FROM `nypl_menus`.`menus` WHERE occasion = " +
            "'" + occasion + "';");
        
        return retrieve(query);
    }
    
    /**
     * Returns an ArrayList of Menu objects matching given page count
     * parameters.
     * 
     * @param pageCountParams
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException 
     */    
    public static ArrayList<Menu> searchByPageCount(int[] pageCountParams)
            throws ClassNotFoundException, SQLException {
        
        String query = "";
        
        // This method shouldn't called with the array [0, 0]
        // Checking for that earlier
        if (pageCountParams[0] == pageCountParams[1]) {
            
            query += "SELECT * FROM `nypl_menus`.`menus` " +
                "WHERE page_count = " + Integer.toString(pageCountParams[0]) +
                ";";
        
        } else if (pageCountParams[0] == 0) {
            
            query += "SELECT * FROM `nypl_menus`.`menus` " +
                "WHERE page_count < " + Integer.toString(pageCountParams[1]) +
                ";";
            
        } else if (pageCountParams[1] == 0) {
            
            query += "SELECT * FROM `nypl_menus`.`menus` " +
               "WHERE page_count > " + Integer.toString(pageCountParams[0])
               + ";";
            
        } else {
            
            query += "SELECT * FROM `nypl_menus`.`menus` " +
                "WHERE page_count > " + Integer.toString(pageCountParams[0]) +
                "AND page_count < " + Integer.toString(pageCountParams[1]) +";"; 
        }
        
        return retrieve(query);
    }
    
    /**
     * Returns an ArrayList of Menu objects matching given dish count
     * parameters.
     * 
     * @param dishCountParams
     * @return ArrayList<Menu>
     * @throws ClassNotFoundException
     * @throws SQLException 
     */          
    public static ArrayList<Menu> searchByDishCount(int[] dishCountParams)
            throws ClassNotFoundException, SQLException {
        
        String query = "";
        
        // This method shouldn't called with the array [0, 0]
        // Checking for that earlier
        if (dishCountParams[0] == dishCountParams[1]) {
            
            query += "SELECT * FROM `nypl_menus`.`menus` " +
                "WHERE dish_count = " + Integer.toString(dishCountParams[0]) +
                ";";
        
        } else if (dishCountParams[0] == 0) {
            
            query += "SELECT * FROM `nypl_menus`.`menus` " +
                "WHERE dish_count < " + Integer.toString(dishCountParams[1]) +
                ";";
            
        } else if (dishCountParams[1] == 0) {
            
            query += "SELECT * FROM `nypl_menus`.`menus` " +
               "WHERE dish_count > " + Integer.toString(dishCountParams[0])
               + ";";
            
        } else {
            
            query += "SELECT * FROM `nypl_menus`.`menus` " +
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
        
        // Aggregate search results as we go along, parameter by parameter,
        // then cross-reference to filter a final ArrayList<Menu>.
        List<List<Menu>> aggregateResults = new ArrayList<List<Menu>>();
        
        // There are auxiliary methods that execute SQL for each parameter.
        
        // All searches are relatively easy except for a "general query",
        // where we have no idea what it is and the user wants to search
        // everything.
        if (paramSet.getGeneralQuery() != null) {
            
            // First check to see if query is a number, will help
            // deduce what was meant
            if ( isNumber(paramSet.getGeneralQuery()) ) {
                
                // Number? Then query could be an ID
                ArrayList<Menu> idResults = new ArrayList<Menu>();
                idResults.add( retrieveByID( paramSet.getGeneralQuery() ) );
                
                aggregateResults.add( idResults );
                
                // Could be a year
                int x = Integer.parseInt( paramSet.getGeneralQuery() );
                int[] testYear = {x, x};
                aggregateResults.add( searchByYear( testYear ) );
                
                // Could be a page count
                int y = Integer.parseInt( paramSet.getGeneralQuery() );
                int[] testPageCount = {y, y};
                aggregateResults.add( searchByPageCount( testPageCount ) );
            
                // Could be a dish count
                int z = Integer.parseInt( paramSet.getGeneralQuery() );
                int[] testDishCount = {z, z};
                aggregateResults.add( searchByDishCount( testDishCount ) );
            }
            
            // If it's not a number, try everything else for results
            else {
                
                // Could be a venue
                aggregateResults.add ( searchByVenue( paramSet.getGeneralQuery() ) );
            
                // Could be a place
                aggregateResults.add ( searchByPlace( paramSet.getGeneralQuery() ) );
            
                // Could be a dish
                ArrayList<Integer> dishIDResults = 
                        getDishIDsFromName( paramSet.getGeneralQuery() );
                
                for (int dishID : dishIDResults) {   
                    Dish thisDish = new Dish(dishID);
                    aggregateResults.add( searchByDish(thisDish) );
                }
            
                // Could be a currency
                aggregateResults.add ( searchByCurrency(
                        paramSet.getGeneralQuery() ) );
            
                // Could be an event
                aggregateResults.add ( searchByEvent( 
                        paramSet.getGeneralQuery() ) );
            
                // Could be a sponsor
                aggregateResults.add ( searchBySponsor(
                        paramSet.getGeneralQuery() ) );
            
                // Could be an occasion
                aggregateResults.add ( searchByOccasion(
                        paramSet.getGeneralQuery() ) );
            }
                 
            // This seems to be how the NYPL Menus site works now - take
            // what the user typed in and just sloppily search everything.
            
            // But before returning results from the general search - were
            // more specific queries made? If not, return. If so, go on and
            // we'll have to filter.
            SearchParameters defaultParams = new
                SearchParameters(paramSet.getGeneralQuery());
            
            if(defaultParams.equals(paramSet)) {
                
                ArrayList<Menu> returnResults = new ArrayList<Menu>();
                
                Iterator<List<Menu>> aggregateResultsIterator =
                        aggregateResults.iterator();
                
                while (aggregateResultsIterator.hasNext()) {
                    returnResults.addAll(aggregateResultsIterator.next());
                }
                
                if (returnResults.isEmpty()) { return null; }
                else { return returnResults; }
            }
            
            // Possibly the user made a general query and one more specific.
            // Method goes on to check for other parameters, add those results
            // to the aggregate, and ultimately it all gets filtered down.
        }
        
        if (paramSet.getMenu_id() != 0) {
                ArrayList<Menu> idResults2 = new ArrayList<Menu>();
                
                idResults2.add( retrieveByID( 
                        Integer.toString(paramSet.getMenu_id()) ) );
                
                aggregateResults.add( idResults2 );
        }
        
        if (paramSet.getVenue() != null) {
            aggregateResults.add ( searchByVenue( paramSet.getVenue() ) );          
        }
        
        if (paramSet.getPlace() != null) {
            aggregateResults.add ( searchByPlace( paramSet.getPlace() ) );                        
        }
        
        if (paramSet.getDish() != null) {
            ArrayList<Integer> dishIDResults2 = 
                   getDishIDsFromName( paramSet.getDish() );
                
            for (int dishID : dishIDResults2) {   
                Dish thisDish = new Dish(dishID);
                aggregateResults.add( searchByDish(thisDish) );
            }                      
        }
        
        if ((paramSet.getYear()[0] != 0) && (paramSet.getYear()[1] != 0)) {
            aggregateResults.add( searchByYear( paramSet.getYear() ));
        }
        
        if (paramSet.getCurrency() != null) {
            aggregateResults.add ( searchByCurrency( paramSet.getCurrency() ));             
        }
        
        if (paramSet.getEvent() != null) {
            aggregateResults.add ( searchByEvent( paramSet.getEvent() ) );             
        }        

        if (paramSet.getSponsor() != null) {
            aggregateResults.add ( searchBySponsor( paramSet.getSponsor() ) );             
        }
        
        if (paramSet.getOccasion() != null) {
            aggregateResults.add ( searchByOccasion( paramSet.getOccasion() ) );             
        }             
        
        if ((paramSet.getPageCount()[0] != 0) || 
                (paramSet.getPageCount()[1] != 0)) {
            
            aggregateResults.add( searchByPageCount( paramSet.getPageCount() ));            
        }
        
        if ((paramSet.getDishCount()[0] != 0) || 
                (paramSet.getDishCount()[1] != 0)) {
            
            aggregateResults.add( searchByDishCount( paramSet.getDishCount() ));            
        }   
        
        // At this point, if aggregateResults is empty, the search was a bust.
        if ( aggregateResults.isEmpty() ) {    
            return null;
            
        } else {
            
            // This is where aggregateResults gets sorted - it's a list of
            // ArrayLists, and what we want is the intersection of those
            // ArrayLists' contents. Step by step it gets filtered down until
            // a clean product can be returned.
            ArrayList<Menu> returnResults = new ArrayList<Menu>();
                
            Iterator<List<Menu>> aggregateResultsIterator =
                aggregateResults.iterator();
            
            while (aggregateResultsIterator.hasNext()) {
                // If returnResults is empty, it would be erroneous to
                // seek out the common elements. So a simple addAll will do.
                if (returnResults.isEmpty()) { 
                    returnResults.addAll(aggregateResultsIterator.next());
                
                } else {
                   
                    // Apache Commons Collection has a retainAll method
                    // that works well here. We have to turn the ArrayList<Menu>
                    // objects into Collections...
                    Collection<Menu> list1 = returnResults;
                    Collection<Menu> list2 = aggregateResultsIterator.next();
                    
                    Collection<Menu> commonList = 
                            CollectionUtils.retainAll(list1, list2);
                    
                    // ... then can change back to returnResults with the
                    // common elements.
                    returnResults = new ArrayList(commonList);
                }
            }
            
            return returnResults;  
        }
    }
      
    /**
     * Builds one Menu object from the current row in the result set.
     * 
     * @param rs - a SQL query ResultSet.
     * @return Menu
     * @throws SQLException 
     */
    private static Menu buildMenu(ResultSet rs) throws SQLException {
        
        int menu_id = rs.getInt(FIELDS.MENU_ID);
        String name = rs.getString(FIELDS.NAME);
        String sponsor = rs.getString(FIELDS.SPONSOR);
        String event = rs.getString(FIELDS.EVENT);
        String venue = rs.getString(FIELDS.VENUE);
        String place = rs.getString(FIELDS.PLACE);
        String physical_description = rs.getString(FIELDS.PHYSICAL_DESCRIPTION);
        String occasion = rs.getString(FIELDS.OCCASION);
        String notes = rs.getString(FIELDS.NOTES);
        String call_number = rs.getString(FIELDS.CALL_NUMBER);
        String keywords = rs.getString(FIELDS.KEYWORDS);
        String language = rs.getString(FIELDS.LANGUAGE);
        LocalDate menu_date = LocalDate.parse(rs.getString(FIELDS.MENU_DATE));
        String location = rs.getString(FIELDS.LOCATION);
        String location_type = rs.getString(FIELDS.LOCATION_TYPE);
        String currency = rs.getString(FIELDS.CURRENCY);
        String currency_symbol = rs.getString(FIELDS.CURRENCY_SYMBOL);
        String status = rs.getString(FIELDS.STATUS);
        int page_count = rs.getInt(FIELDS.PAGE_COUNT);
        int dish_count = rs.getInt(FIELDS.DISH_COUNT);

        Menu menu = new Menu(menu_id, name, sponsor, event, venue, place,
            physical_description, occasion, notes, call_number, keywords,
            language, menu_date, location, location_type, currency,
            currency_symbol, status, page_count, dish_count);
        
        return menu;
    }
    
    /**
     * Builds an ArrayList of Menu objects from a whole result set.
     * 
     * @param rs - a SQL query result set.
     * @return ArrayList<Menu>
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
    
    /**
     * Tests a String to see if it's a number.
     * Used in the complex search method for "general queries" where
     * it's unsure what the user meant.
     * 
     * @param toTest - String that may or may not be a number
     * @return true/false
     */
    private static Boolean isNumber(String toTest) {
        try {  
            double d = Double.parseDouble(toTest);  
        } catch(NumberFormatException nfe) {  
            return false;  
        }  
        
        return true; 
    }
}
