/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.json;

import java.util.*;

/**
 *
 * @author matthewshields
 * 
 * The class represents all the possible parameters for a recipe search using Yummly.
 * If you are not including a particular parameter in a search --  don't call it's set method!
 */
 public class Parameters{
     
       
        private String searchPhrase;
        private Boolean requiresPictures;
        private ArrayList<String> allowedIngredients = new ArrayList();
        private ArrayList<String> excludedIngredients = new ArrayList();
        private ArrayList<String> allowedAllergy= new ArrayList();
        private ArrayList<String> allowedDiet = new ArrayList();
        private ArrayList<String> allowedCuisines = new ArrayList();
        private ArrayList<String> excludedCuisines = new ArrayList();
        private ArrayList<String> allowedCourses= new ArrayList();
        private ArrayList<String> excludedCourses = new ArrayList();
        private ArrayList<String> allowedHolidays = new ArrayList();
        private ArrayList<String> excludedHolidays = new ArrayList();
        private ArrayList<String> nutritionAttributes = new ArrayList();
        private ArrayList<String> flavorAttributes = new ArrayList();
        
        private String maxResult;
        private String start;
        private String maxTotalTimeInSeconds;
        private String facetField;
      
      /**
       * 
       * @param q = searchPhrase
       */  
      public void setSearchPhrase(String q)
      {
          q = q.replace(" ", "+");
          searchPhrase = q;
      }
      
      /**
       * 
       * @return the searchPhrase string
       */
      public String getSearchPhrase()
      {
          return searchPhrase;
      }
      
      /**
       * 
       * @param t is true if you would like to require pictures or false if you don't
       * If true the search results will only contain recipes that have pitures
       */
      public void requirePictures(Boolean t)
      {
          requiresPictures = t;
      }
      
      /**
       * 
       * @return true/false depending if pictures are required
       */
      public Boolean getRequirePictures()
      {
          return requiresPictures;
      }
        
      /**
       * 
       * @param i is the ingredient to be added
       */
      public void addAllowedIngredients(String i)
      {
          i = i.replace(" ", "%20");
          allowedIngredients.add(i);
      }
      
      /**
       * 
       * @return arrayList of Ingredients
       */
      public ArrayList getAllowedIngredients()
      {
          return allowedIngredients;
      }
      
      /**
       * 
       * @param e is an ingredient to be excluded
       * 
       * Spaces in strings are replaced with "%20" and then e is saved to the arrayList
       */
      public void addExcludedIngredients(String e)
      {
          
          e = e.replace(" ", "%20");
          
          excludedIngredients.add(e);
      }
      
      /**
       * 
       * @return arraylist of excluded ingredients
       */
      public ArrayList getExcludedIngredients()
      {
          return excludedIngredients;
      }
      
      /**
       * 
       * @param a is an allergy that the recipe must be safe for.
       * the parameter must be one of the following values:
       * "396^Dairy-Free"
       * "397^Egg-Free"
       * "393^Gluten-Free"
       * "394^Peanut-Free"
       * "398^Seafood-Free"
       * "399^Sesame-Free"
       * "400^Soy-Free"
       * "401^Sulfite-Free"
       * "395^Tree Nut-Free"
       * "392^Wheat-Free
       */
      public void addAllowedAllergy(String a)
      {
          allowedAllergy.add(a);
      }
      
      /**
       * 
       * @return ArrayList of allergies
       */
      public ArrayList getAllowedAllergy()
      {
          return allowedAllergy;
      }
      
      /**
       * 
       * @param d is a specific diet that must be accounted for in the search
       * String d must be one of the following values:
       * "388^Lacto vegetarian"
       * "389^Ovo vegetarian"
       * "390^Pescetarian"
       * "386^Vegan""387^Lacto-ovo vegetarian"
       * "403^Paleo"
       */
      public void addAllowedDiet(String d)
      {
          allowedDiet.add(d);
      }
      
      /**
       * 
       * @return ArrayList of diets to be considered during the search.
       */
      public ArrayList getAllowedDiet()
      {
          return allowedDiet;
      }
      
      /**
       * 
       * @param c a type of cuisine to filter the results
       * Only the foloowing cuisines are supported:
       * American
       * Italian
       * Asian
       * Mexican
       * Southern & Soul Food
       * French
       * Southwestern
       * Barbecue
       * Indian
       * Chinese
       * Cajun & Creole
       * English
       * Mediterranean
       * Greek
       * Spanish
       * German
       * Thai
       * Moroccan
       * Irish
       * Japanese
       * Cuban
       * Hawaiin
       * Swedish
       * Hungarian
       * Portugese
       */
      public void addAllowedCuisines(String c)
      {
          allowedCuisines.add("cuisine^cuisine-" +c);
      }
      
      /**
       * 
       * @return ArrayList of cuisines to filter the search results
       */
      public ArrayList getAllowedCuisines()
      {
          return allowedCuisines;
      }
      
      /**
       * 
       * @param c String containing cuisine to be excluded from search results
       * The only cuisines supported are: American, Italian, Asian, Mexican, Southern & Soul Food, French, Southwestern, Barbecue, Indian, Chinese, Cajun & Creole, English, Mediterranean, Greek, Spanish, German, Thai, Moroccan, Irish, Japanese, Cuban, Hawaiin, Swedish, Hungarian, Portugese
       */
      public void addExcludedCuisines(String c)
      {
          excludedCuisines.add("cuisine^cuisine-" + c);
      }
      
      /**
       * 
       * @return ArrayList of excluded Cuisines
       */
      public ArrayList getExcludedCuisines()
      {
          return excludedCuisines;
      }
      
      /**
       * 
       * @param c String containing a course to be used in filtering search results
       * The supported courses are:
       * Main Dishes
       * Desserts
       * Side Dishes
       * Lunch and Snacks
       * Appetizers
       * Salads
       * Breads
       * Breakfast and Brunch
       * Soups
       * Beverages
       * Condiments and Sauces
       * Cocktails
       */
      public void addAllowedCourses(String c)
      {
             allowedCourses.add("course^course-" +c);
      }
      
      /**
       * 
       * @return ArrayList of courses used to filter search results
       */
      public ArrayList getAllowedCourses()
      {
          return allowedCourses;
      }
      
      /**
       * 
       * @param c String containing course to be excluded from search parameter
       */
      public void addExcludedCourses(String c)
      {
          excludedCourses.add("course^course-" + c);
      }
      
      /**
       * 
       * @return arraylist of courses to be excluded from the search results
       */
      public ArrayList getExcludedCourses()
      {
          return excludedCourses;
      }
      
      /**
       * @param h String containing holiday to be included in search results
       * The supported Holidays are:
       * Christmas
       * Summer
       * Thanksgiving
       * New Year
       * Super Bowl / Game Day
       * Halloween
       * Hanukkah
       * 4th of July
       */
      
      public void addAllowedHoliday(String h)
      {
          allowedHolidays.add("holiday^holiday-" +h);
      }
      
      /**
       * 
       * @return Arraylist of Holidays to be included in search parameter
       */
      public ArrayList getAllowedHoliday()
      {
          return allowedHolidays;
      }
      
      /**
       * 
       * @param h String containing holiday to be excluded from search
       */
      public void addExcludedHoliday(String h)
      {
          excludedHolidays.add("holiday^holiday-" +h);
      }
      
      /**
       * 
       * @return ArrayList of holidays to be excluded from search results
       */
      public ArrayList getExcludedHoliday()
      {
          return excludedHolidays;
      }
      
      /**
       * 
       * @param m String contains the max amount of prep time allowed in Seconds
       */
      public void setMaxTotalTimeInSeconds(String m)
      {
          maxTotalTimeInSeconds = m;
      }
      
      /**
       * 
       * @return String maxTotalTimeInSeconds returns the max amount of prep time in seconds
       */
      public String getMaxTotalTimeInSeconds()
      {
          return maxTotalTimeInSeconds;
      }
      
      /**
       * 
       * @param n - nutrition element i.e. K, NA, CHOLE
       * @param min - minimum amount of nutrition element allowed
       * @param max - maximum amount of nutrition element allowed
       */
      public void addNutritionAttributes(String n, int min, int max)
      {
          String nutritionRequirement = (n + "." + "{" + min + "|" + max + "}");
      }
      
      /**
       * 
       * @param s is the number of the result you would like to start at
       */
      public void setStart(String s)
      {
          start = s;
      }
      
      /**
       * 
       * @return start
       */
      public String getStart()
      {
          return start;
      }
      
      /**
       * 
       * @param r is max number of recipes you would like your search to return
       */
      public void setMaxResult(String r)
      {
          maxResult = r;
      }
      
      /**
       * 
       * @return maxResult is the maximum number of recipes you would like returned by your search
       */
      public String getMaxResult()
      {
          return maxResult;
      }
         
      /**
       * 
       * @param f - flavor to be considered
       * @param max boolean -- true if max, false if min
       * @param m is the value of that flavor you'd like -- must be between 0 and 1
       * 
       * To add a flavor call this method, if the you'd like to set a max flavor make boolean true, for min flavor make boolean false
       * If there are no flavors to add simply don't call this method. If the List of flavors is empty, no flavors will be included in the search parameters.
       */
      public void setFlavorAttributes(String f, Boolean max, double m)
      {
          String flavorAttribute;
          if(max == true)
           flavorAttribute = (f + "." + "max=" +m );
          else
               flavorAttribute = (f + "." + "min=" +m );
          
          flavorAttributes.add(flavorAttribute);
      }
      
      /**
       * 
       * @return arrayList of Flavor Attributes
       */
      public ArrayList getFlavorAttributes()
      {
          return flavorAttributes;
      }
         
      /**
       * 
       * @param field String must be "diet" or "ingredient"
       * allows for facet count of ingredients or diet
       */
      public void setFacetField(String field)
      {
          facetField = field;
      }
      
      /**
       * 
       * @returns facet field
       */
      public String getFacetField()
      {
          return facetField;
      }
    }
