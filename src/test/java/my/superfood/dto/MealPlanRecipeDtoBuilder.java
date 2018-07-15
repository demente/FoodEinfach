package my.superfood.dto;

import my.superfood.model.enums.MealType;

import javax.annotation.Generated;
import java.time.DayOfWeek;

import static my.superfood.dto.RecipeDtoBuilder.aRecipeDto;

@Generated("PojoBuilder")
public class MealPlanRecipeDtoBuilder extends AbstractMealPlanRecipeDtoBuilder {
    private MealPlanRecipeDtoBuilder() {
    }

    public static MealPlanRecipeDtoBuilder aMealPlanRecipeDto() {
        return new MealPlanRecipeDtoBuilder()
                .withId(1L)
                .withMealType(MealType.BREAKFAST)
                .withDayOfWeek(DayOfWeek.FRIDAY)
                .withRecipe(aRecipeDto().build());
    }
}
