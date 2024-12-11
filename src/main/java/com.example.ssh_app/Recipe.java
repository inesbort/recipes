package com.example.ssh_app;

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
    private List<String> steps = new ArrayList<>();

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

    public void addDetailIngredient(String amount,String unit,String ingredient){
        ingredientWithAmount.add(new String[]{amount,unit,ingredient});
    }

    public List<String> getSteps() {
        return steps;
    }
    public void addStep(String step){
        steps.add(step);
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
    public void setId(int id_) {
        id = id_;
    }

    public  String getPrep_time(){
        return prep_time;
    }
    public  void setPrep_time(String prep_time_) {
        prep_time = prep_time_;
    }

    public String getCook_time() {
        return cook_time;
    }
    public void setCook_time(String cook_time_) {cook_time = cook_time_;}

    public String getDescription() {
        return description;
    }
    public void setDescription(String description_) {
        description = description_;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image_) {image = image_;}


}
