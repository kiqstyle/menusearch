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
public class CourseList {
    
    ArrayList<CourseList> Courses = new ArrayList<CourseList>();
    
    public void add(CourseList course)
    {
        Courses.add(course);
    }
    
    public Iterator getIterator()
    {
        return Courses.iterator();
    }
}
    


}
