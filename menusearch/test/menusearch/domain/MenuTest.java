package menusearch.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the Menu class with JUnit.
 * 
 * @author Randy Gingeleski
 */
public class MenuTest {
    
    public MenuTest() { }

    @Test
    public void testSetGetName() {
        Menu testMenu = new Menu(12345);
        testMenu.setName("Denny's Menu");
        
        assertEquals("Denny's Menu", testMenu.getName());
    }
    
    @Test
    public void testSetGetEvent() {
        Menu testMenu = new Menu(67890);
        testMenu.setEvent("Easter Dinner");
        
        assertEquals("Easter Dinner", testMenu.getEvent());
    }
}
