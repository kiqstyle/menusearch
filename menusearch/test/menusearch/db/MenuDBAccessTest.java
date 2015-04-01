package menusearch.db;

import menusearch.domain.Menu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import menusearch.domain.Dish;

/**
 * Tests the MenuDBAccess class with JUnit.
 * 
 * @author Randy Gingeleski
 * @author nicolebkim
 */
public class MenuDBAccessTest {
    
    public MenuDBAccessTest() { }
    
    @Before
    public void setUp() {
    
        try {
            DBConnection.init();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuDBAccessTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        } 
    }

    @Test
    public void testRetrieve_noResult() throws Exception {
        System.out.println("retrieve");
        String query = "";
        Menu expResult = null;

   //   Menu result = MenuDBAccess.retrieve(query).get(0);
   //   assertEquals(expResult, result);
    }
    
    @Test
    public void testRetrieveByMenuID_getID() {
        
        Menu testMenu = null;
        
        try {
            testMenu = MenuDBAccess.retrieveByMenuID("12463");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuDBAccessTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuDBAccessTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        assertEquals(12463, testMenu.getMenu_id());
    }
    
    @Test
    public void testRetrieveByMenuID_getSponsor() {
        Menu testMenu = null;
        
        try {
            testMenu = MenuDBAccess.retrieveByMenuID("12463");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuDBAccessTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuDBAccessTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        assertEquals("HOTEL EASTMAN", testMenu.getSponsor());
    }
    
    @Test
    public void testRetrieveByMenuID_getEvent() {
                
        Menu testMenu = null;
        
        try {
            testMenu = MenuDBAccess.retrieveByMenuID("12463");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuDBAccessTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuDBAccessTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        assertEquals("BREAKFAST", testMenu.getEvent());
    }
  
    @Test
    public void testRetrieveByMenuID_noInput() throws Exception {
        System.out.println("retrieveByID");
        String menu_id = "";
        Menu expResult = null;
        Menu result = MenuDBAccess.retrieveByMenuID(menu_id);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRetrieveByMenuID_noResult() throws Exception {
        System.out.println("retrieveByMenuID");
        String id = "0";
        Menu expResult = null;
        Menu result = MenuDBAccess.retrieveByMenuID(id);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSearchByVenue() throws Exception {
        ArrayList<Menu> testMenus = null;
        
        try {
            testMenus = MenuDBAccess.searchByVenue("Hotel Eastman");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuDBAccessTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuDBAccessTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        assertEquals(5, testMenus.size());
        // Hard-coded to expected SQL results
    }
    
    @Test
    public void testSearchByPlace() throws Exception {
        ArrayList<Menu> testMenus = null;
        
        try {
            testMenus = MenuDBAccess.searchByPlace("En Route");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuDBAccessTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuDBAccessTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        assertEquals(293, testMenus.size());
        // Hard-coded to expected SQL results
    }
    
    @Test
    public void testSearchByDish() throws Exception {

        Dish thisDish = new Dish(12678);
        ArrayList<Menu> result = MenuDBAccess.searchByDish(thisDish);
        
        assertEquals(2, result.size());
    }

    @Test
    public void testGetDishIDsFromName() throws Exception {

        String dishName = "pineapple";
        ArrayList<Integer> result = MenuDBAccess.getDishIDsFromName(dishName);
        
        assertEquals(2, result.size());
    }

    @Test
    public void testSearchByYear_Exact() throws Exception {

        int[] yearParams = {1972, 1972};
        ArrayList<Menu> result = MenuDBAccess.searchByYear(yearParams);
        
        assertEquals(30, result.size());
    }

    @Test
    public void testSearchByCurrency() throws Exception {

        String currency = "Francs";
        ArrayList<Menu> result = MenuDBAccess.searchByCurrency(currency);
        
        assertEquals(162, result.size());
    }

    @Test
    public void testSearchByEvent() throws Exception {

        String event = "Breakfast";
        ArrayList<Menu> result = MenuDBAccess.searchByEvent(event);
        
        assertEquals(926, result.size());
    }

    @Test
    public void testSearchBySponsor() throws Exception {

        String sponsor = "Republican House";
        ArrayList<Menu> result = MenuDBAccess.searchBySponsor(sponsor);
        
        assertEquals(1, result.size());
    }

    @Test
    public void testSearchByOccasion() throws Exception {

        String occasion = "Daily";
        ArrayList<Menu> result = MenuDBAccess.searchByOccasion(occasion);
        
        assertEquals(232, result.size());
    }

    @Test
    public void testSearchByPageCount_Exact() throws Exception {

        int[] pageCountParams = {31, 31};
        ArrayList<Menu> result = 
                MenuDBAccess.searchByPageCount(pageCountParams);
        
        assertEquals(2, result.size());
    }

    @Test
    public void testSearchByDishCount_Exact() throws Exception {

        int[] dishCountParams = {72, 72};
        ArrayList<Menu> result = 
                MenuDBAccess.searchByDishCount(dishCountParams);
        
        assertEquals(89, result.size());
    }

    @Test
    public void testRetrieveByComplexSearch_justGeneral() throws Exception {
        
        // General query
        SearchParameters params = new SearchParameters("New York");
        
        ArrayList<Menu> result = MenuDBAccess.retrieveByComplexSearch(params);
        
        assertEquals(70, result.size()); // Expecting 70 results
    }
    
    @Test
    public void testRetrieveByComplexSearch_generalWithYear() throws Exception {
        
        // General query
        SearchParameters params = new SearchParameters("New York");
        
        int[] yearArray = {1900, 1900}; // Filter to year 1900
        params.setYear(yearArray);
        
        ArrayList<Menu> result = MenuDBAccess.retrieveByComplexSearch(params);
        
        assertEquals(19, result.size()); // Expecting 19 results
    }

    @Test
    public void testPopulateMenupages() throws Exception {
        System.out.println("populateMenupages");
        Menu menu = null;
        MenuDBAccess.populateMenupages(menu);
    }    
}
