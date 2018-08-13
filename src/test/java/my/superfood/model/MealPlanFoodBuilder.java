package my.superfood.model;

import my.superfood.model.enums.MealType;

import javax.annotation.Generated;
import java.time.DayOfWeek;

import static my.superfood.model.FoodBuilder.aFood;
import static my.superfood.model.FoodBuilder.aNewFood;

@Generated("PojoBuilder")
public class MealPlanFoodBuilder extends AbstractMealPlanFoodBuilder {
    private MealPlanFoodBuilder() {
    }

    public static MealPlanFoodBuilder aMealPlanFood() {
        return new MealPlanFoodBuilder().withId(1L)
                .withFood(aFood().build())
                .withAmount(100L)
                .withDayOfWeek(DayOfWeek.MONDAY)
                .withMealType(MealType.BREAKFAST);
    }

    public static MealPlanFoodBuilder aNewMealPlanFood() {
        return aMealPlanFood().withId(null)
                .withFood(aNewFood().build());
    }
}
