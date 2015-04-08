
package menusearch.json;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;



public class RecipeSummaryList {

  ArrayList <RecipeSummary> matches;  
  private String html;
  private String url; 
  private String text;
  private String logo;
  private int totalMatches; 

    public RecipeSummaryList() {
        this.matches = new ArrayList(100);
    }

    public ArrayList<RecipeSummary> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<RecipeSummary> matches) {
        this.matches = matches;
    }
  
    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }
   
    public void setTotalmatches(int totalmatches) {
        this.totalMatches = totalmatches;
    }
 
 

    
    

    
    
}