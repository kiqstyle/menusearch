/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.db;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import menusearch.domain.*;

/**
 *
 * @author Chris
 */
public class MenuPageDBAccessTest {

    @Test
    public void testRetrieveByID() throws Exception {
        System.out.println("Testing retrieveByID");
        int id = 119;
  //      MenuPage expResult = new MenuPage(119, 12460, 1, "1603595", 7230, 5428);
  //      MenuPage result = MenuPageDBAccess.retrieveByID(id);
   //     assertEquals(expResult, result);

    }

    /**
     * Test of retrieveByPage method, of class MenuPageDBAccess.
     */
    @Test
    public void testRetrieveByPage() throws Exception {
        System.out.println("Testing retrieveByPage");
        int page = 0;
        ArrayList<MenuPage> expResult = new ArrayList<MenuPage>();
        ArrayList<MenuPage> result = MenuPageDBAccess.retrieveByPage(page);
        assertEquals(expResult.isEmpty(), result);
    }

    @Test
    public void testRetrieveByMenuID() throws Exception {
        System.out.println("Testing retrieveByMenuID");
        int menuID = 0;
        ArrayList<MenuPage> expResult = new ArrayList<MenuPage>();
        ArrayList<MenuPage> result = MenuPageDBAccess.retrieveByMenuID(menuID);
        assertEquals(expResult.isEmpty(), result);
    }

    @Test
    public void testRetrieveByMenuItemID() throws Exception {
        System.out.println("Testing retrieveByMenuItemID");
        int menuItemID = 5;
  //      MenuPage expResult= new MenuPage(3079, 13472, 1, "467274", 5666, 2718);
  //      MenuPage result = MenuPageDBAccess.retrieveByMenuItemID(menuItemID);
  //      assertEquals(expResult, result);

    }

}
