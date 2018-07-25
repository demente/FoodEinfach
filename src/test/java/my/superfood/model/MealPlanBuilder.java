package my.superfood.model;

import org.joda.time.LocalDate;

import javax.annotation.Generated;


import static java.util.Arrays.asList;
import static my.superfood.model.FoodInMealPlanBuilder.aFoodInMealPlan;
import static my.superfood.model.FoodInMealPlanBuilder.aNewFoodInMealPlan;
import static my.superfood.model.RecipeInMealPlanBuilder.aNewRecipeInMealPlan;
import static my.superfood.model.RecipeInMealPlanBuilder.aRecipeInMealPlan;

@Generated("PojoBuilder")
public class MealPlanBuilder extends AbstractMealPlanBuilder {

    private MealPlanBuilder() {
    }

    public static MealPlanBuilder aMealPlan() {
        return new MealPlanBuilder()
                .withId(1L)
                .withStartDate(new LocalDate(2017, 1, 1))
                .withEndDate(new LocalDate(2017, 1, 8))
                .withFood(asList(aFoodInMealPlan().build()))
                .withRecipes(asList(aRecipeInMealPlan().build()));
    }

    public static MealPlanBuilder aNewMealPlan() {
        return aMealPlan().withId(null)
                .withFood(asList(aNewFoodInMealPlan().build()))
                .withRecipes(asList(aNewRecipeInMealPlan().build()));

    }
}
