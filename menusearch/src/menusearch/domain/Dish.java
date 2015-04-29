package menusearch.domain;

/**
 * Dish domain class, based on the nypl_menus database table.
 * 
 * @author Kenny Smith
 */
public class Dish {
    
    private int dish_id;
    private String name;
    private String description;
    private int menus_appeared;
    private int times_appeared;
    private int first_appeared;
    private int last_appeared;
    private double lowest_price;
    private double highest_price;
    
    public Dish() {   }
    
    public Dish(int dish_id) {   this.dish_id = dish_id;    }
    
    public Dish(int dish_id, String name, String description, 
            int menus_appeared, int times_appeared, int first_appeared, 
            int last_appeared, double lowest_price, double highest_price) {
        
        this.dish_id = dish_id;
        this.name = name;
        this.description = description;
        this.menus_appeared = menus_appeared;
        this.times_appeared = times_appeared;
        this.first_appeared = first_appeared;
        this.last_appeared = last_appeared;
        this.lowest_price = lowest_price;
        this.highest_price = highest_price;  
    }

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMenusAppeared() {
        return menus_appeared;
    }

    public void setMenusAppeared(int menusAppeared) {
        this.menus_appeared = menusAppeared;
    }

    public int getTimes_Appeared() {
        return times_appeared;
    }

    public void setTimes_Appeared(int times_appeared) {
        this.times_appeared = times_appeared;
    }

    public int getFirst_appeared() {
        return first_appeared;
    }

    public void setFirst_Appeared(int first_appeared) {
        this.first_appeared = first_appeared;
    }

    public int getLast_Appeared() {
        return last_appeared;
    }

    public void setLast_Appeared(int last_appeared) {
        this.last_appeared = last_appeared;
    }

    public double getLowest_price() {
        return lowest_price;
    }

    public void setLowest_price(double lowest_price) {
        this.lowest_price = lowest_price;
    }

    public double getHighest_price() {
        return highest_price;
    }

    public void setHighest_price(double highest_price) {
        this.highest_price = highest_price;
    }  
}
