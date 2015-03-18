/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.db;

/**
 *
 * @author Chris
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class MenuPageDBAccess {
  
    private static Connection conn;

    
    public static MenuPage retrieveByID(int id) throws ClassNotFoundException, SQLException {
        MenuPage menuPage;
        conn = DBConnection.getMyConnection();
        String query = ("select * from menu_pages where menu_page_id= \"" + id + "\"");
        System.out.println("query is " + query);  
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if (!rs.next()) {
            menuPage = null;   
        } else {
            menuPage = buildMenuPage(rs);
        }
        stmt.close();
        return menuPage;
    }

   
    public static ArrayList<MenuPage> retrieveByPage(int page) throws ClassNotFoundException, SQLException {
        ArrayList<MenuPage> menuPages;
        conn = DBConnection.getMyConnection();
        String query = ("select * from menu_pages where page_number= \"" + page + "\"");
        System.out.println("query is " + query);  
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        menuPages = buildMenuPageList(rs);

        stmt.close();
        return menuPages;
    }
       
    private static MenuPage buildMenuPage(ResultSet rs) throws SQLException {
        int menu_page_id = rs.getInt("menu_page_id");
        int menu_id = rs.getInt("menu_id");
        int page_number = rs.getInt("page_number");
        String image_id = rs.getString("image_id");
        int full_height = rs.getInt("full_height");
        int full_width = rs.getInt("full_width");
        Menu menu= new Menu(menu_id);
      

        MenuPage menuPage = new MenuPage(menu_page_id, menu, page_number, image_id, full_height, full_width);
        return menuPage;
    }

    private static ArrayList<MenuPage> buildMenuPageList(ResultSet rs) throws SQLException {
        ArrayList<MenuPage> menuPages = new ArrayList<MenuPage>();

        while (rs.next()) {
            MenuPage menuPage = buildMenuPage(rs);
            menuPages.add(menuPage);
        }
        return menuPages;
    
    
   
    
    }    
}
