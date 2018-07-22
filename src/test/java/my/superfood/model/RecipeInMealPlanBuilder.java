package my.superfood.model;

import my.superfood.model.enums.MealType;

import javax.annotation.Generated;
import java.time.DayOfWeek;

import static my.superfood.model.RecipeBuilder.aNewRecipe;
import static my.superfood.model.RecipeBuilder.aRecipe;

@Generated("PojoBuilder")
public class RecipeInMealPlanBuilder extends AbstractRecipeInMealPlanBuilder {

    private RecipeInMealPlanBuilder() {
    }

    public static RecipeInMealPlanBuilder aRecipeInMealPlan() {
        return new RecipeInMealPlanBuilder()
                .withId(1L)
                .withMealType(MealType.BREAKFAST)
                .withDayOfWeek(DayOfWeek.MONDAY)
                .withRecipe(aRecipe().build());
    }

    public static RecipeInMealPlanBuilder aNewRecipeInMealPlan() {
        return aRecipeInMealPlan().withId(null).withRecipe(aNewRecipe().build());
    }
}
