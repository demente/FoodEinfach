package my.superfood.model;

import javax.annotation.Generated;

import static java.util.Arrays.asList;
import static my.superfood.model.FoodInMealPlanBuilder.aFoodInMealPlan;
import static my.superfood.model.RecipeInMealPlanBuilder.aRecipeInMealPlan;

@Generated("PojoBuilder")
public class MealPlanBuilder extends AbstractMealPlanBuilder {

    private MealPlanBuilder() {
    }

    public static MealPlanBuilder aMealPlan() {
        return new MealPlanBuilder()
                .withId(1L)
                .withFood(asList(aFoodInMealPlan().build()))
                .withRecipe(asList(aRecipeInMealPlan().build()));
    }

    public static MealPlanBuilder aNewMealPlan() {
        return aMealPlan().withId(null);
    }
}
