package menusearch.db;

import menusearch.db.*;
import menusearch.domain.*;
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

/**
 * Tests the MenuDBAccess class with JUnit.
 * 
 * @author Randy Gingeleski
 * @author Nicole Kim
 */
public class MenuDBAccessTest {
    
    public void printTestHeader() {
        
        System.out.print("STARTING ");
        System.out.println(
                Thread.currentThread().getStackTrace()[2].getMethodName());
    }
    
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
    public void testRetrieveByMenuID_12463_getID() {
        
        printTestHeader();
        
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
    public void testRetrieveByMenuID_12463_getSponsor() {
        
        printTestHeader();
        
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
    public void testRetrieveByMenuID_12463_getEvent() {
        
        printTestHeader();
        
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
    public void testSearchByDish_12678() throws Exception {
        
        printTestHeader();
        
        Dish thisDish = new Dish(12678);
        ArrayList<Menu> result = MenuDBAccess.searchByDish(thisDish);
        
        assertEquals(2, result.size());
        // Expecting 2 results from this SQL query
    }
    
    @Test
    public void testGetDishIDsByName_Fish() throws Exception {
        
        printTestHeader();
        
        ArrayList<Integer> result = 
                MenuDBAccess.getDishIDsByName("Fish");
        
        assertEquals(3, result.size());
        // Expecting 3 results from this SQL query
    }
    
    @Test
    public void testSearchByVenue_HotelEastman() throws Exception {
        
        printTestHeader();
        
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
        // Expecting 5 results from this SQL query
    }
    
    @Test
    public void testSearchByPlace_EnRoute() throws Exception {
        
        printTestHeader();
        
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
        // Expecting 293 results from this SQL query
    }
    
    @Test
    public void testSearchByCurrency_Francs() throws Exception {
        
        printTestHeader();
        
        ArrayList<Menu> testMenus = null;
        
        try {
            testMenus = MenuDBAccess.searchByCurrency("Francs");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuDBAccessTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuDBAccessTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        assertEquals(162, testMenus.size());
        // Hard-coded, expecting 162 results
    }

    @Test
    public void testSearchByEvent_Breakfast() throws Exception {
        
        printTestHeader();
        
        ArrayList<Menu> result = MenuDBAccess.searchByEvent("Breakfast");
        
        assertEquals(926, result.size()); // Hard-coded, expecting 926 results
    }

    @Test
    public void testSearchBySponsor_NewYork() throws Exception {
        
        printTestHeader();
        
        String sponsor = "New York";
        ArrayList<Menu> result = MenuDBAccess.searchBySponsor(sponsor);
        
        assertEquals(1, result.size());
        // Expecting 1 result from this SQL query
    }

    @Test
    public void testSearchByOccasion_Daily() throws Exception {
        
        printTestHeader();
        
        ArrayList<Menu> testMenus = null;
        
        try {
            testMenus = MenuDBAccess.searchByOccasion("Daily");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuDBAccessTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuDBAccessTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        assertEquals(232, testMenus.size());
        // Expecting 232 results from this SQL query
    }
    
    @Test
    public void testSearchByYear_Exact1972() throws Exception {
        
        printTestHeader();
        
        int[] yearParams = {1972, 1972};
        ArrayList<Menu> result = MenuDBAccess.searchByYear(yearParams);
        
        assertEquals(30, result.size());
        // Expecting 30 results from this SQL query
    }
    
    @Test
    public void testSearchByPageCount_Exact31() throws Exception {
        
        printTestHeader();
        
        int[] pageCountParams = {31, 31};
        ArrayList<Menu> result = 
                MenuDBAccess.searchByPageCount(pageCountParams);
        
        assertEquals(2, result.size());
        // Expecting 2 results from this SQL query
    }

    @Test
    public void testSearchByDishCount_Exact72() throws Exception {
        
        printTestHeader();
        
        int[] dishCountParams = {72, 72};
        ArrayList<Menu> result = 
                MenuDBAccess.searchByDishCount(dishCountParams);
        
        assertEquals(89, result.size());
        // Expecting 89 results from this SQL query
    }
    
    @Test
    public void testRetrieveByComplexSearch_justGeneral() throws Exception {
        
        printTestHeader();
        
        // General query
        SearchParameters params = new SearchParameters("French");
        
        ArrayList<Menu> result = MenuDBAccess.retrieveByComplexSearch(params);
        
        assertEquals(27, result.size());
    }
    
    @Test
    public void testRetrieveByComplexSearch_generalWithYear() throws Exception {
        
        printTestHeader();
        
        // General query
        SearchParameters params = new SearchParameters("New York");
        
        int[] yearArray = {1900, 1900}; // Filter to year 1900
        params.setYear(yearArray);
        
        ArrayList<Menu> result = MenuDBAccess.retrieveByComplexSearch(params);
        
        assertEquals(81, result.size());
    }
    
    @Test
    public void testRetrieveFullMenuByID_12463_menuPageSize() throws Exception {
        
        printTestHeader();
       
        Menu testMenu = MenuDBAccess.retrieveByMenuID("12463");
        
        Menu populatedTestMenu = MenuDBAccess.retrieveFullMenuByID( testMenu );
        
        ArrayList<MenuPage> menuPageArrayToTest = 
                populatedTestMenu.getMenuPages();
        
        int menuPageArraySize = menuPageArrayToTest.size();
        
        // Menu
        assertEquals(2, menuPageArraySize);
    }
    
    @Test
    public void testRetrieveFullMenuByID_12463_menuItemSize() throws Exception {
        
        printTestHeader();
        
        Menu testMenu = MenuDBAccess.retrieveByMenuID( "12463" );
        
        Menu populatedTestMenu = MenuDBAccess.retrieveFullMenuByID( testMenu );
        
        // Menu 12463 has 2 MenuPages - second and last entry should be ID 130
        MenuPage menuPageForTest = 
                populatedTestMenu.getMenuPages().get(1);
        
        ArrayList<MenuItem> menuItemArrayToTest = 
                menuPageForTest.getMenuItems();
        
        // MenuPage ID 130 has 67 items
        assertEquals(67, menuItemArrayToTest.size() );
    }
}
