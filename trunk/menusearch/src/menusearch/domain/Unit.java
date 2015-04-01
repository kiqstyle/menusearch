/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.domain;

/**
 *
 * @author matthewshields
 */
public class Unit {
    
        private String name;
    private String abbreviation;
    private String plural;
    private String pluralAbbreviation;
    
    public Unit()
            {
                
            }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getPlural() {
        return plural;
    }

    public void setPlural(String plural) {
        this.plural = plural;
    }

    public String getPluralAbbreviation() {
        return pluralAbbreviation;
    }

    public void setPluralAbbreviation(String pluralAbbreviation) {
        this.pluralAbbreviation = pluralAbbreviation;
    }
    

    
    
    
}
