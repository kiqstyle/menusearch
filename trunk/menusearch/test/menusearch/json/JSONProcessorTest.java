/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusearch.json;

import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import menusearch.domain.*;

/**
 *
 * @author mackellb
 */
public class JSONProcessorTest {
    
    public JSONProcessorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getRecipeAPI method, of class JSONProcessor.
     */
    @Test
    public void testGetRecipeAPI() throws Exception {
        System.out.println("getRecipeAPI");
        String searchValue = "Chicken Noodle Soup";
        String expResult = "";
        String result = JSONProcessor.getRecipeAPI(searchValue);
        System.err.println(result);
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
    }
    
    @Test
    public void testParseRecipe() throws IOException
    {
        String jsonString = "{\"yield\":\"6 Servings\",\"nutritionEstimates\":[{\"attribute\":\"FAT_KCAL\",\"description\":null,\"value\":45.00,\"unit\":{\"id\":\"fea252f8-9888-4365-b005-e2c63ed3a776\",\"name\":\"calorie\",\"abbreviation\":\"kcal\",\"plural\":\"calories\",\"pluralAbbreviation\":\"kcal\",\"decimal\":true}},{\"attribute\":\"FOLDFE\",\"description\":\"Folate, DFE\",\"value\":34.65,\"unit\":{\"id\":\"4d783ee4-aa07-4958-84bf-3f4b528049dc\",\"name\":\"mcg_DFE\",\"abbreviation\":\"mcg_DFE\",\"plural\":\"mcg_DFE\",\"pluralAbbreviation\":\"mcg_DFE\",\"decimal\":false}},{\"attribute\":\"FOLFD\",\"description\":\"Folate, food\",\"value\":0.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"CARTA\",\"description\":\"Carotene, alpha\",\"value\":0.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"MN\",\"description\":\"Manganese, Mn\",\"value\":0.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"TOCPHA\",\"description\":\"Vitamin E (alpha-tocopherol)\",\"value\":0.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"FAMS\",\"description\":\"Fatty acids, total monounsaturated\",\"value\":4.81,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"VITC\",\"description\":\"Vitamin C, total ascorbic acid\",\"value\":0.01,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"CARTB\",\"description\":\"Carotene, beta\",\"value\":0.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"FOL\",\"description\":\"Folate, total\",\"value\":0.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"GLUS\",\"description\":\"Glucose (dextrose)\",\"value\":0.31,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"CHOLE\",\"description\":\"Cholesterol\",\"value\":0.01,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"NIA\",\"description\":\"Niacin\",\"value\":0.01,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"TOCPHG\",\"description\":\"Tocopherol, gamma\",\"value\":0.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"FRUS\",\"description\":\"Fructose\",\"value\":0.31,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"VITK\",\"description\":\"Vitamin K (phylloquinone)\",\"value\":0.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"K\",\"description\":\"Potassium, K\",\"value\":0.62,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"VITA_IU\",\"description\":\"Vitamin A, IU\",\"value\":5374.59,\"unit\":{\"id\":\"ed46fe0c-44fe-4c1f-b3a8-880f92e30930\",\"name\":\"IU\",\"abbreviation\":\"IU\",\"plural\":\"IU\",\"pluralAbbreviation\":\"IU\",\"decimal\":true}},{\"attribute\":\"CHOLN\",\"description\":\"Choline, total\",\"value\":0.05,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"P\",\"description\":\"Phosphorus, P\",\"value\":0.14,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"PHYSTR\",\"description\":\"Phytosterols\",\"value\":0.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"ENERC_KJ\",\"description\":\"Energy\",\"value\":782.59,\"unit\":{\"id\":\"fea252f8-9888-4365-b005-e2c63ed3a776\",\"name\":\"calorie\",\"abbreviation\":\"kcal\",\"plural\":\"calories\",\"pluralAbbreviation\":\"kcal\",\"decimal\":true}},{\"attribute\":\"SUCS\",\"description\":\"Sucrose\",\"value\":1.22,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"SE\",\"description\":\"Selenium, Se\",\"value\":0.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"FIBTG\",\"description\":\"Fiber, total dietary\",\"value\":1.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"NA\",\"description\":\"Sodium, Na\",\"value\":0.84,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"LYCPN\",\"description\":\"Lycopene\",\"value\":0.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"ZN\",\"description\":\"Zinc, Zn\",\"value\":0.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"ENERC_KCAL\",\"description\":\"Energy\",\"value\":186.50,\"unit\":{\"id\":\"fea252f8-9888-4365-b005-e2c63ed3a776\",\"name\":\"calorie\",\"abbreviation\":\"kcal\",\"plural\":\"calories\",\"pluralAbbreviation\":\"kcal\",\"decimal\":true}},{\"attribute\":\"LUT+ZEA\",\"description\":\"Lutein + zeaxanthin\",\"value\":0.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"SUGAR\",\"description\":\"Sugars, total\",\"value\":11.15,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"ASH\",\"description\":\"Ash\",\"value\":5.50,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"WATER\",\"description\":\"Water\",\"value\":471.24,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"STARCH\",\"description\":\"Starch\",\"value\":0.31,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"VITA_RAE\",\"description\":\"Vitamin A, RAE\",\"value\":272.71,\"unit\":{\"id\":\"0fcf76b3-891a-403d-883f-58c8809ef151\",\"name\":\"mcg_RAE\",\"abbreviation\":\"mcg_RAE\",\"plural\":\"mcg_RAE\",\"pluralAbbreviation\":\"mcg_RAE\",\"decimal\":false}},{\"attribute\":\"FAT\",\"description\":\"Total lipid (fat)\",\"value\":4.83,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"MG\",\"description\":\"Magnesium, Mg\",\"value\":0.02,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"F18D1\",\"description\":\"18:1 undifferentiated\",\"value\":0.01,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"CHOCDF\",\"description\":\"Carbohydrate, by difference\",\"value\":22.45,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"PROCNT\",\"description\":\"Protein\",\"value\":14.80,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"FLD\",\"description\":\"Fluoride, F\",\"value\":0.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"CA\",\"description\":\"Calcium, Ca\",\"value\":0.03,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"RETOL\",\"description\":\"Retinol\",\"value\":0.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}},{\"attribute\":\"FE\",\"description\":\"Iron, Fe\",\"value\":0.00,\"unit\":{\"id\":\"12485d26-6e69-102c-9a8a-0030485841f8\",\"name\":\"gram\",\"abbreviation\":\"g\",\"plural\":\"grams\",\"pluralAbbreviation\":\"grams\",\"decimal\":true}}],\"totalTime\":\"40 min\",\"images\":[{\"imageUrlsBySize\":{\"90\":\"null=s90-c\",\"360\":\"null=s360-c\"}}],\"name\":\"Chicken Noodle Soup\",\"source\":{\"sourceRecipeUrl\":\"http://allrecipes.com/Recipe/Chicken-Noodle-Soup-3/Detail.aspx\",\"sourceSiteUrl\":\"http://www.allrecipes.com\",\"sourceDisplayName\":\"AllRecipes\"},\"id\":\"Chicken-Noodle-Soup-Allrecipes\",\"ingredientLines\":[\"3 quarts homemade chicken stock, or canned low-sodium chicken broth\",\"3 carrots, cut into 1/8-inch-thick rounds\",\"Salt and freshly ground black pepper\",\"Salt and freshly ground black pepper\",\"8 ounces medium egg noodles\",\"Cooked chicken meat, shredded\",\"1/4 cup chopped fresh dill\",\"1/4 cup fresh flat-leaf parsley\"],\"attribution\":{\"html\":\"<a href='http://www.yummly.com/recipe/Chicken-Noodle-Soup-Allrecipes'>Chicken Noodle Soup recipe</a> information powered by <img alt='Yummly' src='http://static.yummly.com/api-logo.png'/>\",\"url\":\"http://www.yummly.com/recipe/Chicken-Noodle-Soup-Allrecipes\",\"text\":\"Chicken Noodle Soup recipes: information powered by Yummly\",\"logo\":\"http://static.yummly.com/api-logo.png\"},\"numberOfServings\":6,\"totalTimeInSeconds\":2400,\"attributes\":{\"course\":[\"Soups\",\"Lunch and Snacks\"]},\"flavors\":{\"Sweet\":0.1667,\"Salty\":0.1667,\"Bitter\":0.1667,\"Sour\":0.3333,\"Meaty\":0.0000,\"Piquant\":0.0000},\"rating\":3} ";
        
        Recipe myRecipe = JSONProcessor.parseRecipe(jsonString);
        
        assertEquals ("Chicken Noodle Soup", myRecipe.getName());
        
    
    }

    /**
     * Test of buildQuery method, of class JSONProcessor.
     */
    @Test
    public void testBuildQuery() throws Exception {
        System.out.println("buildQuery");
        Parameters p = new Parameters();
        p.addAllowedCourses("dinner");
        p.setSearchPhrase("tacos");
        String expResult = "";
        String result = JSONProcessor.buildQuery(p);
        System.err.println(result);
   //     assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
    }

 
    
}
