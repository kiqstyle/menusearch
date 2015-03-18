/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicolebkim
 */
public class MenuItemDBTest {
    
    public static void main(String[] args) {
        
        try {
            DBConnection.init();
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter menu item id: ");
            int id = kb.nextInt();
            MenuItem menuItem = MenuItemDB.retrieveByID(id);
            if (menuItem ==null) {
                System.out.println("This id is invalid");
            }
            else{
                printMenuItem(menuItem);
            }
            
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuItemDBTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
            
            Logger.getLogger(MenuItemDBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
private static void printMenuItem(MenuItem menuItem) {
    System.out.println("Menu Item id: " + menuItem.getMenu_items_id() + "Menu Page: " + /*menuItem.getMenu_page_id() + */  "Dish: " + /* menuItem.getDish_id() + */ "Price: " + menuItem.getPrice() + "High Price: " + menuItem.getHigh_price() + "Created at: " + menuItem.getCreated_at() + "Updated at: " + menuItem.getUpdated_at() + "XPos: " + menuItem.getXpos() + "YPos: " + menuItem.getYpos());
        }
    }
    

