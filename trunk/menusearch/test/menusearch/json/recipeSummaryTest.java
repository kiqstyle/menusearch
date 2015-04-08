/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.json;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import menusearch.json.JSONProcessor;
import menusearch.json.RecipeSummaryList;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kennethngai
 */
public class recipeSummaryTest {
    
    private static final double difference = 1e-15;
    

    @Test
    public void imageParse() throws IOException {
    RecipeSummaryList r = new RecipeSummaryList();    
    String testCurrentMatches = "http://lh3.googleusercontent.com/wtZVNS5b4yYvH_KaIoVPigPK0fERG-TykJwgjwUIRUrJSm_p2nUsTzRmHmROoK3AqV0ONlxmd4GH4GRVhF8A=s90-c";
    String s = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&";
   r = JSONProcessor.parseRecipeMatches(s);
   assertEquals(r.matches.get(0).getImageUrlsBySize(), testCurrentMatches);
    }
    
    @Test
    public void sourceNameParse() throws IOException{
    String name = "Amy's Healthy Baking";
    String s = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&";
    RecipeSummaryList r = new RecipeSummaryList();
    r = JSONProcessor.parseRecipeMatches(s);
    assertEquals(r.matches.get(0).getSourceDisplayName(), name);

    }
    
    @Test
    public void ingredientsParse() throws IOException{  
    String ingred = "butternut squash";
    String s = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&";
    RecipeSummaryList r = new RecipeSummaryList();
    r = JSONProcessor.parseRecipeMatches(s);
    assertEquals(r.matches.get(0).getIngredients().getIngredent(0), ingred);
        
    }
    @Test
    public void  idParse() throws IOException{
    String id = "Skinny-Kale-_-Butternut-Squash-Quiche-1062737";
    String s = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&";
    RecipeSummaryList r = new RecipeSummaryList();
    r = JSONProcessor.parseRecipeMatches(s);
    assertEquals(r.matches.get(0).getId(), id);     
    }
    @Test
    public void smallImageUrlsParse() throws IOException{
    String url = "http://lh3.googleusercontent.com/S4DsqE9rB_yfYrpiLjp1rS8Vm3zLXoTK0kJaqj4CGvgxnW9aifMoLFxmkj84y4gvxGMp2z6v8WDryqA8gFmTmw=s90";    
     String s = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&";
    RecipeSummaryList r = new RecipeSummaryList();
    r = JSONProcessor.parseRecipeMatches(s);
    assertEquals(r.matches.get(0).getSmallImageUrls(), url);
    }
    @Test
    public void recipeNameParse() throws IOException{
     String name = "Skinny Kale & Butternut Squash Quiche";
    String s = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&";
    RecipeSummaryList r = new RecipeSummaryList();
    r = JSONProcessor.parseRecipeMatches(s);
    assertEquals(r.matches.get(0).getRecipeName(), name);
   
    }
    @Test
    public void timeParse() throws IOException{
     int sec = 3300;
     String s = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&";
    RecipeSummaryList r = new RecipeSummaryList();
    r = JSONProcessor.parseRecipeMatches(s);
    assertEquals(r.matches.get(0).getTotalTimeInSeconds(), sec);
    }
    @Test
    public void courseParse() throws IOException{
    String course = "Side Dishes";
    String s = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&";
    RecipeSummaryList r = new RecipeSummaryList();
    r = JSONProcessor.parseRecipeMatches(s);
    assertEquals(r.matches.get(1).getCourses().getCourse(1), course);
    }
    
    
    @Test
    public void flavorsParse() throws IOException{
    double sweet = 0.16666666666666666;
    String s = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&";
    RecipeSummaryList r = new RecipeSummaryList();
     r = JSONProcessor.parseRecipeMatches(s);
   double recipeSweet = r.matches.get(0).getFlavors().getSweet();
    assertEquals(recipeSweet, sweet, difference);    
    }
   
    
    @Test
    public void ratingParse() throws IOException{ 
    double rate = 4;
    String s = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&";
    RecipeSummaryList r = new RecipeSummaryList();
    r = JSONProcessor.parseRecipeMatches(s);
    assertEquals(r.matches.get(0).getRating(), rate, difference);
        
    }
    
  
}
