package my.superfood.dto;

import my.superfood.model.enums.FoodType;

import javax.annotation.Generated;

@Generated("PojoBuilder")
public class FoodInfoDtoBuilder extends AbstractFoodInfoDtoBuilder {
    private FoodInfoDtoBuilder() {
    }

    public static FoodInfoDtoBuilder aFoodInfoDto() {
        return new FoodInfoDtoBuilder().withId(1L).withName("Apple").withType(FoodType.FRUIT.name());
    }
}
