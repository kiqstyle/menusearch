package menusearch.domain;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Menu domain class, based on the nypl_menus database table.
 * 
 * @author Randy Gingeleski
 */
public class Menu {
    
    private int menu_id, page_count, dish_count;
    
    private String name, sponsor, event, venue, place, occasion, call_number,
            location, location_type, currency, currency_symbol, status,
            language, physical_description, keywords, notes;
    
    private LocalDate menu_date;
    private ArrayList<MenuPage> menuPages;
    private String stringDate;
    
    /**
     * Create totally empty Menu.
     */
    public Menu() { }
    
    /**
     * Create Menu from just an ID.
     * 
     * @param menu_id 
     */
    public Menu(int menu_id) {
        
        this.menu_id = menu_id;
    }
    
    /**
     * Create Menu with all variables accounted for.
     * 
     * @param menu_id
     * @param name
     * @param sponsor
     * @param event
     * @param venue
     * @param place
     * @param physical_description
     * @param occasion
     * @param notes
     * @param call_number
     * @param keywords
     * @param language
     * @param menu_date
     * @param location
     * @param location_type
     * @param currency
     * @param currency_symbol
     * @param status
     * @param page_count
     * @param dish_count 
     */
    public Menu(int menu_id, String name, String sponsor, String event,
            String venue, String place, String physical_description,
            String occasion, String notes, String call_number,
            String keywords, String language, LocalDate menu_date,
            String location, String location_type, String currency,
            String currency_symbol, String status, int page_count,
            int dish_count) {
        
        this.menu_id = menu_id;
        this.name = name;
        this.sponsor = sponsor;
        this.event = event;
        this.venue = venue;
        this.place = place;
        this.physical_description = physical_description;
        this.occasion = occasion;
        this.notes = notes;
        this.call_number = call_number;
        this.keywords = keywords;
        this.language = language;
        this.menu_date = menu_date;
        this.location = location;
        this.location_type = location_type;
        this.currency = currency;
        this.currency_symbol = currency_symbol;
        this.status = status;
        this.page_count = page_count;
        this.dish_count = dish_count;
    }
    
    /**
     * Add a MenuPage to this Menu.
     * 
     * @param menuPage - the MenuPage to add.
     */
    public void addMenuPage(MenuPage menuPage) {
        menuPages.add(menuPage);
    }
    
    /**
     * @return menu_id
     */
    public int getMenu_id() {
        return menu_id;
    }

    /**
     * @param menu_id - the menu_id to set.
     */
    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    /**
     * @return page_count
     */
    public int getPage_count() {
        return page_count;
    }

    /**
     * @param page_count - the page_count to set.
     */
    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }

    /**
     * @return dish_count
     */
    public int getDish_count() {
        return dish_count;
    }

    /**
     * @param dish_count - the dish_count to set.
     */
    public void setDish_count(int dish_count) {
        this.dish_count = dish_count;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name - the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return sponsor
     */
    public String getSponsor() {
        return sponsor;
    }

    /**
     * @param sponsor - the sponsor to set.
     */
    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    /**
     * @return event
     */
    public String getEvent() {
        return event;
    }

    /**
     * @param event - the event to set.
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * @return venue
     */
    public String getVenue() {
        return venue;
    }

    /**
     * @param venue - the venue to set.
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * @return place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place - the place to set.
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return occasion
     */
    public String getOccasion() {
        return occasion;
    }

    /**
     * @param occasion - the occasion to set.
     */
    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    /**
     * @return call_number
     */
    public String getCall_number() {
        return call_number;
    }

    /**
     * @param call_number - the call_number to set.
     */
    public void setCall_number(String call_number) {
        this.call_number = call_number;
    }

    /**
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location - the location to set.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return location_type
     */
    public String getLocation_type() {
        return location_type;
    }

    /**
     * @param location_type - the location_type to set.
     */
    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    /**
     * @return currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency - the currency to set.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return currency_symbol
     */
    public String getCurrency_symbol() {
        return currency_symbol;
    }

    /**
     * @param currency_symbol - the currency_symbol to set.
     */
    public void setCurrency_symbol(String currency_symbol) {
        this.currency_symbol = currency_symbol;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status - the status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language - the language to set.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return physical_description
     */
    public String getPhysical_description() {
        return physical_description;
    }

    /**
     * @param physical_description - the physical_description to set.
     */
    public void setPhysical_description(String physical_description) {
        this.physical_description = physical_description;
    }

    /**
     * @return keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords - the keywords to set.
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * @return notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes - the notes to set.
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return menu_date
     */
    public LocalDate getMenu_date() {
        return menu_date;
    }

    /**
     * @param menu_date - the menu_date to set.
     */
    public void setMenu_date(LocalDate menu_date) {
        this.menu_date = menu_date;
    }

    /**
     * @return menuPages
     */
    public ArrayList<MenuPage> getMenuPages() {
        return menuPages;
    }

    /**
     * @param menuPages - the menuPages to set.
     */
    public void setMenuPages(ArrayList<MenuPage> menuPages) {
        this.menuPages = menuPages;
    }
    
    public String toString() {
        return sponsor + ", Year: " + menu_date.getYear() + ", Dishes: " + dish_count;
    }
}
