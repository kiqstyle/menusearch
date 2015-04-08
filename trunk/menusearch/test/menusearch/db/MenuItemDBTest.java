/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.db;

import java.sql.ResultSet;
import menusearch.domain.MenuItem;
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
public class MenuItemDBTest {
    
    public MenuItemDBTest() {
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
     * Test of retrieveByID method, of class MenuItemDB.
     */
    @Test
    public void testRetrieveByID() throws Exception {
        System.out.println("retrieveByID");
        int id = 22;
        MenuItem result = MenuItemDB.retrieveByID(id);
        assertEquals(22, "Tomato aux croutons");
    }


    /**
     * Test of populateDish method, of class MenuItemDB.
     */
    @Test
    public void testPopulateDish() throws Exception {
        System.out.println("populateDish");
        MenuItem item = null;
        MenuItemDB.populateDish(item);
    }
    
}
