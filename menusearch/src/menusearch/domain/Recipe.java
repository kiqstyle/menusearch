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
    private String Ingredents;
    private String Directions;
    private String Tags;
    private Double Salty;
    private Double Savory;
    private Double sour;
    private Double Bitter;
    private Double sweet;
    private Double spicy;

    public String getIngredents() {
        return Ingredents;
    }

    public String getDirections() {
        return Directions;
    }

    public String getTags() {
        return Tags;
    }

    public Double getSalty() {
        return Salty;
    }

    public Double getSavory() {
        return Savory;
    }

    public Double getSour() {
        return sour;
    }

    public Double getBitter() {
        return Bitter;
    }

    public Double getSweet() {
        return sweet;
    }

    public Double getSpicy() {
        return spicy;
    }

    public void setIngredents(String Ingredents) {
        this.Ingredents = Ingredents;
    }

    public void setDirections(String Directions) {
        this.Directions = Directions;
    }

    public void setTags(String Tags) {
        this.Tags = Tags;
    }

    public void setSalty(Double Salty) {
        this.Salty = Salty;
    }

    public void setSavory(Double Savory) {
        this.Savory = Savory;
    }

    public void setSour(Double sour) {
        this.sour = sour;
    }

    public void setBitter(Double Bitter) {
        this.Bitter = Bitter;
    }

    public void setSweet(Double sweet) {
        this.sweet = sweet;
    }

    public void setSpicy(Double spicy) {
        this.spicy = spicy;
    }
    
    
            
}
