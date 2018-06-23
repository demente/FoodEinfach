package my.superfood.model;

import my.superfood.model.enums.FoodType;

import javax.annotation.Generated;

import static my.superfood.model.NutritionalInformationBuilder.aNutritionalInformation;

@Generated("PojoBuilder")
public class FoodBuilder extends AbstractFoodBuilder {

    private FoodBuilder() {
    }

    public static FoodBuilder aFood() {
        return new FoodBuilder()
                .withName("Apple")
                .withType(FoodType.FRUIT)
                .withNutritionPerHundredGrams(aNutritionalInformation().build());
    }
}
