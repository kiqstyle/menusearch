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
        ArrayList<HolidayList> Holiday = new ArrayList<HolidayList>();
    
    public void add(HolidayList Day)
    {
        Holiday.add(Day);
    }
    
    public Iterator getIterator()
    {
        return Holiday.iterator();
    }
}
    
