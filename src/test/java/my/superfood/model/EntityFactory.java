package my.superfood.model;

import net.karneim.pojobuilder.GeneratePojoBuilder;

public class EntityFactory {

    private EntityFactory() {
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static Food newFood() {
        return new Food();
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static FoodInMealPlan newFoodInMealPlan() {
        return new FoodInMealPlan();
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static Ingredient newIngredient() {
        return new Ingredient();
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static MealPlan newMealPlan() {
        return new MealPlan();
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static MineralAmount newMineralAmount() {
        return new MineralAmount();
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static NutritionalInformation newNutritionalInformation() {
        return new NutritionalInformation();
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static Recipe newRecipe() {
        return new Recipe();
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static RecipeInMealPlan newRecipeInMealPlan() {
        return new RecipeInMealPlan();
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static VitaminAmount newVitaminAmount() {
        return new VitaminAmount();
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static Vitamin newVitamin() {
        return new Vitamin();
    }


}
