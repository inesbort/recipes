import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
//import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.net.Socket;

import java.util.Collections;
import java.util.StringTokenizer;
import java.util.List;

import java.sql.*;
import javax.sql.rowset.*;

public class ThePrototype {
    public static List<Recipe> appropriateList;
    public static List<Recipe> inappropriateList;
    public static List<String> presentIngredients;
    public static List<String> neededIngredients;

    public int missingIngredients=0;

    private CachedRowSet serviceOutcome = null;
    private static ResultSet outcome   = null;


    public static void main(String[] args) {

    }
    public ThePrototype(List<String> fridge){
        presentIngredients=fridge;
    }

    public static void setPresentIngredients(List<String> fridge ){
        presentIngredients=fridge;
    }

    public static List<String> getPresentIngredients() {
        return presentIngredients;
    }

    public static List<Recipe> getAppropriateList() {
        return appropriateList;
    }

    public static void execute() throws SQLException, ClassNotFoundException {
        //For each ingredient present in the fridge, a select statement will be run, which will
        //return recipe_ids for all records containing that ingredient.

        //OK SO for each ingredient in the fridge it selects all recipes which use it
        //For each recipe returned it gets its ingredients and 'evaluates it'

        //These can be transformed into recipe objects, with a list ingredient attribute

        //Each recipe’s ingredient list will be cross checked against the list of existing ingredients

        // If there
        //exists an item in the recipe not in the fridge, the recipe will get added to a list labelled
        //‘inappropriate’. If no items are missing it will be added to the ‘appropriate’ list.

        //If the user has
        //enabled the option to view incomplete recipes, the amount of missing ingredients per recipe
        //will also be calculated

        //To display the list, each recipe object will be passed to a section which will once again
        //access the database, in order to retrieve the information to be displayed to the user on the
        //app
        String ingr;
        String sql1 = "CREATE VIEW public.";

        for (String i:presentIngredients) {

            //should return a table every recipe that uses that ingredient
            String sql = "SELECT recipe.recipe_id, description,prep_time, cook_time, img  FROM recipe FULL JOIN link_recipe_ingredient ON recipe.recipe_id=link_recipe_ingredient.recipe_id FULL JOIN ingredient ON link_recipe_ingredient.ingredient_id=ingredient.ingredient_id  WHERE ingredient.ingr_name=" + i+"GROUP BY id,description,preptime,cooktime,img";
            //now for each recipe get all ingredients
            Class.forName("org.postgresql.Driver");

            //3. Open connection
            Connection con = DriverManager.getConnection(Credentials.URL, Credentials.USERNAME, Credentials.PASSWORD);

            //4. Query

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            RowSetFactory aFactory= RowSetProvider.newFactory();
            CachedRowSet crs = aFactory.createCachedRowSet();
            crs.populate(rs);
            outcome=crs;

            rs.close();
            stmt.close();
            con.close();


            Recipe newRecipe= new Recipe();
            while (crs.next()){
                newRecipe.setId(crs.getInt("id"));
                newRecipe.setCook_time(crs.getString("cooktime"));
                newRecipe.setPrep_time(crs.getString("preptime"));
                newRecipe.setImage(crs.getString("img"));
                newRecipe.setDescription(crs.getString("description"));
                //newRecipe.addIngredient(crs.getString("ingredient"));
                addIngredients(newRecipe);
               // System.out.println(crs.getString("title")+"|"+crs.getString("label")+"|"+crs.getString("genre")+"|"+(crs.getString("rrp")+"|"+crs.getString(5)));
            }
            evaluateRecipe(newRecipe);
            if (Recipe.getWeight()==0){
                appropriateList.add(newRecipe);
            }else{
                inappropriateList.add(newRecipe);
            }
        }
       // Collections.sort(inappropriateList, new RecipeComparator());
        inappropriateList.sort(new RecipeComparator());
    }
    public static void addIngredients(Recipe recipe) throws ClassNotFoundException, SQLException {
        //now for each recipe get all ingredients
        String sql = "SELECT ingredient.ingr_name FROM ingredient FULL JOIN link_recipe_ingredient ON ingredient.ingredient_id= link_recipe_ingredient.ingredient_id WHERE link_recipe_ingredient.recipe_id="+ Recipe.getId()+"GROUP BY ingredient";

        Class.forName("org.postgresql.Driver");

        //3. Open connection
        Connection con = DriverManager.getConnection(Credentials.URL, Credentials.USERNAME, Credentials.PASSWORD);

        //4. Query

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        RowSetFactory aFactory= RowSetProvider.newFactory();
        CachedRowSet crs = aFactory.createCachedRowSet();
        crs.populate(rs);
        outcome=crs;

        rs.close();
        stmt.close();
        con.close();
        while (crs.next()){
            recipe.addIngredient(crs.getString("ingredient"));

            // System.out.println(crs.getString("title")+"|"+crs.getString("label")+"|"+crs.getString("genre")+"|"+(crs.getString("rrp")+"|"+crs.getString(5)));
        }
    }
    public static void evaluateRecipe(Recipe recipe){
        int points=0;
        boolean present=false;
        neededIngredients= Recipe.getIngredients();
        for(String nIngr: neededIngredients){
            for (String pIngr:presentIngredients){
                if(nIngr.equals(pIngr)){
                  //if ingredient is a fridge staple it doesnt matter
                    present=true;
                    break;
                }
            }
            if (!present){points++;}
            present=false;
        }
        Recipe.setWeight(points);
    }

    public void moreDetails (Recipe recipe) throws ClassNotFoundException, SQLException {
        String sql ="SELECT link_recipe_ingredient.amount,unit.unit_name FROM link_recipe_ingredient FULL JOIN unit ON link_recipe_ingredient.unit_id=unit.unit_id WHERE recipe_id="+ Recipe.getId()+"GROUP BY amount,Unit";
        String sql1 ="SELECT description FROM Instruction WHERE Recipe_id="+ Recipe.getId()+"GROUP BY step";

        Class.forName("org.postgresql.Driver");

        //3. Open connection
        Connection con = DriverManager.getConnection(Credentials.URL, Credentials.USERNAME, Credentials.PASSWORD);

        //4. Query

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        RowSetFactory aFactory= RowSetProvider.newFactory();
        CachedRowSet crs = aFactory.createCachedRowSet();
        crs.populate(rs);
        outcome=crs;

        rs.close();
        stmt.close();
        con.close();
        int i=0;
        while (crs.next()){
            recipe.addDetailIngredient(crs.getString("amount"),crs.getString("unit"),recipe.getIngredients().get(i));
        }
        PreparedStatement stmt1 = con.prepareStatement(sql1);
        ResultSet rs1 = stmt1.executeQuery();

        RowSetFactory aFactory1= RowSetProvider.newFactory();
        CachedRowSet crs1 = aFactory1.createCachedRowSet();
        crs1.populate(rs1);
        outcome=crs1;

        rs.close();
        stmt.close();
        con.close();
        while (crs1.next()){
            recipe.addStep(crs1.getString("step"));


        }
    }

    static class RecipeComparator implements java.util.Comparator<Recipe> {
        @Override
        public int compare(Recipe a, Recipe b) {
            return a.getWeight() - b.getWeight();
        }
    }



}
