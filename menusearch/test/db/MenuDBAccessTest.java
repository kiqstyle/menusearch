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
}
