/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.json;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;
/**
 *
 
 */
public class JSONProcessor {
    
   public static String getRecipeAPI(String searchValue) throws IOException
   {
       searchValue = searchValue.replace(" ", "-");
       BufferedReader reader = null;
    try {
        URL url = new URL("http://api.yummly.com/v1/api/recipe/" + searchValue+"-Allrecipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9");
        reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuffer buffer = new StringBuffer();
        int read;
        char[] chars = new char[1024];
        while ((read = reader.read(chars)) != -1)
            buffer.append(chars, 0, read); 

        return buffer.toString();
    } finally {
        if (reader != null)
            reader.close();
    }
}
   
   public static String buildQuery(Parameters p) throws IOException
   {
             final String URL = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&";

       String query = URL;
       
       if(p.getSearchPhrase()!=null){//checks to see if a Search phrase exists. it it does, it puts it into the correct format
           //String phrase = p.getSearchPhrase().replace(" ", "+");
           //System.out.println("checking to see if the replace works-" + phrase);
           System.out.println("checking search phrase" + p.getSearchPhrase());
           query = query + "q=" + p.getSearchPhrase();
       }
       if(p.getRequirePictures()!= null)
               query = query + "&" + "requirePictures=" + p.getRequirePictures();
       
       if(p.getAllowedIngredients()!=null)
       {
           for (int i = 0; i < p.getAllowedIngredients().size(); i++)
           {
               query = query + "&allowedIngredient[]=" + p.getAllowedIngredients().get(i);
           }
       }
       
       if(p.getExcludedIngredients() !=null)
       {
           
           
           for(int i = 0; i<p.getExcludedIngredients().size(); i++)
           {
              
               query = query + "&excludedIngredient[]=" + p.getExcludedIngredients().get(i);
               
           }
       }
       
       if(p.getAllowedAllergy()!=null)
       {
           for (int i = 0; i<p.getAllowedAllergy().size(); i++)
           {
               query = query+ "&allowedAllergy[]=" + p.getAllowedAllergy().get(i);
           }
       }
       
       if(p.getAllowedDiet()!=null)
       {
           for (int i = 0; i<p.getAllowedDiet().size(); i++)
           {
               query = query + "&allowedDiety[]=" + p.getAllowedDiet().get(i);
           }
       }
       
       if(p.getAllowedCuisines()!=null)
       {
           for (int i = 0; i<p.getAllowedCuisines().size(); i++)
           {
               query = query + "&allowedCuisine[]=" + p.getAllowedCuisines().get(i);
           }
       }
       
       if(p.getExcludedCuisines() != null)
       {
           for (int i = 0; i< p.getExcludedCuisines().size(); i++)
           {
               query = query + "&excludedCuisine[]=" + p.getExcludedCuisines().get(i);
           }
       }
       
       if(p.getAllowedCourses()!=null)
       {
           for (int i = 0; i < p.getAllowedCourses().size();i++)
           {
               query = query + "&allwedCourse[]=" + p.getAllowedCourses().get(i);
           }
       }
       
       if (p.getExcludedCourses()!= null)
       {
           for ( int i = 0; i< p.getExcludedCourses().size();i++)
           {
               query  = query + "&excludedCourse[]=" + p.getExcludedCourses().get(i);
           }
       }
       
       if(p.getAllowedHoliday()!=null)
       {
           for(int i = 0; i< p.getAllowedHoliday().size();i++)
           {
               query = query + "&allowedHoliday[]=" + p.getAllowedHoliday().get(i);
           }
       }
       
       if(p.getExcludedHoliday()!=null)
       {
           for (int i = 0; i< p.getExcludedHoliday().size(); i++)
           {
               query = query + "&excludedHoliday[]=" + p.getExcludedHoliday().get(i);
           }
       }
       
       if (p.getMaxTotalTimeInSeconds()!=null)
           query = query + "&maxTotalTimeInSeconds=" + p.getMaxTotalTimeInSeconds();
           
       if(p.getStart()!=null)
           query = query + "&start=" + p.getStart();
       
       if(p.getMaxResult()!=null)
           query = query+ "&maxResult=" + p.getMaxResult();
       
       if(p.getFlavorAttributes()!=null)
       {
           for (int i = 0; i< p.getFlavorAttributes().size(); i++)
           {
               query = query + "&flavor." + p.getFlavorAttributes().get(i);
           }
       }
       
       if(p.getFacetField() !=null)
           query = query+"&facetField[]=" + p.getFacetField();
       System.out.println(query);
       String results = searchYummly(query);
       return results;
   }
   
   public static String searchYummly(String query) throws MalformedURLException, IOException
   {
       BufferedReader reader = null;
    try {
        URL url = new URL(query);
        reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuffer buffer = new StringBuffer();
        int read;
        char[] chars = new char[1024];
        while ((read = reader.read(chars)) != -1)
            buffer.append(chars, 0, read); 

        return buffer.toString();
    } finally {
        if (reader != null)
            reader.close();
    }
}

   
 public static RecipeSummary parseRecipes(String query) throws IOException {

 RecipeSummary recipeSummary = new RecipeSummary();
 
 
 
 JSONObject newObject = new JSONObject(query);
 JSONObject at = newObject.getJSONObject("attribution");
  
  
  String html =(String) at.get("html");
  recipeSummary.setHtml(html);

  String url = (String) at.get("url");
  recipeSummary.setUrl(url);
  
  
  String text = (String) at.get("text");
  recipeSummary.setText(text);

  
  String logo = (String) at.get("logo");
  recipeSummary.setLogo(logo);
 
   
 int totalMatches = newObject.getInt("totalMatchCount");
 recipeSummary.setTotalmatches(totalMatches); 
   
       
  return recipeSummary;
       
       }
 
   @Override
   public String toString() {
    String sampleFile = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&q=garlic";
    RecipeSummary sample = new RecipeSummary();
       try {
           JSONProcessor.searchYummly(sampleFile);
       } catch (IOException ex) {
           Logger.getLogger(JSONProcessor.class.getName()).log(Level.SEVERE, null, ex);
       }
       try {
           JSONProcessor.parseRecipes(sampleFile);
       } catch (IOException ex) {
           Logger.getLogger(JSONProcessor.class.getName()).log(Level.SEVERE, null, ex);
       }
   return sample.toString();
    
}
   
}
   
   
 


       
       
       
   
    
    
    
    

