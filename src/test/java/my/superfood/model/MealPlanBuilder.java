package my.superfood.model;

import org.joda.time.LocalDate;

import javax.annotation.Generated;

import static java.util.Arrays.asList;
import static my.superfood.model.MealPlanFoodBuilder.aMealPlanFood;
import static my.superfood.model.MealPlanFoodBuilder.aNewMealPlanFood;
import static my.superfood.model.MealPlanRecipeBuilder.aMealPlanRecipe;
import static my.superfood.model.MealPlanRecipeBuilder.aNewMealPlanRecipe;

@Generated("PojoBuilder")
public class MealPlanBuilder extends AbstractMealPlanBuilder {

    private MealPlanBuilder() {
    }

    public static MealPlanBuilder aMealPlan() {
        return new MealPlanBuilder()
                .withId(1L)
                .withStartDate(new LocalDate(2017, 1, 1))
                .withEndDate(new LocalDate(2017, 1, 8))
                .withFood(asList(aMealPlanFood().build()))
                .withRecipes(asList(aMealPlanRecipe().build()));
    }

    public static MealPlanBuilder aNewMealPlan() {
        return aMealPlan().withId(null)
                .withFood(asList(aNewMealPlanFood().build()))
                .withRecipes(asList(aNewMealPlanRecipe().build()));

    }
}
