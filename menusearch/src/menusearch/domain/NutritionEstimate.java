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
 * @author Matthew Shields
 */
public class NutritionEstimate {

    String attribute;
    String description;
    double value;
    Unit unit;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Unit getUnit() {
        return unit;
    }

    public void addUnit(Unit u) {
        unit = u;
    }
}
