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
    
    public SearchParametersTest() {
    }

    /**
     * Test of equals method, of class SearchParameters.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        SearchParameters testParam = new SearchParameters("578");
        SearchParameters instance = new SearchParameters();
        instance.setOccasion("Easter");
        Boolean expResult = false;
        Boolean result = instance.equals(testParam);
        assertEquals(expResult, result);
    }   
}
