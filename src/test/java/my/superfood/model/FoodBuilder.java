package my.superfood.model;

import javax.annotation.Generated;

@Generated("PojoBuilder")
public class FoodBuilder extends AbstractFoodBuilder {

    private FoodBuilder() {
    }

    public static FoodBuilder aFood() {
        return new FoodBuilder();
    }
}
