/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.logic;

import java.util.ArrayList;
import menusearch.domain.Menu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author estevamgarcia
 */
public class MenuSearcherTest {
    
    public MenuSearcherTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of MenuSearcher method, of class MenuSearcher.
     */
    @Test
    public void testMenuSearcher() {
        System.out.println("MenuSearcher");
        int id = 0;
        int[] year = null;
        String sponsor = "sponsor";
        String event = "event";
        String venue = "venue";
        String place = "place";
        String occasion = "occasion";
        String location = "location";
        String currency = "currency";
        String Dish = "dish";
        int[] pageCount = null;
        int[] dishCount = null;
        MenuSearcher instance = new MenuSearcher();
        ArrayList<Menu> expResult = null;
        ArrayList<Menu> result = instance.searchByKeyword(id, year, sponsor, event, venue, place, occasion, location, currency, Dish, pageCount, dishCount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
