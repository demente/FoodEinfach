package my.superfood.model;

import javax.annotation.Generated;

@Generated("PojoBuilder")
public class MealPlanBuilder extends AbstractMealPlanBuilder {

    private MealPlanBuilder() {
    }

    public static MealPlanBuilder aMealPlan() {
        return new MealPlanBuilder();
    }

    public static MealPlanBuilder aNewMealPlan() {
        return aMealPlan().withId(null);
    }
}
