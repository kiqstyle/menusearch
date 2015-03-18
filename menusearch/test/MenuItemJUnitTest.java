/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicolebkim
 */

public class MenuItemJUnitTest {

    @Test
    public void testSetGetPrice() {
        MenuItem item = new MenuItem(54211);
        item.setPrice("15.50");
        assertEquals("15.50", item.getPrice());
    }
    
    @Test
    public void testSetGetHigh_price() {
        MenuItem item = new MenuItem(23344);
        item.setHighPrice("33.75");
        assertEquals("33.75", item.getHigh_price());
    }
    
}
