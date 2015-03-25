/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.json;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mackellb
 */
public class JSONProcessorTest {
    
    public JSONProcessorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getRecipeAPI method, of class JSONProcessor.
     */
    @Test
    public void testGetRecipeAPI() throws Exception {
        System.out.println("getRecipeAPI");
        String searchValue = "Taco";
        String expResult = "";
        String result = JSONProcessor.getRecipeAPI(searchValue);
        System.err.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
    }

    /**
     * Test of buildQuery method, of class JSONProcessor.
     */
    @Test
    public void testBuildQuery() throws Exception {
        System.out.println("buildQuery");
        Parameters p = new Parameters();
        p.addAllowedCourses("dinner");
        p.setSearchPhrase("tacos");
        String expResult = "";
        String result = JSONProcessor.buildQuery(p);
        System.err.println(result);
   //     assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
    }

    /**
     * Test of searchYummly method, of class JSONProcessor.
     */
    @Test
    public void testSearchYummly() throws Exception {
        System.out.println("searchYummly");
        String query = "";
        String expResult = "";
        String result = JSONProcessor.searchYummly(query);
        System.err.println(result);
    //    assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
   //     fail("The test case is a prototype.");
    }
    
}
