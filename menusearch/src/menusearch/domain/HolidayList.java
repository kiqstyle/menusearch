/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.domain;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jthom92a
 */
public class HolidayList {
        ArrayList<String> Holiday = new ArrayList<String>();
    
    public void add(String holiday)
    {
       Holiday.add(holiday);
        
    }
    
 public Iterator getIterator()
    {
        return Holiday.iterator();
    }
}
    
