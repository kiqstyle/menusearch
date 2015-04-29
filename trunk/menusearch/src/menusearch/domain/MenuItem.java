package menusearch.domain;

import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * MenuItem domain class, based on the nypl_menus database table.
 * 
 * @author Nicole Kim
 */
public class MenuItem {
    
    private int menu_items_id;
    private float price;
    private float high_price;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private float xpos;
    private float ypos;
    private Dish dish;
    private ArrayList<MenuPage> menuPages;

    public MenuItem() {  }

    public MenuItem (int menu_items_id) {
    
       this.menu_items_id = menu_items_id;
    }
    
    public MenuItem(int menu_items_id, float price, float high_price, 
            LocalDateTime created_at, LocalDateTime updated_at, float xpos, 
            float ypos, Dish dish, MenuPage menuPage) {
    
        this.menu_items_id = menu_items_id;
        this.price = price;
        this.high_price = high_price;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.xpos = xpos;
        this.ypos = ypos;
        this.dish = dish;
        this.menuPages = menuPages;   
    }

    public void addMenuPage (MenuPage menuPage) {
        menuPages.add(menuPage);
    }
    
    public int getMenu_items_id() {
        return menu_items_id;
    }

    public void setMenu_items_id(int menu_items_id) {
        this.menu_items_id = menu_items_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getHigh_price() {
        return high_price;
    }

    public void setHigh_price(float high_price) {
        this.high_price = high_price;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public float getXpos() {
        return xpos;
    }

    public void setXpos(float xpos) {
        this.xpos = xpos;
    }

    public float getYpos() {
        return ypos;
    }

    public void setYpos(float ypos) {
        this.ypos = ypos;
    }

    public void setDish (Dish dish) {
        this.dish=dish;
    }
    
   public Dish getDish() {
        return dish;
    }

    public ArrayList<MenuPage> getMenupage() {
        return menuPages;
    }

    public void setMenupage(ArrayList<MenuPage> menuPages) {
        this.menuPages = menuPages;
    }
}

    
    
