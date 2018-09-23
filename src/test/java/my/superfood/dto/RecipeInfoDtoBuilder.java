package my.superfood.dto;

import my.superfood.model.enums.MealType;

import javax.annotation.Generated;

import static java.util.Arrays.asList;


@Generated("PojoBuilder")
public class RecipeInfoDtoBuilder extends AbstractRecipeInfoDtoBuilder {
    private RecipeInfoDtoBuilder() {
    }

    public static RecipeInfoDtoBuilder aRecipeInfoDto() {
        return new RecipeInfoDtoBuilder()
                .withId(1L)
                .withName("Apple pie")
                .withType(asList(MealType.BREAKFAST.name()));
    }
}
