package menusearch.json;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;



public class RecipeSummary {

  private String html;
  private String url; 
  private String text;
  private String logo;
  private int totalMatches; 

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
 /*
 public RecipeSummary parseRecipes(String query) throws IOException {

 RecipeSummary recipeSummary = new RecipeSummary();
 
 String attributes = JSONProcessor.searchYummly(query);


 
   JSONObject newObject = new JSONObject(attributes);
   JSONObject at = newObject.getJSONObject("attribution");
  
  
  html =(String) at.get("html");
  recipeSummary.setHtml(html);

  url = (String) at.get("url");
  recipeSummary.setUrl(url);
  
  
  text = (String) at.get("text");
  recipeSummary.setText(text);

  
  logo = (String) at.get("logo");
  recipeSummary.setLogo(logo);
 
   
 totalMatches = newObject.getInt("totalMatchCount");
 recipeSummary.setTotalmatches(totalMatches); 
   
       
  return recipeSummary;
       
       }
       
 @Override
 public String toString(){
  return "Recipe Summary: " + "\n" + "Html: " + html  + "\n" + "URL: " + url
     + "\n" + "Text: " + text + "\n" + "Logo: " + logo + "\n" + "Total Matches: " 
     + totalMatches;
   
    
}   
    
    

    public static void main(String[] args) throws IOException {
   String sampleFile = "http://api.yummly.com/v1/api/recipes?_app_id=95a21eb2&_app_key=d703fa9e11ee34f104bc271ec3bbcdb9&q=garlic";
    RecipeSummary sample = new RecipeSummary();
    sample.parseRecipes(sampleFile);
    System.out.println(sample.toString());
        
     }
    */
    
}