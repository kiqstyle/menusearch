/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.logic;

import java.io.IOException;
import java.util.ArrayList;
import menusearch.json.JSONProcessor;
import menusearch.json.RecipeSummaryList;
import menusearch.json.Parameters;
import menusearch.json.RecipeSummary;
import org.json.JSONException;


/**
 *
 * @author azulay
 * @author Nissan Azizov
 */
public class RecipeSearch {
    public static RecipeSummaryList search(String searchPhrase, String aIngredients,
            String eIngredients, String aAllergy, String aDiet, String aCuisines,
            String eCuisines, String aCourses, String eCourses, String aHollidays,
            String eHollidays, String nutrition, int nmax, int nmin, String flavor,
            int m) {
        System.err.println("The search phrase really is: " + searchPhrase);
        System.err.println("The ingredients were " + aIngredients + " " + eIngredients + " " +aAllergy + " " +aDiet + " " + aCuisines + " " + eCuisines + " " + aHollidays);
        ArrayList<RecipeSummaryList> recipeList = null;
        JSONProcessor jsonp = new JSONProcessor();
        Parameters p = new Parameters();
        String result;
        RecipeSummaryList recipe = null;
        System.err.println("We're in the RecipeSearch class");
        if (!searchPhrase.equals("")) 
            p.setSearchPhrase(searchPhrase);  
        if (!aIngredients.equals(""))
            p.addAllowedIngredients(aIngredients);
        if (!eIngredients.equals(""))
            p.addExcludedIngredients(eIngredients);
        if (!aAllergy.equals(""))
            p.addAllowedAllergy(aAllergy);
        if (!aDiet.equals(""))
            p.addAllowedDiet(aDiet);
        if (!aCuisines.equals(""))
            p.addAllowedCourses(aCuisines);
        if (!eCuisines.equals(""))
            p.addExcludedCuisines(eCuisines);
        if (!aCourses.equals(""))
            p.addAllowedCourses(aCourses);
        if (!eCourses.equals(""))
            p.addExcludedCourses(eCourses);
        if (!aHollidays.equals(""))
            p.addAllowedHoliday(aHollidays);
        if (!eHollidays.equals(""))
            p.addExcludedHoliday(eHollidays);
        if (!nutrition.equals(""))
            p.addNutritionAttributes(nutrition, nmin, nmax);
        if (!flavor.equals(""))
            p.setFlavorAttributes(flavor, Boolean.TRUE, m);
        
        try {
            System.err.println("The search phrase was: "+p.getSearchPhrase());
            System.err.println();
            result = JSONProcessor.buildQuery(p);
            System.err.println("-----------------------------------------------------------------");
            System.err.println(result);
            
            recipe = JSONProcessor.parseRecipeMatches(result);
            System.err.println("-----Your search reulsts are! ----------");
            for (RecipeSummary x : recipe.getMatches())
            {
                System.err.println(x.getId() + ", " + x.getRecipeName());
            }
                   
        } catch (IOException | JSONException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        return recipe;
    }
}
