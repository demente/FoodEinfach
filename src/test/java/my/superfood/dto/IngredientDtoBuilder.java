package my.superfood.dto;

import my.superfood.model.enums.Unit;

import javax.annotation.Generated;

import static my.superfood.dto.FoodDtoBuilder.aFoodDto;
import static my.superfood.dto.WeightDtoBuilder.aWeightDto;

@Generated("PojoBuilder")
public class IngredientDtoBuilder extends AbstractIngredientDtoBuilder {

    private IngredientDtoBuilder() {
    }

    public static IngredientDtoBuilder anIngredientDto() {
        return new IngredientDtoBuilder()
                .withId(1L)
                .withFood(aFoodDto().build())
                .withRecipeId(3L)
                .withAmount(aWeightDto().build());
    }
}
