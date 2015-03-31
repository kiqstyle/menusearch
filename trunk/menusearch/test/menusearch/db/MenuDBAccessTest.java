/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.db;

import menusearch.domain.Menu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicolebkim
 */
public class MenuDBAccessTest {
    
    public MenuDBAccessTest() {
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
     * Test of retrieve method, of class MenuDBAccess.
     */
    @Test
    public void testRetrieve() throws Exception {
        System.out.println("retrieve");
        String query = "";
        Menu expResult = null;
  //      Menu result = MenuDBAccess.retrieve(query);
   //     assertEquals(expResult, result);
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
    }

    /**
     * Test of populateMenupages method, of class MenuDBAccess.
     */
    @Test
    public void testPopulateMenupages() throws Exception {
        System.out.println("populateMenupages");
        Menu menu = null;
        MenuDBAccess.populateMenupages(menu);
    }

    /**
     * Test of retrieveByMenuID method, of class MenuDBAccess.
     */
    @Test
    public void testRetrieveByMenuID() throws Exception {
        System.out.println("retrieveByMenuID");
        int id = 0;
        Menu expResult = null;
        Menu result = MenuDBAccess.retrieveByMenuID(id);
        assertEquals(expResult, result);
    }
    
}
