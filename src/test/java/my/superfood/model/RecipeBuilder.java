package my.superfood.model;

import javax.annotation.Generated;

@Generated("PojoBuilder")
public class RecipeBuilder extends AbstractRecipeBuilder {

    private RecipeBuilder() {
    }

    public static RecipeBuilder aRecipe() {
        return new RecipeBuilder();
    }
}
