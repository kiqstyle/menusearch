package menusearch.db;

import menusearch.db.SearchParameters;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the SearchParameters class with JUnit.
 * 
 * @author Randy Gingeleski
 */
public class SearchParametersTest {

    /**
     * Test of equals method, of class SearchParameters.
     */
    @Test
    public void testEquals_equalByGeneralQuery() {
        
        SearchParameters testParam = new SearchParameters("578");
        SearchParameters instance = new SearchParameters("578");

        Boolean expResult = true;
        Boolean result = instance.equals(testParam);
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class SearchParameters.
     */
    @Test
    public void testEquals_unequalByGeneralQuery() {
        
        SearchParameters testParam = new SearchParameters("123");
        SearchParameters instance = new SearchParameters("456");

        Boolean expResult = false;
        Boolean result = instance.equals(testParam);
        
        assertEquals(expResult, result);
    }
}
