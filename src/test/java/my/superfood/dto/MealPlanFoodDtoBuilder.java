package my.superfood.dto;

import my.superfood.model.enums.MealType;

import javax.annotation.Generated;
import java.time.DayOfWeek;

import static my.superfood.dto.FoodDtoBuilder.aFoodDto;
import static my.superfood.dto.WeightDtoBuilder.aWeightDto;

@Generated("PojoBuilder")
public class MealPlanFoodDtoBuilder extends AbstractMealPlanFoodDtoBuilder {
    private MealPlanFoodDtoBuilder() {
    }

    public static MealPlanFoodDtoBuilder aMealPlanFoodDto() {
        return new MealPlanFoodDtoBuilder()
                .withId(1L)
                .withDayOfWeek(DayOfWeek.FRIDAY)
                .withMealType(MealType.BREAKFAST)
                .withAmount(aWeightDto().build())
                .withFood(aFoodDto().build());
    }
}
