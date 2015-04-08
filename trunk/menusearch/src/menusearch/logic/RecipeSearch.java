/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.logic;

import java.util.ArrayList;
import menusearch.domain.Recipe;
import menusearch.json.JSONProcessor;
import menusearch.json.RecipeSummary;
import menusearch.json.Parameters;


/**
 *
 * @author azulay
 */
public class RecipeSearch {
    public static RecipeSummary search(String searchPhrase, String aIngredients,
            String eIngredients, String aAllergy, String aDiet, String aCuisines,
            String eCuisines, String aCourses, String eCourses, String aHollidays,
            String eHollidays, String nutrition, int nmax, int nmin, String flavor,
            int m) {
        
        ArrayList<RecipeSummary> recipeList = null;
        JSONProcessor jsonp = new JSONProcessor();
        Parameters p = new Parameters();
        String result = null;
        RecipeSummary recipe = null;
        
        p.setSearchPhrase(searchPhrase);
        p.addAllowedIngredients(aIngredients);
        p.addExcludedIngredients(eIngredients);
        p.addAllowedAllergy(aAllergy);
        p.addAllowedDiet(aDiet);
        p.addAllowedCourses(aCuisines);
        p.addExcludedCuisines(eCuisines);
        p.addAllowedCourses(aCourses);
        p.addExcludedCourses(eCourses);
        p.addAllowedHoliday(aHollidays);
        p.addExcludedHoliday(eHollidays);
        p.addNutritionAttributes(nutrition, nmin, nmax);
        p.setFlavorAttributes(flavor, Boolean.TRUE, m);
        try {
            result = jsonp.buildQuery(p);
            recipe = jsonp.parseRecipes(result);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        
        return recipe;
    }

}
