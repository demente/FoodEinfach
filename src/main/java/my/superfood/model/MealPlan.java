package my.superfood.model;

import java.util.List;

public class MealPlan {

    private Long id;

    private List<FoodInMealPlan> food;

    private  List<RecipeInMealPlan> recipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<FoodInMealPlan> getFood() {
        return food;
    }

    public void setFood(List<FoodInMealPlan> food) {
        this.food = food;
    }

    public List<RecipeInMealPlan> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<RecipeInMealPlan> recipe) {
        this.recipe = recipe;
    }
}
