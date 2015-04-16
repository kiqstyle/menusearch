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
import menusearch.domain.*;

import org.json.*;
import menusearch.domain.*;



/**
 *
 
 */
public class JSONProcessor {
    


    
    /**
     * 
     * @param json formated JSON string containing all the information for one recipe
     * @return Recipe object
     * @throws IOException 
     */
    public static Recipe parseRecipe(String json) throws IOException, JSONException
    {
        
       
        JSONTokener tokenizer = new JSONTokener(json);
        JSONObject obj = new JSONObject(tokenizer);
        Recipe r = new Recipe();
        
        JSONObject attribution = obj.getJSONObject("attribution");
        Attribution a = new Attribution();
        a.setHTML(attribution.getString("html"));
        a.setUrl(attribution.getString("url"));
        a.setText(attribution.getString("text"));
        a.setLogo(attribution.getString("logo"));
        r.setAttribution(a);
        
        JSONArray ingredientList = obj.getJSONArray("ingredientLines");
        for (int i = 0; i< ingredientList.length(); i++)
        {
            r.addIngredient(ingredientList.getString(i));
        }
        
        JSONObject flavors = obj.getJSONObject("flavors");
        r.setBitterFlavor(flavors.getDouble("Bitter"));
        r.setMeatyFlavor(flavors.getDouble("Meaty"));
        r.setPiquantFlavor(flavors.getDouble("Piquant"));
        r.setSaltyFlavor(flavors.getDouble("Salty"));
        r.setSourFlavor(flavors.getDouble("Sour"));
        r.setSweetFlavor(flavors.getDouble("Sweet"));
        
        JSONArray nutritionEstimates = obj.getJSONArray("nutritionEstimates");
        for (int i = 0; i < nutritionEstimates.length(); i++)
        {
           NutritionEstimate nutritionInfo = new NutritionEstimate();
           Unit aUnit = new Unit();
           
           JSONObject nutrition = nutritionEstimates.getJSONObject(i);
           nutritionInfo.setAttribute(nutrition.getString("attribute"));
           
           if(nutrition.isNull("description") != true)
           nutritionInfo.setDescription(nutrition.getString("description"));
           nutritionInfo.setValue(nutrition.getDouble("value"));
           
           JSONObject unit = nutrition.getJSONObject("unit");
           aUnit.setAbbreviation(unit.getString("abbreviation"));
           aUnit.setName(unit.getString("name"));
           aUnit.setPlural(unit.getString("plural"));
           aUnit.setPluralAbbreviation(unit.getString("pluralAbbreviation"));
           
           nutritionInfo.addUnit(aUnit);
           
           r.addNutritionInfo(nutritionInfo);

        }
        JSONArray images = obj.getJSONArray("images");
        
        JSONObject imageBySize = images.getJSONObject(0);
        
        for (int i = 0; i< images.length(); i++)
        {
            if(images.getJSONObject(i).has("hostedLargeUrl"))
               r.setHostedlargeUrl(images.getJSONObject(i).getString("hostedLargeUrl"));
            if (images.getJSONObject(i).has("hostedMediumUrl"))
               r.setHostedMediumUrl(images.getJSONObject(i).getString("hostedMediumUrl"));
            if (images.getJSONObject(i).has("hostedSmallUrl"))
               r.setHostedSmallUrl(images.getJSONObject(i).getString("hostedSmallUrl"));
        }
        
        
        if(obj.has("name"))
        r.setName(obj.getString("name"));
        
        if(obj.has("yield"))
        r.setYield(obj.getString("yield"));
        
        if(obj.has("totalTime"))
            r.setTotalTime(obj.getString("totalTime"));
        
        
        
        if(obj.has("attributes"))
        {
        JSONObject attributes = obj.getJSONObject("attributes");
        if (attributes.has("holiday"))
        {
        JSONArray holidays = attributes.getJSONArray("holiday");
        for (int i = 0; i< holidays.length(); i++)
        {
            r.addholidayToList(holidays.getString(i));
        }
        }
        if(attributes.has("cuisine"))
        {
        JSONArray cuisine = attributes.getJSONArray("cuisine");
       for(int i = 0; i < cuisine.length(); i++)
       {
           r.addCuisineToList(cuisine.getString(i));
       }
        }
        }
       if(obj.has("totalTimeInSeconds"))
       r.setTimetoCook(obj.getDouble("totalTimeInSeconds"));
       
       if(obj.has("rating"))
       r.setRating(obj.getDouble("rating"));
       
       if(obj.has("numberofServings"))
       r.setNumberOfServings(obj.getDouble("numberOfServings"));
       
       
       if(obj.has("source"))  
       {
       JSONObject source = obj.getJSONObject("source");
       
       if(source.has("sourceSiteUrl"))
       r.setSourceSiteUrl(source.getString("sourceSiteUrl"));
       
       if(source.has("sourceRecipeUrl"))
       r.setSourceRecipeUrl(source.getString("sourceRecipeUrl"));
       
       if(source.has("sourceDisplayName"))
       r.setSourceDisplayName(source.getString("sourceDisplayName"));
       }
      r.setRecipeID(obj.getString("id"));

        return r;
        
    }
    /**
     * 
     * @param searchID is the ID of the recipe you would like to search for 
     * @return a string containing one recipe in JSON format.
     * @throws IOException 
     */
   public static String getRecipeAPI(String searchID) throws IOException
   {
       BufferedReader reader = null;
    try {
        URL url = new URL("http://api.yummly.com/v1/api/recipe/" + searchID+"?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9");
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
   
   /**
    * 
    * @param p is a parameter object that is used to create the HTML query that's sent to yummly
    * @return a string with the JSON results
    * @throws IOException 
    * This method take search parameters and forms an HTML query. This query is then passed to the searchYummly method. the queryBuild method returns the final result of the searchYummly method
    */
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
   /**
    * 
    * @param query -- formatted HTML that's used with the searchRecipes API on yummly
    * @return  a string in JSON format that contains all the recipes that match the search parameters.
    * @throws MalformedURLException
    * @throws IOException 
    * 
    * You CAN NOT call this method directly -- to search Yummly call the method queryBuilder and pass it your search parameters.
    */
   private static String searchYummly(String query) throws MalformedURLException, IOException
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
   
 public static RecipeSummaryList parseRecipes(String query) throws IOException, JSONException {

 RecipeSummaryList recipeSummary = new RecipeSummaryList();
 
 String results = JSONProcessor.searchYummly(query);
 JSONObject newObject = new JSONObject(results);
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
 

 /**
     *
     * @param query
     * @return
     * @throws java.io.IOException
     */
    public static RecipeSummaryList parseRecipeMatches(String query ) throws IOException {
    CourseList courseList = new CourseList();
     RecipeSummaryList list = new RecipeSummaryList(); 
     String results = JSONProcessor.searchYummly(query);
     JSONTokener tokenizer = new JSONTokener(results);
     JSONObject resultList  = new JSONObject(tokenizer);
     JSONArray matches = resultList.getJSONArray("matches");
     for(int i = 0; i < matches.length();i++){ 
     RecipeSummary r = new RecipeSummary();
     JSONObject currentRecipe = matches.getJSONObject(i);
     JSONObject imageUrls = currentRecipe.getJSONObject("imageUrlsBySize");
     String link = "90";
     String number = imageUrls.getString(link); 
     r.setImageUrlsBySize(number);
    
     String source = (String) currentRecipe.getString("sourceDisplayName");
     r.setSourceDisplayName(source);
    
     
     JSONArray listOfIngredients = currentRecipe.getJSONArray("ingredients");
      for(int n = 0; n < listOfIngredients.length(); n++){
      String currentIngredients = listOfIngredients.getString(n);
      r.ingredients.add(currentIngredients);
      }
     
      String id = (String) currentRecipe.getString("id");
     r.setId(id);
     
       String recipe = (String) currentRecipe.get("recipeName");
      r.setRecipeName(recipe);
     
     JSONArray smallImage = currentRecipe.getJSONArray("smallImageUrls");
     for(int l = 0; l < smallImage.length(); l++){
     String currentUrl = (String) smallImage.get(l);
       r.setSmallImageUrls(currentUrl);
     }
      int timeInSeconds = (int) currentRecipe.getInt("totalTimeInSeconds");
     r.setTotalTimeInSeconds(timeInSeconds);
     
     String a = "attributes";
     String c = "course";
     if(currentRecipe.has(a)){
     JSONObject currentAttributes = currentRecipe.getJSONObject(a);
     if(currentAttributes.has(c)){
      for(int j = 0; j <currentAttributes.getJSONArray(c).length(); j++ ){
          String course = currentAttributes.getJSONArray(c).getString(j);
          courseList.add(course);
     }
      r.setCourses(courseList);
     }
     }
     
     CuisineList cuisineList = new CuisineList();
      
      if(currentRecipe.has(a)){
      JSONObject currentAttributes = currentRecipe.getJSONObject(a);
      if(currentAttributes.has("cuisine")){
      for(int j = 0; j <currentAttributes.getJSONArray("cuisine").length(); j++){
         String currentCuisine = currentAttributes.getJSONArray("cuisine").getString(j);
         cuisineList.add(currentCuisine);
     }
    r.setCusines(cuisineList);
      }   
     }
     
     
     String f = "flavors";
     JSONObject currentFlavors;
     if(currentRecipe.has(f) == true){
    
     if(currentRecipe.isNull(f) == false){
     currentFlavors = currentRecipe.getJSONObject(f);
     double saltyRating =  currentFlavors.getDouble("salty");
     double sourRating = currentFlavors.getDouble("sour");
     double sweetRating = currentFlavors.getDouble("sweet");    
     double bitterRating = currentFlavors.getDouble("bitter");
     double meatyRating = currentFlavors.getDouble("meaty");
     double piguantRating =  currentFlavors.getDouble("piquant");
     r.flavors.setSalty(saltyRating);
     r.flavors.setSour(sourRating);
     r.flavors.setSweet(sweetRating);
     r.flavors.setBitter(bitterRating);
     r.flavors.setMeaty(meatyRating);
     r.flavors.setPiquant(piguantRating);
     }
     if(currentRecipe.get(f) == null){
       r.flavors = null;
     }
     if(currentRecipe.get(f) == null)
     r.flavors = null;
     }
     
     
    double rate = currentRecipe.getInt("rating");
    r.setRating(rate);
    
    
    list.matches.add(i, r);
    
     }
 
   return list; 

}
   
}
    

     

   

 


     
       
   
    
    
    
    

