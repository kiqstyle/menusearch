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
public class CuisineList {
    ArrayList<CuisineList> Cuisines = new ArrayList<CuisineList>();
    
    public void add(CuisineList cuisine)
    {
        Cuisines.add(cuisine);
    }
    
    public Iterator getIterator()
    {
        return Cuisines.iterator();
    }
}
    

