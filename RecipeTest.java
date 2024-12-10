import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

   // Recipe myRecipe=new Recipe();

    //List<String> neededIngredients= List.of(new String[]{"Cheese","Egg","Vodka","Double cream"});
    ThePrototype myPrototype2= new ThePrototype(List.of(new String[]{"Cheese"}));



    RecipeTest() throws SQLException, ClassNotFoundException {
    }

    @Test
    void noDuplicates() throws SQLException, ClassNotFoundException {
        ThePrototype myPrototype4= new ThePrototype(List.of(new String[]{"Cheese","Vodka","Pasta"}));
       assertEquals(myPrototype4.getIngredientList().size(),3);
    }

    @Test
    void inOrder() throws SQLException, ClassNotFoundException {
        ThePrototype myPrototype4= new ThePrototype(List.of(new String[]{"Cheese","Egg","Double cream"}));

        assertEquals(myPrototype4.getIngredientList().get(0).getName(),"Cheese omelette");
    }

    @Test
    void emptyList() throws SQLException, ClassNotFoundException {
        ThePrototype myPrototype3= new ThePrototype(List.of(new String[]{""}));
        assertEquals(List.of(new Recipe[]{}),myPrototype3.getIngredientList());
    }

    @Test
    void getRecipes() throws SQLException, ClassNotFoundException {
        ThePrototype myPrototype1= new ThePrototype(List.of(new String[]{"Cheese","Egg","Double cream"}));

        List<String> actualOutput= new ArrayList<>();
        List<String> expectedOutput= List.of(new String[]{"Cheese omelette","Creamy garlic pasta","Chicken pasta bake"});
        for (Recipe r:myPrototype1.getIngredientList()){
            actualOutput.add(r.getName());
        }
        assertEquals(expectedOutput,actualOutput);

    }

//    @Test
//    void getWeight() {
//    }
//
//    @Test
//    void setWeight() {
//    }
//
//    @Test
//    void getId() {
//    }
//
//    @Test
//    void setDescription() {
//    }
//
//    @Test
//    void getPrep_time() {
//    }
}