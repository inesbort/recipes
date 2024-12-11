import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

   // Recipe myRecipe=new Recipe();

    //List<String> neededIngredients= List.of(new String[]{"Cheese","Egg","Vodka","Double cream"});

    

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
        //In order to ensure the relevant recipes are shown, some ingredients need to be passed in different wordings
        ThePrototype myPrototype1= new ThePrototype(List.of(new String[]{"Cheese","Egg","Double cream","Eggs"}));

        List<String> actualOutput= new ArrayList<>();
        List<String> expectedOutput= List.of(new String[]{"Scrambled eggs","Egg-fried rice","Cheese omelette","Creamy garlic pasta","Chicken pasta bake"});
        for (Recipe r:myPrototype1.getIngredientList()){
            actualOutput.add(r.getName());
        }
        assertEquals(expectedOutput,actualOutput);
    }

    void getRecipes2() throws SQLException, ClassNotFoundException {
        ThePrototype myPrototype1= new ThePrototype(List.of(new String[]{"Chicken","Tomatoes"}));

        List<String> actualOutput= new ArrayList<>();
        List<String> expectedOutput= List.of(new String[]{"Chicken quesadilla","Greek salad","One-pan roast chicken & potatoes","Chicken pasta bake","Chicken wraps"});
        for (Recipe r:myPrototype1.getIngredientList()){
            actualOutput.add(r.getName());
        }
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void properlyFilledAttributes() throws SQLException, ClassNotFoundException {
        ThePrototype myPrototype4= new ThePrototype(List.of(new String[]{"Onions"}));

        List<String[]> ingredientWithAmount= new ArrayList<>();
        ingredientWithAmount.add(new String[]{"Fresh mince","500","g"});
        ingredientWithAmount.add(new String[]{"Crusty","",""});

        assertEquals("Spaghetti Bolognese",myPrototype4.getIngredientList().get(1).getName());
        assertEquals("My very best Spaghetti Bolognese, gorgeously meaty with a chilli kick!",myPrototype4.getIngredientList().get(1).getDescription());
        //assertEquals(List.of("Spaghetti Bolognese"),myPrototype4.getIngredientList().get(1).getIngredientsWithAmount());
        assertEquals(ingredientWithAmount.get(1),myPrototype4.getIngredientList().get(1).getIngredientWithAmount().get(1));
        assertEquals(ingredientWithAmount.get(2),myPrototype4.getIngredientList().get(1).getIngredientWithAmount().get(21));
        assertEquals("Just as the sauce is nearly ready, Add the parmesan and season to taste. Meanwhile add salt to a pan of boiling water and cook the spaghetti according the the packet instructions. Once the spaghetti is ready, drain it in a colander and add it to the pan with the sauce. Give it all a good stir, coating the pasta in the lovely tomato sauce. Serve with a little grated parmesan and use the extra basil leaves to make a great little garnish. Beautiful!",myPrototype4.getIngredientList().get(1).getSteps().get(5));
        assertEquals("Get yourself a large heavy-bottomed saucepan, and place it on a medium heat. Add a good lug of olive oil and gently fry your bacon until golden and crisp, then reduce the heat slightly and add your onions, carrots, celery and garlic. Next remove the leaves from the Rosemary sprigs and add them to the pot, discarding the sprigs. Move everything around and fry for around 8-10 minutes until the veg has softened.",myPrototype4.getIngredientList().get(1).getSteps().get(1));
        assertEquals(20,myPrototype4.getIngredientList().get(1).getWeight());
        assertEquals("25 minutes",myPrototype4.getIngredientList().get(1).getPrep_time());
        assertEquals("1 hour 15 minutes",myPrototype4.getIngredientList().get(1).getCook_time());

    }

}