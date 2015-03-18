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
import java.util.ArrayList;
import java.util.Iterator;
public class IngredientList {
    
    ArrayList<IngredientList> Ingredents = new ArrayList<IngredientList>();
    
    public void add(IngredientList ingredent)
    {
        Ingredents.add(ingredent);
    }
    
    public Iterator getIterator()
    {
        return Ingredents.iterator();
    }
}

