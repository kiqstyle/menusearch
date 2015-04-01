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
     
    ArrayList<String> Ingredents = new ArrayList<String>();
    
    public void add(String ingredent)
    {
        Ingredents.add(ingredent);
    }
    
    public Iterator getIterator()
    {
        return Ingredents.iterator();
    }
    
    public String getIngredent(int num){
       String currentIngred = Ingredents.get(num);
       return currentIngred;
    }
}

