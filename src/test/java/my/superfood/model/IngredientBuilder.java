package my.superfood.model;

import my.superfood.model.enums.Unit;

import javax.annotation.Generated;

import static my.superfood.dto.FoodDtoBuilder.aFoodDto;
import static my.superfood.model.FoodBuilder.aFood;
import static my.superfood.model.RecipeBuilder.aRecipe;

@Generated("PojoBuilder")
public class IngredientBuilder extends AbstractIngredientBuilder {

    private IngredientBuilder() {
    }

    public static IngredientBuilder anIngredient() {
        return new IngredientBuilder()
                .withId(1L)
                .withFood(aFood().build())
                .withRecipe(aRecipe().build())
                .withUnit(Unit.MICROGRAM)
                .withAmount(100L);
    }
}
