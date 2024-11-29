import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
//import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.net.Socket;

import java.util.StringTokenizer;

import java.sql.*;
import javax.sql.rowset.*;


public class DatabaseConnection {
    private CachedRowSet serviceOutcome = null;
    private static ResultSet outcome   = null;


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName( "org.postgresql.Driver");


        String dbURL = "jdbc:postgresql://localhost:5432/postgres" ;
        String user = "postgres" ;
        String password = "Databasealpoder" ;
        Connection con = DriverManager.getConnection ( dbURL , user , password ) ;
        String sql = "SELECT recipe.recipe_id, description,prep_time, cook_time, img  FROM recipe FULL JOIN link_recipe_ingredient ON recipe.recipe_id=link_recipe_ingredient.recipe_id FULL JOIN ingredient ON link_recipe_ingredient.ingredient_id=ingredient.ingredient_id  WHERE ingredient.ingr_name= 'beef'";
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
            System.out.println(crs.getString("recipe_id")+"|"+crs.getString("description")+"|"+crs.getString("prep_time")+"|"+crs.getString("cook_time")+"|"+crs.getString("img"));
        }


    }



}
