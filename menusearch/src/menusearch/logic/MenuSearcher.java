/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.logic;

import java.sql.SQLException;
import static java.awt.SystemColor.menu;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import menusearch.db.SearchParameters;
import menusearch.domain.Menu;
import menusearch.db.MenuDBAccess;

/**
 *
 * @author estevamgarcia
 */
public class MenuSearcher{
    
    public static ArrayList<Menu> searchByKeyword(int id, int[] year, String sponsor, String event, String venue, 
            String place, String occasion, String location, String currency, String Dish, int[] pageCount, 
            int[] dishCount){
        
        ArrayList<Menu> menus = new ArrayList();
        SearchParameters p = new SearchParameters();
        String query = ("SELECT * FROM `nypl_menus`.`menus`");
        
        p.setGeneralQuery(query);
        p.setMenu_id(id);
        p.setVenue(venue);
        p.setPlace(place);
        p.setDish(Dish);
        p.setYear(year);
        p.setCurrency(currency);
        p.setEvent(event);
        p.setSponsor(sponsor);
        p.setOccasion(occasion);
        p.setPageCount(pageCount);
        p.setDishCount(dishCount);
        
        try{
            menus = MenuDBAccess.retrieveByComplexSearch(p);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Exception");
        }
        
        menus = searchMenuDB(p);
        
        return menus;
        
        
    }
    
    public static Menu searchById(int id){
        
        Menu menu = new Menu();
        
        String menuID = Integer.toString(id);
        
        try{
            menu = MenuDBAccess.retrieveByMenuID(menuID);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Exception");
        }
        
        return menu;
        
    }

    public static ArrayList<Menu> searchMenuDB(SearchParameters p) {
        
        ArrayList<Menu> menuList = new ArrayList();
        
        LocalDate menu_date = null;
        
        menu_date.withYear(1900);
        menu_date.withMonth(04);
        menu_date.withDayOfMonth(15);
        
        Menu menu = new Menu(12463, "", "HOTEL EASTMAN", "BREAKFAST", "COMMERCIAL", "HOT SPRINGS, AR",
                "CARD; 4.75X7.5", "EASTER", "", "1900-2822", "" , "", menu_date, "Hotel Eastman", "", "",
                "", "UNDER REVIEW", 2, 67);
            
        menuList.add(menu);
        
        return menuList;    
    }
    /*
     public static Menu retrieveByID(int menu_id)throws ClassNotFoundException, SQLException{
         Menu menu;
        
        menu = new Menu(MenuDBAccess.retrieveFullMenuByID(menu_id));
        return menu;
     }
   */
}