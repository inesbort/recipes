package com.example.ssh_app;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
//import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.net.Socket;

import java.util.*;

import java.sql.*;
import java.util.stream.Collectors;
import javax.sql.rowset.*;

public class ThePrototype {
    public static List<Recipe> ingredientList= null;
    static List<String> presentIngredients= new ArrayList<>();
    static List<String> neededIngredients= new ArrayList<>();


    private CachedRowSet serviceOutcome = null;
    private static ResultSet outcome   = null;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

    }
    //creator method called by the SSHApp class, uses execute to fill the ingredient list
    public ThePrototype(List<String> fridge) throws SQLException, ClassNotFoundException {
        presentIngredients=fridge;
        ingredientList=execute();
    }

    //getter and setter methods

    public static void setPresentIngredients(List<String> fridge ){
        presentIngredients=fridge;
    }

    public static List<String> getPresentIngredients() {
        return presentIngredients;
    }

    public static List<Recipe> getIngredientList() {
        return ingredientList;
    }

    public List<Recipe> execute() throws SQLException, ClassNotFoundException {

        List<Recipe> recipeListList= new ArrayList<>();


        for (String i:presentIngredients) {
            //for each ingredient in the list selects recipe information for each recipe which contains that ingredient
            String sql= "SELECT public.recipe.recipe_id,public.recipe.recipe_name, public.recipe.recipe_description,public.recipe.prep_time, public.recipe.cook_time, public.recipe.img  FROM public.recipe FULL JOIN public.link_recipe_ingredient ON public.recipe.recipe_id=link_recipe_ingredient.recipe_id FULL JOIN public.ingredient ON public.link_recipe_ingredient.ingredient_id=public.ingredient.ingredient_id  WHERE public.ingredient.name= '"+ i+"'";
            //access to the database
            //user and password are hardcoded
            Class.forName("org.postgresql.Driver");

            String dbURL = "jdbc:postgresql://localhost:5432/postgres" ;
            String user = "postgres" ;
            String password = "Databasealpoder" ;
            Connection con = DriverManager.getConnection ( dbURL , user , password ) ;
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            RowSetFactory aFactory= RowSetProvider.newFactory();
            CachedRowSet crs = aFactory.createCachedRowSet();
            crs.populate(rs);
            outcome=crs;

            rs.close();
            stmt.close();
            con.close();
            //extracts data from the records pulled


            while (crs.next()){
                //for each record, creates a recipe object, and adds the necessary attributes
                Recipe newRecipe=new Recipe(crs.getInt(1),crs.getString(2),crs.getString(3),crs.getString(4),crs.getString(5));
                //adds the ingredients
                addIngredients(newRecipe);
                recipeListList.add(newRecipe);
                showInstructions(newRecipe);

                evaluateRecipe(newRecipe);

            }
        }

        //adds recipe to the new list if and only if it is not present in the original database, preventing a recipe from being show twice

        List<Recipe> recipeListNoDuplicates= new ArrayList<>();
        boolean add = true;
        for (Recipe r: recipeListList){
            add=true;
            for (Recipe rr: recipeListNoDuplicates){
                if (rr.getName().equals(r.getName())){add=false;}
            }
            if (add){recipeListNoDuplicates.add(r);}
        }
        //sorts the list based on weight attribute

        recipeListNoDuplicates.sort(new RecipeComparator());
        return recipeListNoDuplicates;

    }
    public static void addIngredients(Recipe recipe) throws ClassNotFoundException, SQLException {
        //now for each recipe get all ingredients

        String sql = "SELECT public.ingredient.name,public.ingredient.quantity,public.ingredient.unit FROM public.ingredient FULL JOIN public.link_recipe_ingredient ON public.ingredient.ingredient_id= public.link_recipe_ingredient.ingredient_id WHERE public.link_recipe_ingredient.recipe_id= "+recipe.getId();

        Class.forName("org.postgresql.Driver");

        String dbURL = "jdbc:postgresql://localhost:5432/postgres" ;
        String user = "postgres" ;
        String password = "Databasealpoder" ;
        Connection con = DriverManager.getConnection ( dbURL , user , password ) ;

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

            recipe.addIngredient(crs.getString(1));
            recipe.addDetailIngredient(crs.getString(2), crs.getString(3),crs.getString(1) );

        }
    }
    public static void evaluateRecipe(Recipe recipe){
        //counts all the ingredients present in the recipe which are not present in the fridge
        int points=0;
        boolean present=false;
        neededIngredients= recipe.getIngredients();
        for(String nIngr: neededIngredients){
            for (String pIngr:presentIngredients){
                if(nIngr.equals(pIngr)){
                    present=true;
                    break;
                }
            }
            if (!present){points++;}
            present=false;
        }
        recipe.setWeight(points);
    }

    public void showInstructions (Recipe recipe) throws ClassNotFoundException, SQLException {
      // select instruction needed to make the database
        String sql= "SELECT public.instructions.instruction FROM public.instructions WHERE public.instructions.recipe_id="+ recipe.getId();
        Class.forName("org.postgresql.Driver");

        String dbURL = "jdbc:postgresql://localhost:5432/postgres" ;
        String user = "postgres" ;
        String password = "Databasealpoder" ;
        Connection con = DriverManager.getConnection ( dbURL , user , password ) ;

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
            recipe.addStep(crs.getString(1));
        }
    }

    static class RecipeComparator implements java.util.Comparator<Recipe> {
        @Override
        public int compare(Recipe a, Recipe b) {
            return a.getWeight() - b.getWeight();
        }
    }
}
