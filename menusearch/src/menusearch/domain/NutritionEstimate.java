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
public class NutritionEstimate {
    private String Calories;
    private String toatal_Fat;
    private String Cholesterol;
    private String Sodium;
    private String Potassium;
    private String toatal_Carbs;
    private String Protein;
    

    public String getCalories() {
        return Calories;
    }

    public String getToatal_Fat() {
        return toatal_Fat;
    }

    public String getCholesterol() {
        return Cholesterol;
    }

    public String getSodium() {
        return Sodium;
    }

    public String getPotassium() {
        return Potassium;
    }

    public String getToatal_Carbs() {
        return toatal_Carbs;
    }

    public String getProtein() {
        return Protein;
    }

    public void setCalories(String Calories) {
        this.Calories = Calories;
    }

    public void setToatal_Fat(String toatal_Fat) {
        this.toatal_Fat = toatal_Fat;
    }

    public void setCholesterol(String Cholesterol) {
        this.Cholesterol = Cholesterol;
    }

    public void setSodium(String Sodium) {
        this.Sodium = Sodium;
    }

    public void setPotassium(String Potassium) {
        this.Potassium = Potassium;
    }

    public void setToatal_Carbs(String toatal_Carbs) {
        this.toatal_Carbs = toatal_Carbs;
    }

    public void setProtein(String Protein) {
        this.Protein = Protein;
    }
    
    
    
}
