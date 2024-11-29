import java.util.List;

public class Recipe {
    public static List<String> ingredients;

    public static List<String[]> ingredientWithAmount;

    public static int weight;
    public static int id;
    public static String description;
    public static String prep_time;
    public static String cook_time;
    public static String image;

    public static List<String> steps;

    public void addIngredient(String ingredient){
        ingredients.add(ingredient);
    }

    public static List<String> getIngredients() {
        return ingredients;
    }

    public static int getWeight() {
        return weight;
    }

    public static void setWeight(int weight) {
        Recipe.weight = weight;
    }
    public static int getId(){
        return  id;
    }
    public static String setDescription(){
        return description;
    }

    public static String getPrep_time(){
        return prep_time;
    }

    public static String getCook_time() {
        return cook_time;
    }

    public static void setId(int id) {
        Recipe.id = id;
    }

    public static String getDescription() {
        return description;
    }

    public static String getImage() {
        return image;
    }

    public static void setCook_time(String cook_time) {
        Recipe.cook_time = cook_time;
    }

    public static void setDescription(String description) {
        Recipe.description = description;
    }

    public static void setImage(String image) {
        Recipe.image = image;
    }

    public static void setPrep_time(String prep_time) {
        Recipe.prep_time = prep_time;
    }

    public static void addStep(String step){
        steps.add(step);
    }
    public static void addDetailIngredient(String amount,String unit,String ingredient){

        ingredientWithAmount.add(new String[]{amount,unit,ingredient});
    }




}
