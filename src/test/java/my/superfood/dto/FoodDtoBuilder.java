package my.superfood.dto;

import my.superfood.model.enums.FoodType;

import javax.annotation.Generated;

@Generated("PojoBuilder")
public class FoodDtoBuilder extends AbstractFoodDtoBuilder {

    private FoodDtoBuilder() {
    }

    public static FoodDtoBuilder aFoodDto() {
        return new FoodDtoBuilder().withType(FoodType.FRUIT.name()).withName("Apple");
    }
}
