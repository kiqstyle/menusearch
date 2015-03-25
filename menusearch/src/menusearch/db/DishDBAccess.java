/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.db;
/**
 * @author ksmit001
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import menusearch.domain.Dish;


public class DishDBAccess {
    
      private static Connection conn;
      private static final String QUOTE = "\"";
      
     
    
      public static Dish retrieveByID(int dish_id) throws ClassNotFoundException, SQLException
      {
          Dish dish;
          conn = DBConnection.getMyConnection();
          String query = ("select * from dishes where dish_id= \"" + dish_id + "\"");
          System.out.println("query is " + query);  // usually would log to a logfile
          try (Statement stmt = conn.createStatement()) {
              ResultSet rs = stmt.executeQuery(query);
              if (!rs.next())
                  dish = null;   //no dish found
              else{
                  dish = buildDish(rs);
              }
          }
          return dish;
      }

    /**
     *
     * @param menuItemID
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Dish retrieveByMenuItemID(int menuItemID) throws ClassNotFoundException, SQLException
      {
         Dish dish = null;
        conn =DBConnection.getMyConnection();

        String query = ("select * from MenuItem where menu_items_id = \"" + menuItemID + "\"");
        System.out.println("query is " + query);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
         if (!rs.next())
              return null;   //no menuitem found
          else{
             dish = buildDish(rs);
          }
          stmt.close();
          return dish;
          
      }

    /**
     *
     * @param menu_id
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<Dish> retrieveByMenu(int menu_id)throws ClassNotFoundException, SQLException
      {
          ArrayList <Dish> dishes = null;
          Dish dish;
        conn =DBConnection.getMyConnection();

        String query = ("select * from MenuItem where menu_id = \"" + menu_id + "\"");
        System.out.println("query is " + query);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if(!rs.next())
            return null;
        else{
            while(rs.next())
            dishes.add(dish = buildDish(rs));
        }
                
            
        
        stmt.close();
        return dishes;
      }
      
      private static Dish buildDish(ResultSet rs) throws SQLException
      {
          int dish_id = rs.getInt("dish_id");
          String name = rs.getString("name");
          String description = rs.getString("description");
          int menus_appeared = rs.getInt("menus_appeared");
          int times_appeared = rs.getInt("times_appeared");
          int first_appeared = rs.getInt("first_appeared");
          int last_appeared = rs.getInt("last_appeared");
          double lowest_price = rs.getDouble("lowest_price");
          double highest_price = rs.getDouble("highest_price");
          Dish dish = new Dish(dish_id, name, description, menus_appeared, times_appeared, first_appeared, last_appeared, highest_price, lowest_price);
          return dish;
      }
}
      