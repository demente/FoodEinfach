package my.superfood.model;

import my.superfood.model.enums.MealType;

import javax.annotation.Generated;
import java.time.DayOfWeek;

import static my.superfood.model.RecipeBuilder.aNewRecipe;
import static my.superfood.model.RecipeBuilder.aRecipe;

@Generated("PojoBuilder")
public class MealPlanRecipeBuilder extends AbstractMealPlanRecipeBuilder {

    private MealPlanRecipeBuilder() {
    }

    public static MealPlanRecipeBuilder aMealPlanRecipe() {
        return new MealPlanRecipeBuilder().withId(1L)
                .withRecipe(aRecipe().build())
                .withDayOfWeek(DayOfWeek.MONDAY)
                .withMealType(MealType.BREAKFAST);
    }

    public static MealPlanRecipeBuilder aNewMealPlanRecipe() {
        return aMealPlanRecipe().withId(null)
                .withRecipe(aNewRecipe().build());
    }
}
