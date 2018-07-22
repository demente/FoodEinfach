package my.superfood.dto;

import javax.annotation.Generated;

import java.util.Date;

import static java.util.Arrays.asList;
import static my.superfood.dto.MealPlanFoodDtoBuilder.aMealPlanFoodDto;
import static my.superfood.dto.MealPlanRecipeDtoBuilder.aMealPlanRecipeDto;


@Generated("PojoBuilder")
public class MealPlanDtoBuilder extends AbstractMealPlanDtoBuilder {

    private MealPlanDtoBuilder() {
    }

    public static MealPlanDtoBuilder aMealPlanDto() {
        return new MealPlanDtoBuilder()
                .withId(1L)
                .withStartDate(new Date(2017, 1, 1))
                .withEndDate(new Date(2017, 1, 8))
                .withFood(asList(aMealPlanFoodDto().build()))
                .withRecipes(asList(aMealPlanRecipeDto().build()));
    }
}
