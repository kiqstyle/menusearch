/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.logic;

import java.util.ArrayList;
import menusearch.domain.*;

/**
 *
 * @author estevamgarcia
 */
public class MenuSearcher{
    
    public ArrayList<Menu> menus = new ArrayList();
    
    public ArrayList<Menu> MenuSearcher(String name, String sponsor, String event, String venue, String place, 
            String physicalDescription, String occasion, String notes, String callNumber, String keywords,
            String language, String menuDate, String location, String locationType, String currency,
            String currencySymbol, String status, int pageCount, int dishCount){
        
        
        ParametersMenu p = new ParametersMenu();
        
        p.nameToSearch(name);
        p.sponsorToSearch(sponsor);
        p.eventToSearch(event);
        p.venueToSearch(venue);
        p.physicalDescriptionToSearch(physicalDescription);
        p.occasionToSearch(occasion);
        p.notesToSearch(notes);
        p.callNumberToSearch(callNumber);
        p.keywordsToSearch(keywords);
        p.languageToSearch(language);
        p.menuDateToSearch(menuDate);
        p.locationToSearch(location);
        p.locationTypeToSearch(locationType);
        p.currencyToSearch(currency);
        p.currencySymbolToSearch(currencySymbol);
        p.statusToSearch(status);
        p.pageCountToSearch(pageCount);
        p.dishCountToSearch(dishCount);
        
        menus = searchMenuDB(p);
        
        return menus;
        
        
    }
}