/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.domain;

/**
 *
 * @author jthom92a
 */


public class Recipe {
    private IngredientList Ingredents;
    private NutritionEstimate Nutrition;
    private CourseList Course;
    private HolidayList holiday;
    private CuisineList cuisine; 
    private Flavors flavor;
    private String Directions;
    private String Tags;
    private String rating;
    private String Name;
    private String RecipeID;
    private Double numberOfServings;
    private Double TimetoCook;
 
  public IngredientList getIngredents() {
        return Ingredents;
    }
    public NutritionEstimate getNutrition(){
        return Nutrition;
    }

    public CourseList getCourse(){
        return Course;
    }
    
    public HolidayList getholiday(){
        return holiday;
       }
    
    public CuisineList getcuisine(){
        return cuisine;
    }
    
    public Flavors getflavor(){
        return flavor;
    }
    
    public String getDirections() {
        return Directions;
    }

    public String getTags() {
        return Tags;
       
    }
    
public String getRating() {
        return rating;
    }

    public String getName() {
        return Name;
    }

    public String getRecipeID() {
        return RecipeID;
    }

    public Double getNumberOfServings() {
        return numberOfServings;
    }

    public Double getTimetoCook() {
        return TimetoCook;
    }
    
    
public void setDirections(String Directions) {
        this.Directions = Directions;
    }

    public void setTags(String Tags) {
        this.Tags = Tags;
    }

   

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

   
    public void setNumberOfServings(Double numberOfServings) {
        this.numberOfServings = numberOfServings;
    }

    public void setTimetoCook(Double TimetoCook) {
        this.TimetoCook = TimetoCook;
    }
    
    
}

