import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private List<String> ingredients= new ArrayList<>();
    private List<String[]> ingredientWithAmount= new ArrayList<>();
    private int weight;
    private int id;
    private String description;
    private String prep_time;
    private String cook_time;
    private String image;

    private String name;
    static List<String> steps = new ArrayList<>();

    public Recipe(int id_,String name_,String description_,String prep_time_,String cook_time_){
        id=id_;
        name=name_;
        description=description_;
        prep_time=prep_time_;
        cook_time=cook_time_;

    }

    public void setName(String name_) {
        name = name_;
    }

    public String getName() {
        return name;
    }

    public void addIngredient(String ingredient){
        ingredients.add(ingredient);
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String[]> getIngredientWithAmount() {
        return ingredientWithAmount;
    }

    public List<String> getSteps() {
        return steps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight_) {
        weight = weight_;
    }
    public int getId(){
        return  id;
    }
    public String setDescription(){
        return description;
    }

    public  String getPrep_time(){
        return prep_time;
    }

    public String getCook_time() {
        return cook_time;
    }

    public void setId(int id_) {
        id = id_;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public void setCook_time(String cook_time_) {cook_time = cook_time_;}

    public void setDescription(String description_) {
    description = description_;
    }

    public void setImage(String image_) {image = image_;}

    public  void setPrep_time(String prep_time_) {
        prep_time = prep_time_;
    }

    public void addStep(String step){
        steps.add(step);
    }
    public void addDetailIngredient(String amount,String unit,String ingredient){
        ingredientWithAmount.add(new String[]{amount,unit,ingredient});
    }




}
