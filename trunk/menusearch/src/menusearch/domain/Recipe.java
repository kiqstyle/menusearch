/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.domain;
import java.util.ArrayList;
 

/**
 *
 * @author jthom92a
 */


public class Recipe {
    private IngredientList Ingredents = new IngredientList();
    private ArrayList<NutritionEstimate> Nutrition = new ArrayList();
    private String hostedSmallUrl;
    private String hostedMediumUrl;
    private String hostedlargeUrl;
    private CourseList Course = new CourseList();
    private HolidayList holiday = new HolidayList();
    private CuisineList cuisine = new CuisineList(); 
    private Flavors flavor = new Flavors();
    private String Directions;
    private String Tags;
    private double rating;
    private String Name;
    private String RecipeID;
    private Double numberOfServings;
    private Double TimetoCook;
    private Attribution attribution = new Attribution();
    private String yield;
    private String TotalTime;
    private Source source = new Source();

    public String getHostedSmallUrl() {
        return hostedSmallUrl;
    }

    public void setHostedSmallUrl(String hostedSmallUrl) {
        this.hostedSmallUrl = hostedSmallUrl;
    }

    public String getHostedMediumUrl() {
        return hostedMediumUrl;
    }

    public void setHostedMediumUrl(String hostedMediumUrl) {
        this.hostedMediumUrl = hostedMediumUrl;
    }

    public String getHostedlargeUrl() {
        return hostedlargeUrl;
    }

    public void setHostedlargeUrl(String hostedlargeUrl) {
        this.hostedlargeUrl = hostedlargeUrl;
    }
    
    
    
    
    
    
    public void setSourceSiteUrl(String u)
    {
        source.setSourceSiteUrl(u);
    }
    
    public void setSourceDisplayName(String n)
    {
        source.setSourceDisplayNaame(n);
    }
    
    public void setSourceRecipeUrl(String u)
    {
        source.setSourceRecipeUrl(u);
    }
    public Source getSource()
    {
        return source;
    }
    
    
    public CuisineList getCuisine()
    {
        return cuisine;
    }
    
    public void addCuisineToList(String c)
    {
        cuisine.add(c);
    }
    
    

    public HolidayList getHoliday() {
        return holiday;
    }

    public void addholidayToList(String h) {
        holiday.add(h);
    }

    
    
    public String getTotalTime() {
        return TotalTime;
    }

    public void setTotalTime(String TotalTime) {
        this.TotalTime = TotalTime;
    }
    
    
    public String getYield() {
        return yield;
    }

    public void setYield(String yield) {
        this.yield = yield;
    }
    
  public void addNutritionInfo (NutritionEstimate n)
  {
      Nutrition.add(n);
  }
  
  public ArrayList getNutrtionEstimate()
  {
      return Nutrition;
  }
 
  public IngredientList getIngredents() {
        return Ingredents;
    }
  
  public void addIngredient(String i)
  {
      Ingredents.add(i);
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
    
public double getRating() {
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

   

    public void setRating(double rating) {
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

    public Attribution getAttribution() {
        return attribution;
    }

    public void setAttribution(Attribution a ) {
        this.attribution = a;
    }
    
    public void setMeatyFlavor(double y)
    {
        flavor.setMeaty(y);
         /*
    private Double Bitter;
         */
    }
    public void setBitterFlavor(double b)
    {
        flavor.setBitter(b);
    }
    public void setSourFlavor(double s)
    {
        flavor.setSour(s);
    }
    public void setSweetFlavor(double s)
    {
        flavor.setSweet(s);
    }
    public void setPiquantFlavor(double p)
    {
        flavor.setPiquant(p);
    }
    
    public void setSaltyFlavor(double s)
    {
        flavor.setSalty(s);
    }
    
    public void setRecipeID(String ID)
    {
        RecipeID = ID;
    }
    
}

