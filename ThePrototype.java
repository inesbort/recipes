import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
//import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.net.Socket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.List;

import java.sql.*;
import javax.sql.rowset.*;

public class ThePrototype {
    static List<Recipe> appropriateList= new ArrayList<>();
    public static List<Recipe> inappropriateList= null;
    static List<String> presentIngredients= new ArrayList<>();
    static List<String> neededIngredients= new ArrayList<>();

    public static Recipe[] listOfRecipes= new Recipe[50];
  //  listOfRecipes=;

    public int missingIngredients=0;

    private CachedRowSet serviceOutcome = null;
    private static ResultSet outcome   = null;
    static int count=0;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        presentIngredients.add("Chicken");
        presentIngredients.add("Egg");
        presentIngredients.add("Tomatoes");
        //inappropriateList=execute();




//        for (int i=0;i<count;i++){
//            System.out.println(listOfRecipes[i].getName());
//        }

    }
    public ThePrototype() throws SQLException, ClassNotFoundException {
       // presentIngredients=fridge;
        inappropriateList=execute();
    }

    public static void setPresentIngredients(List<String> fridge ){
        presentIngredients=fridge;
    }

    public static List<String> getPresentIngredients() {
        return presentIngredients;
    }

    public static List<Recipe> getInappropriateList() {
        return inappropriateList;
    }

    public List<Recipe> execute() throws SQLException, ClassNotFoundException {
        presentIngredients.add("Chicken");
        presentIngredients.add("Egg");
        presentIngredients.add("Tomatoes");
        List<Recipe> recipeListList= new ArrayList<>();


        for (String i:presentIngredients) {
            String sql= "SELECT public.recipe.recipe_id,public.recipe.recipe_name, public.recipe.recipe_description,public.recipe.prep_time, public.recipe.cook_time, public.recipe.img  FROM public.recipe FULL JOIN public.link_recipe_ingredient ON public.recipe.recipe_id=link_recipe_ingredient.recipe_id FULL JOIN public.ingredient ON public.link_recipe_ingredient.ingredient_id=public.ingredient.ingredient_id  WHERE public.ingredient.name= '"+ i+"'";
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
                Recipe newRecipe=new Recipe(crs.getInt(1),crs.getString(2),crs.getString(3),crs.getString(4),crs.getString(5));
//                Recipe.setId(crs.getInt(1));
//                Recipe.setName(crs.getString(2));
//                Recipe.setCook_time(crs.getString(3));
//                Recipe.setPrep_time(crs.getString(4));
//                Recipe.setImage(crs.getString(5));
//                Recipe.setDescription(crs.getString(6));
                addIngredients(newRecipe);
                recipeListList.add(newRecipe);
           //     System.out.println(newRecipe.getName());


             //   System.out.println(newRecipe.getName());
                 evaluateRecipe(newRecipe);
//                Recipe temp=newRecipe;
//
//                listOfRecipes[count]=temp;
//
//              //  System.out.println(listOfRecipes[count].getId());
//                for (int x=0;x<count;x++){System.out.println(count+" "+ listOfRecipes[x].getName());}
//                count++;
//                if (newRecipe.getWeight()==0){
//                    appropriateList.add(newRecipe);
//                }else{inappropriateList.add(newRecipe);}
              //  System.out.println(newRecipe.getName());
            }
        }

       // Collections.sort(inappropriateList, new RecipeComparator());
        recipeListList.sort(new RecipeComparator());
        return recipeListList;

    }
    public static void addIngredients(Recipe recipe) throws ClassNotFoundException, SQLException {
        //now for each recipe get all ingredients
     //   System.out.println(recipe.getName());
        String sql = "SELECT public.ingredient.name FROM public.ingredient FULL JOIN public.link_recipe_ingredient ON public.ingredient.ingredient_id= public.link_recipe_ingredient.ingredient_id WHERE public.link_recipe_ingredient.recipe_id= "+recipe.getId();

        Class.forName("org.postgresql.Driver");

        String dbURL = "jdbc:postgresql://localhost:5432/postgres" ;
        String user = "postgres" ;
        String password = "Databasealpoder" ;
        Connection con = DriverManager.getConnection ( dbURL , user , password ) ;

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
          //  System.out.println(crs.getString(1));
            recipe.addIngredient(crs.getString(1));

            // System.out.println(crs.getString("title")+"|"+crs.getString("label")+"|"+crs.getString("genre")+"|"+(crs.getString("rrp")+"|"+crs.getString(5)));
        }
    }
    public static void evaluateRecipe(Recipe recipe){
        int points=0;
        boolean present=false;
        neededIngredients= recipe.getIngredients();
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
        recipe.setWeight(points);
    }

    public void moreDetails (Recipe recipe) throws ClassNotFoundException, SQLException {
        String sql ="SELECT link_recipe_ingredient.amount,unit.unit_name FROM link_recipe_ingredient FULL JOIN unit ON link_recipe_ingredient.unit_id=unit.unit_id WHERE recipe_id="+ recipe.getId()+"GROUP BY amount,Unit";
        String sql1= "SELECT public.instructions.instruction FROM public.instructions WHERE public.instructions.recipe_id="+ recipe.getId();
        Class.forName("org.postgresql.Driver");

        String dbURL = "jdbc:postgresql://localhost:5432/postgres" ;
        String user = "postgres" ;
        String password = "Databasealpoder" ;
        Connection con = DriverManager.getConnection ( dbURL , user , password ) ;

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
