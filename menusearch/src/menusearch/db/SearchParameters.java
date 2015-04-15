package menusearch.db;

import java.util.Arrays;

/**
 * Parameters for a complex Menu search (i.e. Caesar Salad in New York).
 * 
 * @author Randy Gingeleski
 */
public class SearchParameters {
    
    private String generalQuery, venue, place, dish, currency, event, sponsor,
            occasion;
    private int menu_id = 0;
    private int[] year = {0, 0};
    private int[] pageCount = {0, 0};
    private int[] dishCount = {0, 0};
    
    /**
     * Initialize a SearchParameters object with nothing.
     */
    public SearchParameters() { }
    
    /**
     * Initialize a SearchParameters object with only a general query.
     * Specifically used in seeing if a given parameter set "contains" only
     * that.
     * 
     * @param generalQuery 
     */
    public SearchParameters(String generalQuery) {
        this.generalQuery = generalQuery;
    }
    
    /**
     * @return generalQuery - a general search query that's going to search
     *                        everything. All fields.
     */
    public String getGeneralQuery() {
        return generalQuery;
    }

    /**
     * @param generalQuery - a general search query that's going to search
     *                       everything. All fields.
     */
    public void setGeneralQuery(String generalQuery) {
        this.generalQuery = generalQuery;
    }

    /**
     * @return menu_id - specific Menu ID number. Will yield one result when
     *                   searched (if a valid number). Field: menu_id.
     */
    public int getMenu_id() {
        return menu_id;
    }

    /**
     * @param menu_id - specific Menu ID number. Will yield one result when
     *                   searched (if a valid number). Field: menu_id.
     */
    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    /**
     * @return venue - restaurant or wherever the menu is for. Field: location.
     */
    public String getVenue() {
        return venue;
    }

    /**
     * @param venue - restaurant or wherever the menu is for. Field: location.
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * @return place - generally city, like "New York". Field: place.
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place - generally city, like "New York". Field: place.
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return dish - search for menus that serve this. Not in the Menu table.
     */
    public String getDish() {
        return dish;
    }

    /**
     * @param dish - search for menus that serve this. Not in the Menu table.
     */
    public void setDish(String dish) {
        this.dish = dish;
    }

    /**
     * @return year - an array for a year query. [0] is min, [1] is max. If
     *                it's a straight search then both are set equal.
     *                Field: year.
     */
    public int[] getYear() {
        return year;
    }

    /**
     * @param year - an array for a year query. [0] is min, [1] is max. If
     *               it's a straight search then both are set equal.
     *               Field: year.
     */
    public void setYear(int[] year) {
        this.year = year;
    }

    /**
     * @return currency - "dollars", for example. Field: currency.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency - "dollars", for example. Field: currency.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return event - a meal event, for example "breakfast". Field: event.
     */
    public String getEvent() {
        return event;
    }

    /**
     * @param event - a meal event, for example "breakfast". Field: event.
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * @return sponsor - company, for example "Pacific Mail Steamship Company".
     *                   Field: sponsor.
     */
    public String getSponsor() {
        return sponsor;
    }

    /**
     * @param sponsor - company, for example "Pacific Mail Steamship Company".
     *                  Field: sponsor.
     */
    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    /**
     * @return occasion - dining occasion, in example "Easter" or "Daily".
     *                    Field: occasion.
     */
    public String getOccasion() {
        return occasion;
    }

    /**
     * @param occasion - dining occasion, in example "Easter" or "Daily".
     *                   Field: occasion.
     */
    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    /**
     * @return pageCount - an array for a page count query. [0] is min, [1] is
     *                     max If it's a straight search then both are set
     *                     equal. Field: page_count.
     */
    public int[] getPageCount() {
        return pageCount;
    }

    /**
     * @param pageCount - an array for a page count query. [0] is min, [1] is
     *                    max If it's a straight search then both are set equal.
     *                    Field: page_count.
     */
    public void setPageCount(int[] pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * @return dishCount - an array for a dish count query. [0] is min, [1] is
     *                    max If it's a straight search then both are set equal.
     *                    Field: dish_count.
     */
    public int[] getDishCount() {
        return dishCount;
    }

    /**
     * @param dishCount - an array for a dish count query. [0] is min, [1] is
     *                    max If it's a straight search then both are set equal.
     *                    Field: dish_count.
     */
    public void setDishCount(int[] dishCount) {
        this.dishCount = dishCount;
    }
    
    /**
     * Tests whether this SearchParameters object has value equality
     * with another specified SearchParameters object.
     * 
     * @param testParam
     * @return 
     */
    public Boolean equals(SearchParameters testParam) {
        
        if (this == testParam) {        return true;        }
        
        else if (testParam == null) {       return false;       }
        
        else if (testParam instanceof SearchParameters) {
            
            SearchParameters compParam = (SearchParameters) testParam;
            int[] zeroArray = {0, 0};
            
            if
            (((compParam.generalQuery == null && this.generalQuery == null) ||
                    (compParam.getGeneralQuery().equals(this.generalQuery))) &&
            ((compParam.venue == null && this.venue == null) ||
                    (compParam.getVenue().equals(this.venue))) &&
            ((compParam.place == null && this.place == null) ||
                    (compParam.getPlace().equals(this.place))) &&
            ((compParam.dish == null && this.dish == null) ||
                    (compParam.getDish().equals(this.dish))) &&
            ((compParam.currency == null && this.currency == null) ||
                    (compParam.getCurrency().equals(this.currency))) &&
            ((compParam.event == null && this.event == null) ||
                    (compParam.getEvent().equals(this.event))) &&
            ((compParam.sponsor == null && this.sponsor == null) ||
                    (compParam.getSponsor().equals(this.sponsor))) &&
            ((compParam.occasion == null && this.occasion == null) ||
                    (compParam.getOccasion().equals(this.occasion))) &&
            ((compParam.menu_id == 0 && this.menu_id == 0) ||
                    (compParam.menu_id == this.menu_id)) &&
            ((Arrays.equals(zeroArray, compParam.year)) ||
                    (Arrays.equals(zeroArray, this.year)) ||
                    (Arrays.equals(compParam.getYear(), this.year))) &&
            ((Arrays.equals(zeroArray, compParam.pageCount)) ||
                    (Arrays.equals(zeroArray, this.pageCount)) ||
                    (Arrays.equals(compParam.getPageCount(), this.pageCount)))
            && ((Arrays.equals(zeroArray, compParam.dishCount)) ||
                    (Arrays.equals(zeroArray, this.dishCount)) ||
                    (Arrays.equals(compParam.getDishCount(), this.dishCount))))
            {    
                return true;
            }
        
            return false;
        }
        
        return false;     
    }
}
