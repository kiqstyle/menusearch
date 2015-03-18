/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author nicolebkim
 */
public class MenuItemDB {
    
    static final class FIELDS {
        static final String menu_items_id = "menu_items_id";
        static final String name = "name";
        static final String price = "price";
        static final String high_price = "high_price";
        static final String created_at = "created_at";
        static final String updated_at = "updated at";
        static final String xpos = "xpos";
        static final String ypos = "ypos";
    }
        
    private ArrayList<Dish> dish;
    private ArrayList<MenuPage> menuPage;
   
    private static Connection conn;
    private static final String QUOTE = "\"";
    
/**
 * return an item by menu item id
 * @param id
 * @return Menu Item
 * 
 */    
    public static MenuItem retrieveByID(int id) throws ClassNotFoundException, SQLException
    {
        MenuItem menuItem;
        conn =DBConnection.getMyConnection();

        String query = ("select * from MenuItem where menu_items_id = \"" + id + "\"");
        System.out.println("query is " + query);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
         if (!rs.next())
              menuItem = null;   //no menuitem found
          else{
             menuItem = buildMenuItem(rs);
          }
          stmt.close();
          return menuItem;
      }
      
    public static MenuItem buildMenuItem(ResultSet rs) throws SQLException {
        int menu_items_id = rs.getInt(FIELDS.menu_items_id);
        int menu_page_id = rs.getInt("menu_page_id");
        int dish_id = rs.getInt("dish_id");
        float price = rs.getFloat(FIELDS.price);
        float high_price = rs.getFloat(FIELDS.high_price);
        LocalDateTime created_at = rs.getTimestamp(FIELDS.created_at).toLocalDateTime();
        LocalDateTime updated_at = rs.getTimestamp(FIELDS.updated_at).toLocalDateTime();
        float xpos = rs.getFloat(FIELDS.xpos);
        float ypos = rs.getFloat(FIELDS.ypos);
        Dish dish = new Dish(dish_id);
        MenuPage menuPage = new MenuPage(menu_page_id);

        MenuItem menuItem = new MenuItem(menu_items_id, dish_id, price, high_price, created_at, updated_at, xpos, ypos, dish, menuPage);
        return menuItem;
    }
    
    /** Builds list of Menu Items
     * 
     * @param rs
     * @return ArrayList<MenuItem> 
     * @throws SQLException 
     */
    
    private static ArrayList<MenuItem> buildMenuItemList (ResultSet rs) throws SQLException
    {
        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        while (rs.next()) {
            MenuItem menuItem = buildMenuItem(rs);
            menuItems.add(menuItem);
        }
        return menuItems;
        }
    }
    

