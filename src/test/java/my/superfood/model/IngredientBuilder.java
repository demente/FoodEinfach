package my.superfood.model;

import javax.annotation.Generated;

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
                .withAmount(100L);
    }
}
