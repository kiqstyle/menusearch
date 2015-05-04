/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.db;

import java.util.ArrayList;
import menusearch.domain.Dish;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ksmit001
 */
public class DishDBAccessTest {
    
    public DishDBAccessTest() {
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
     * Test of retrieveByID method, of class DishDBAccess.
     */
    @Test
    public void testRetrieveByID() throws Exception {
        System.out.println("retrieveByID");
        int dish_id = 0;
        Dish expResult = null;
        Dish result = DishDBAccess.retrieveByID(dish_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveByMenuItemID method, of class DishDBAccess.
     */
    @Test
    public void testRetrieveByMenuItemID() throws Exception {
        System.out.println("retrieveByMenuItemID");
        int menuItemID = 0;
        Dish expResult = null;
        Dish result = DishDBAccess.retrieveByMenuItemID(menuItemID);
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieveByMenu method, of class DishDBAccess.
     */
    @Test
    public void testRetrieveByMenu() throws Exception {
        System.out.println("retrieveByMenu");
        int menu_id = 0;
        int expResult = menu_id;
        ArrayList<Dish> result = DishDBAccess.retrieveByMenu(menu_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
