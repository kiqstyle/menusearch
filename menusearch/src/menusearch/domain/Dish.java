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
    /**
     * Constructs a dish with a dish_id
     * @param dish_id 
     */
    public Dish(int dish_id){
        this.dish_id=dish_id;
       
        
    }
    /**
     * 
     * Constructs a full dish
     * @param dish_id
     * @param name
     * @param description
     * @param menus_appeared
     * @param times_appeared
     * @param first_appeared
     * @param last_appeared
     * @param lowest_price
     * @param highest_price 
     */
    public Dish(int dish_id, String name, String description, int menus_appeared, int times_appeared, int first_appeared, int last_appeared, double lowest_price, double highest_price ){
        this.dish_id=dish_id;
        this.name=name;
        this.description=description;
        this.menus_appeared=menus_appeared;
        this.times_appeared=times_appeared;
        this.first_appeared=first_appeared;
        this.last_appeared=last_appeared;
        this.lowest_price=lowest_price;
        this.highest_price=highest_price;
                
    }

    

    
    
    /**
     * 
     * @return dish_id
     */

    public int getDish_id() 
    {
        return dish_id;
    }
    /**
     * 
     * @param dish_id 
     */

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }
    /**
     * 
     * @return name of dish
     */

    public String getName() {
        return name;
    }
/**
 * sets the name of a dish
 * @param name 
 */
    public void setName(String name) {
        this.name = name;
    }
/**
 * 
 * @return description of the dish
 */
    public String getDescription() {
        return description;
    }
/**
 * sets the description of a dish
 * @param description 
 */
    public void setDescription(String description) {
        this.description = description;
    }
/**
 * 
 * @return the number of times a dish appeared in a menu
 */
    public int getMenusAppeared() {
        return menus_appeared;
    }
    /**
     * 
     * @param menusAppeared 
     */

    public void setMenusAppeared(int menusAppeared) {
        this.menus_appeared = menusAppeared;
    }
    /**
     * 
     * @return 
     */

    public int getTimes_Appeared() {
        return times_appeared;
    }
    /**
     * 
     * @param times_appeared 
     */

    public void setTimes_Appeared(int times_appeared) {
        this.times_appeared = times_appeared;
    }
    /**
     * 
     * @return 
     */

    public int getFirst_appeared() {
        return first_appeared;
    }
    /**
     * 
     * @param first_appeared 
     */

    public void setFirst_Appeared(int first_appeared) {
        this.first_appeared = first_appeared;
    }
    /**
     * 
     * @return 
     */

    public int getLast_Appeared() {
        return last_appeared;
    }
/**
 * 
 * @param last_appeared 
 */
    public void setLast_Appeared(int last_appeared) {
        this.last_appeared = last_appeared;
    }
    /**
     * 
     * @return 
     */

    public double getLowest_price() {
        return lowest_price;
    }
/**
 * 
 * @param lowest_price 
 */
    public void setLowest_price(double lowest_price) {
        this.lowest_price = lowest_price;
    }
    /**
     * 
     * @return 
     */

    public double getHighest_price() {
        return highest_price;
    }
    /**
     * 
     * @param highest_price 
     */

    public void setHighest_price(double highest_price) {
        this.highest_price = highest_price;
    }  
}
