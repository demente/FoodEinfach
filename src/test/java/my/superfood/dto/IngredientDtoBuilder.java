package my.superfood.dto;

import my.superfood.model.enums.Unit;

import javax.annotation.Generated;

@Generated("PojoBuilder")
public class IngredientDtoBuilder extends AbstractIngredientDtoBuilder {

    private IngredientDtoBuilder() {
    }

    public static IngredientDtoBuilder anIngredientDto() {
        return new IngredientDtoBuilder()
                .withId(1L)
                .withFoodId(2L)
                .withRecipeId(3L)
                .withAmount(100L)
                .withUnit(Unit.GRAM.name());
    }
}
