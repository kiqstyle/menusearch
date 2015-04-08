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
public class Flavors {
    private Double Salty;
    private Double sour;
    private Double Bitter;
    private Double sweet;
    private Double piquant;
    private Double meaty;
   
    
    public Double getSalty() {
        return Salty;
    }

    public Double getMeaty() {
        return meaty;
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

    public Double getPiquant() {
        return piquant;
    }
    
    public void setSalty(Double Salty) {
        this.Salty = Salty;
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

    public void setPiquant(Double piquant) {
        this.piquant = piquant;
    }

    public void setMeaty(Double meaty) {
        this.meaty = meaty;
    }
    
}
