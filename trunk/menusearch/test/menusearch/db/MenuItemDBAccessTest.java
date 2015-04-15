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
public class MenuItemDBAccessTest {

    /**
     * Test of retrieveByID method, of class MenuItemDBAccess.
     */
    @Test
    public void testRetrieveByID() throws Exception {
        System.out.println("retrieveByID");
        int id = 22;
        MenuItem result = MenuItemDBAccess.retrieveByID(id);
        assertEquals(22, "Tomato aux croutons");
    }


    /**
     * Test of populateDish method, of class MenuItemDBAccess.
     */
    @Test
    public void testPopulateDish() throws Exception {

        MenuItem item = null;
        MenuItemDBAccess.populateMenuItem(item);
    }
    
}
