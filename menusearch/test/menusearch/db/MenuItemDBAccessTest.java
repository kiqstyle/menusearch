package menusearch.db;

import java.sql.ResultSet;
import menusearch.domain.MenuItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author nicolebkim
 */
public class MenuItemDBAccessTest {

    /**
     * Test of retrieveByID method, of class MenuItemDBAccess.
     * 
     * Indirectly also tests populateMenuItem()
     */
    @Test
    public void testRetrieveByID() throws Exception {
        
        System.out.println("retrieveByID");
        
        int id = 22;
        
        MenuItem result = MenuItemDBAccess.retrieveByID(id);
        MenuItemDBAccess.populateMenuItem(result);
        
        assertEquals( "Pate de foies-gras", result.getDish().getName() );
    }
    
    @Test
    public void testRetrieveByMenuID() throws Exception {
        
        int itemArrayListSize = 0;
        
        ArrayList<MenuItem> itemArrayList = 
                MenuItemDBAccess.retrieveByMenuPageID("130");
        
        itemArrayListSize = itemArrayList.size();
        
        assertEquals(67, itemArrayListSize);
        // Should get 67 results for MenuPage ID 130
    }
}
