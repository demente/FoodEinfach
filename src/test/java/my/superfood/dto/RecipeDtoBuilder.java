package my.superfood.dto;

import javax.annotation.Generated;

import static java.util.Arrays.asList;
import static my.superfood.dto.IngredientDtoBuilder.anIngredientDto;

@Generated("PojoBuilder")
public class RecipeDtoBuilder extends AbstractRecipeDtoBuilder {

    private RecipeDtoBuilder() {
    }

    public static RecipeDtoBuilder aRecipeDto() {
        return new RecipeDtoBuilder()
                .withId(1L)
                .withName("Baked apples")
                .withServings(2L)
                .withType(asList("BREAKFAST"))
                .withInstructions("Cut the apples and put them in the oven.")
                .withPreparationTime(10L)
                .withIngredients(asList(anIngredientDto().build()));
    }
}
