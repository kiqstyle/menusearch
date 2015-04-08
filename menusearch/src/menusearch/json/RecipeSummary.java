package menusearch.json;

import java.io.IOException;
import menusearch.domain.*;
import java.util.ArrayList;
import org.json.*;

/**
 *
 * @author kennethngai
 */
public class RecipeSummary {

   
    private int number;
    private String imageUrlsBySize;
    private CourseList courses = new CourseList();
    private CuisineList cusines = new CuisineList() ;
    Flavors flavors = new Flavors();
    private double rating;
    private String id;
    private String smallImageUrls;
    private String sourceDisplayName;
    private int totalTimeInSeconds;
    IngredientList ingredients = new IngredientList();
    private String recipeName;
    


    public String getImageUrlsBySize() {
        return imageUrlsBySize;
    }

    public void setImageUrlsBySize(String imageUrlsBySize) {
        this.imageUrlsBySize = imageUrlsBySize;
    }

    public String getSmallImageUrls() {
        return smallImageUrls;
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public CourseList getCourses() {
        return courses;
    }

    public void setCourses(CourseList courses) {
        this.courses = courses;
    }

    public CuisineList getCusines() {
        return cusines;
    }

    public void setCusines(CuisineList cusines) {
        this.cusines = cusines;
    }

     public Flavors getFlavors() {
        return flavors;
    }

    public void setFlavors(Flavors flavors) {
        this.flavors = flavors;
    }
   
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSmallImageUrls(String smallImageUrls) {
        this.smallImageUrls = smallImageUrls;
    }

    public String getSourceDisplayName() {
        return sourceDisplayName;
    }

    public void setSourceDisplayName(String sourceDisplayName) {
        this.sourceDisplayName = sourceDisplayName;
    }

    public int getTotalTimeInSeconds() {
        return totalTimeInSeconds;
    }

    public void setTotalTimeInSeconds(int totalTimeInSeconds) {
        this.totalTimeInSeconds = totalTimeInSeconds;
    }

    public IngredientList getIngredients() {
        return ingredients;
    }

    public void setIngredients(IngredientList ingredients) {
        this.ingredients = ingredients;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

   

    
        
        
        
        
        
        
    }

            
