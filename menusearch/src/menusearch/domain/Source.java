/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.domain;

/**
 *
 * @author matthewshields
 */
public class Source {
    
    private String sourceRecipeUrl;
    private String sourceSiteUrl;
    private String sourceDisplayNaame;
    
    public Source()
    {
        
    }

    public String getSourceRecipeUrl() {
        return sourceRecipeUrl;
    }

    public void setSourceRecipeUrl(String sourceRecipeUrl) {
        this.sourceRecipeUrl = sourceRecipeUrl;
    }

    public String getSourceSiteUrl() {
        return sourceSiteUrl;
    }

    public void setSourceSiteUrl(String sourceSiteUrl) {
        this.sourceSiteUrl = sourceSiteUrl;
    }

    public String getSourceDisplayNaame() {
        return sourceDisplayNaame;
    }

    public void setSourceDisplayNaame(String sourceDisplayNaame) {
        this.sourceDisplayNaame = sourceDisplayNaame;
    }
    
    
    
}
