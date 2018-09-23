package my.superfood.model;

import my.superfood.model.enums.MealType;

import javax.annotation.Generated;

import static java.util.Arrays.asList;

@Generated("PojoBuilder")
public class RecipeBuilder extends AbstractRecipeBuilder {

    private RecipeBuilder() {
    }

    public static RecipeBuilder aRecipe() {
        return new RecipeBuilder().withId(1L)
                .withName("Apple pie")
                .withType(asList(MealType.BREAKFAST))
                .withIngredients(asList());
    }

    public static RecipeBuilder aNewRecipe() {
        return aRecipe().withId(null);
    }
}
