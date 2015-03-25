/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.db;

import java.util.ArrayList;
import menusearch.domain.Dish;
import menusearch.domain.Menu;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rging620
 */
public class MenuDBAccessTest {
    
    public MenuDBAccessTest() {
    }

    /**
     * Test of retrieve method, of class MenuDBAccess.
     */
    @Test
    public void testRetrieve() throws Exception {
        System.out.println("retrieve");
        String query = "";
        ArrayList<Menu> expResult = null;
        ArrayList<Menu> result = MenuDBAccess.retrieve(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveByID method, of class MenuDBAccess.
     */
    @Test
    public void testRetrieveByID() throws Exception {
        System.out.println("retrieveByID");
        String menu_id = "";
        Menu expResult = null;
        Menu result = MenuDBAccess.retrieveByID(menu_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByVenue method, of class MenuDBAccess.
     */
    @Test
    public void testSearchByVenue() throws Exception {
        System.out.println("searchByVenue");
        String venue = "";
        ArrayList<Menu> expResult = null;
        ArrayList<Menu> result = MenuDBAccess.searchByVenue(venue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByPlace method, of class MenuDBAccess.
     */
    @Test
    public void testSearchByPlace() throws Exception {
        System.out.println("searchByPlace");
        String place = "";
        ArrayList<Menu> expResult = null;
        ArrayList<Menu> result = MenuDBAccess.searchByPlace(place);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByDish method, of class MenuDBAccess.
     */
    @Test
    public void testSearchByDish() throws Exception {
        System.out.println("searchByDish");
        Dish thisDish = null;
        ArrayList<Menu> expResult = null;
        ArrayList<Menu> result = MenuDBAccess.searchByDish(thisDish);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDishIDsFromName method, of class MenuDBAccess.
     */
    @Test
    public void testGetDishIDsFromName() throws Exception {
        System.out.println("getDishIDsFromName");
        String dishName = "";
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = MenuDBAccess.getDishIDsFromName(dishName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByYear method, of class MenuDBAccess.
     */
    @Test
    public void testSearchByYear() throws Exception {
        System.out.println("searchByYear");
        int[] yearParams = null;
        ArrayList<Menu> expResult = null;
        ArrayList<Menu> result = MenuDBAccess.searchByYear(yearParams);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByCurrency method, of class MenuDBAccess.
     */
    @Test
    public void testSearchByCurrency() throws Exception {
        System.out.println("searchByCurrency");
        String currency = "";
        ArrayList<Menu> expResult = null;
        ArrayList<Menu> result = MenuDBAccess.searchByCurrency(currency);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByEvent method, of class MenuDBAccess.
     */
    @Test
    public void testSearchByEvent() throws Exception {
        System.out.println("searchByEvent");
        String event = "";
        ArrayList<Menu> expResult = null;
        ArrayList<Menu> result = MenuDBAccess.searchByEvent(event);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchBySponsor method, of class MenuDBAccess.
     */
    @Test
    public void testSearchBySponsor() throws Exception {
        System.out.println("searchBySponsor");
        String sponsor = "";
        ArrayList<Menu> expResult = null;
        ArrayList<Menu> result = MenuDBAccess.searchBySponsor(sponsor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByOccasion method, of class MenuDBAccess.
     */
    @Test
    public void testSearchByOccasion() throws Exception {
        System.out.println("searchByOccasion");
        String occasion = "";
        ArrayList<Menu> expResult = null;
        ArrayList<Menu> result = MenuDBAccess.searchByOccasion(occasion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByPageCount method, of class MenuDBAccess.
     */
    @Test
    public void testSearchByPageCount() throws Exception {
        System.out.println("searchByPageCount");
        int[] pageCountParams = null;
        ArrayList<Menu> expResult = null;
        ArrayList<Menu> result = MenuDBAccess.searchByPageCount(pageCountParams);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByDishCount method, of class MenuDBAccess.
     */
    @Test
    public void testSearchByDishCount() throws Exception {
        System.out.println("searchByDishCount");
        int[] dishCountParams = null;
        ArrayList<Menu> expResult = null;
        ArrayList<Menu> result = MenuDBAccess.searchByDishCount(dishCountParams);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveByComplexSearch method, of class MenuDBAccess.
     */
    @Test
    public void testRetrieveByComplexSearch() throws Exception {
        System.out.println("retrieveByComplexSearch");
        SearchParameters paramSet = null;
        ArrayList<Menu> expResult = null;
        ArrayList<Menu> result = MenuDBAccess.retrieveByComplexSearch(paramSet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
