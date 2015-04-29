package menusearch.domain;

import java.util.ArrayList;

/**
 * MenuPage domain class, based on the nypl_menus database table.
 * 
 * @author Chris Dhanapala
 */
public class MenuPage {

    private int menu_page_id;
    private Menu menu;
    private int page_number;
    private String image_id;
    private int full_height;
    private int full_width;
    private ArrayList<MenuItem> menuItems;

    public MenuPage() {  }

    public MenuPage(int menu_page_id) {
        
        this.menu_page_id = menu_page_id;
    }

    public MenuPage(int menu_page_id, Menu menu, int page_number, 
            String image_id, int full_height, int full_width) {
        
        this.menu_page_id = menu_page_id;
        this.menu = menu;
        this.page_number = page_number;
        this.image_id = image_id;
        this.full_height = full_height;
        this.full_width = full_width;
    }

    public int getMenu_page_id() {
        return menu_page_id;
    }

    public void setMenu_page_id(int menu_page_id) {
        this.menu_page_id = menu_page_id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getPage_number() {
        return page_number;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public int getFull_height() {
        return full_height;
    }

    public void setFull_height(int full_height) {
        this.full_height = full_height;
    }

    public int getFull_width() {
        return full_width;
    }

    public void setFull_width(int full_width) {
        this.full_width = full_width;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}