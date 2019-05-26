package my.superfood.dto;

import my.superfood.model.enums.FoodType;

import javax.annotation.Generated;

import static my.superfood.dto.NutritionalInformationDtoBuilder.aNutritionalInformationDto;
import static my.superfood.dto.WeightDtoBuilder.aWeightDto;

@Generated("PojoBuilder")
public class FoodDtoBuilder extends AbstractFoodDtoBuilder {

    private FoodDtoBuilder() {
    }

    public static FoodDtoBuilder aFoodDto() {
        return new FoodDtoBuilder()
                .withId(1L)
                .withType(FoodType.FRUIT.name())
                .withName("Apple")
                .withWeight(aWeightDto().build())
                .withMinimumPackageName("piece")
                .withMinimumWeight(aWeightDto().build())
                .withPricePerMinimumWeight(2.55)
                .withNutritionalInformation(aNutritionalInformationDto().build());
    }
}
