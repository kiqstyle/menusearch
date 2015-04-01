/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.json;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import menusearch.json.RecipeSummary;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kennethngai
 */
public class recipeSummaryTest {
    
    public recipeSummaryTest() {
    
   
    
    }
    

    
    @Before
    public void setUp() throws IOException {
   
    }
    
    @Test
    public void htmlParse() {
     String testHtml = "Recipe search powered by <a href='http://www.yummly.com/recipes'><img alt='Yummly' src='http://static.yummly.com/api-logo.png'/></a>";
    String s = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&";
    RecipeSummary r = new RecipeSummary();
//      try {
//          r.parseRecipes(s);
//      } catch (IOException ex) {
//          Logger.getLogger(recipeSummaryTest.class.getName()).log(Level.SEVERE, null, ex);
//      }
        assertEquals(r.getHtml(),testHtml);
    }
    
    @Test
    public void urlParse(){
     String testUrl = "http://www.yummly.com/recipes/";
     String s = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&";
    RecipeSummary r = new RecipeSummary();
//      try {
//          r.parseRecipes(s);
//      } catch (IOException ex) {
//          Logger.getLogger(recipeSummaryTest.class.getName()).log(Level.SEVERE, null, ex);
//      }
      assertEquals(r.getUrl(), testUrl);
        
        
    }
    
    @Test
    public void textParse() {
     String testText = "Recipe search powered by Yummly";
     String s = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&q=garlic";
    RecipeSummary r = new RecipeSummary();
//      try {
//          r.parseRecipes(s);
//     } catch (IOException ex) {
//          Logger.getLogger(recipeSummaryTest.class.getName()).log(Level.SEVERE, null, ex);
//      }
       assertEquals(r.getText(), testText);
        
    }
    
    @Test
    public void logoParse(){
     String testLogo = "http://static.yummly.com/api-logo.png";   
     String s = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&q=garlic";
    RecipeSummary r = new RecipeSummary();
//      try {
//          r.parseRecipes(s);
//      } catch (IOException ex) {
//          Logger.getLogger(recipeSummaryTest.class.getName()).log(Level.SEVERE, null, ex);
//      }    
        assertEquals(r.getLogo(),testLogo);
    }
    
    @Test
    public void totalMatchesParse(){
       int testMatches = 911124;
     String s = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&q=garlic";
    RecipeSummary r = new RecipeSummary();
//      try {
//          r.parseRecipes(s);
//      } catch (IOException ex) {
//          Logger.getLogger(recipeSummaryTest.class.getName()).log(Level.SEVERE, null, ex);
//      }        
        assertEquals(r.getTotalMatches(), testMatches);
        
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
