package db;

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
    public void testRetrieveByID_getID() {
        
        Menu testMenu = null;
        
        try {
            testMenu = MenuDBAccess.retrieveByID("12463");
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
    public void testRetrieveByID_getSponsor() {
        Menu testMenu = null;
        
        try {
            testMenu = MenuDBAccess.retrieveByID("12463");
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
    public void testRetrieveByID_getEvent() {
                
        Menu testMenu = null;
        
        try {
            testMenu = MenuDBAccess.retrieveByID("12463");
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
    public void testRetrieveByComplexSearch() throws Exception {
        
        // TODO - This will need to be tested more extensively than the
        //        other methods in this file. Multiple tests verifying
        //        results somehow, instead of just verifying yield sizes.
        
        fail("Testing for this method is a work in progress.");
    }
}
