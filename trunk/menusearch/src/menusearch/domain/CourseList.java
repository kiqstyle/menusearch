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
    
    ArrayList<String> Courses = new ArrayList<String>();
    
    public void add(String course)
    {
        Courses.add(course);
    }
    
    public String getCourse(int current){
       String currentCourse = Courses.get(current);
        return currentCourse;
    }
    
    public Iterator getIterator()
    {
        return Courses.iterator();
    }

}

    




