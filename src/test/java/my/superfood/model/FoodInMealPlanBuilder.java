package my.superfood.model;

import my.superfood.model.enums.MealType;
import my.superfood.model.enums.Unit;

import javax.annotation.Generated;
import java.time.DayOfWeek;

import static my.superfood.model.FoodBuilder.aFood;

@Generated("PojoBuilder")
public class FoodInMealPlanBuilder extends AbstractFoodInMealPlanBuilder {

    private FoodInMealPlanBuilder() {
    }

    public static FoodInMealPlanBuilder aFoodInMealPlan() {
        return new FoodInMealPlanBuilder()
                .withId(1L)
                .withDayOfWeek(DayOfWeek.FRIDAY)
                .withAmount(100L)
                .withUnit(Unit.MICROGRAM)
                .withMealType(MealType.BREAKFAST)
                .withFood(aFood().build());
    }
}
