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
import menusearch.domain.*;
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

    public static ArrayList<MenuPage> retrieveByMenuID(int menuID) throws ClassNotFoundException, SQLException {
        ArrayList<MenuPage> menuPages;
        conn = DBConnection.getMyConnection();
        String query = ("select * from menu_pages where menu_id= \"" + menuID + "\"");
        System.out.println("query is " + query);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        menuPages = buildMenuPageList(rs);

        stmt.close();
        return menuPages;
    }

    public static ArrayList<MenuPage> retrieveByMenuItemID(int menuItemID) throws ClassNotFoundException, SQLException {
        ArrayList<MenuPage> menuPages;
        conn = DBConnection.getMyConnection();
        String query = ("select menu_pages.menu_page_id, menu_pages.menu_id, menu_pages.page_number, menu_pages.image_id, menu_pages.full_height, menu_pages.full_width from menu_pages, menu_items where menu_items_id= \"" + menuItemID + "\"" + "and menu_pages.menu_page_id=menu_items.menu_page_id");
        System.out.println("query is " + query);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        menuPages = buildMenuPageList(rs);

        stmt.close();
        return menuPages;
    }

    public static void populateMenu(MenuPage page) throws ClassNotFoundException,
            SQLException {
        
        String menuPageID = Integer.toString(page.getMenu_page_id());
        Menu menu = MenuDBAccess.retrieveByMenuPageID(menuPageID);
        page.setMenu(menu);
    }

    public static void populateMenuItems(MenuPage page) throws ClassNotFoundException, SQLException {
        
        String menuPageID = Integer.toString(page.getMenu_page_id());
        ArrayList<MenuItem> menuItem = MenuItemDBAccess.retrieveByMenuPageID(menuPageID);
        page.setMenuItems(menuItem);
    }

    public static MenuPage buildMenuPage(ResultSet rs) throws SQLException {
        int menu_page_id = rs.getInt("menu_page_id");
        int menu_id = rs.getInt("menu_id");
        int page_number = rs.getInt("page_number");
        String image_id = rs.getString("image_id");
        int full_height = rs.getInt("full_height");
        int full_width = rs.getInt("full_width");
        Menu menu = new Menu(menu_id);

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
