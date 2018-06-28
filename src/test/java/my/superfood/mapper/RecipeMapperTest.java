package my.superfood.mapper;

import my.superfood.dto.RecipeDto;
import my.superfood.dto.RecipeDtoBuilder;
import my.superfood.model.Recipe;
import my.superfood.model.enums.MealType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.dto.RecipeDtoBuilder.aRecipeDto;
import static my.superfood.model.RecipeBuilder.aRecipe;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class RecipeMapperTest {

    @InjectMocks
    private RecipeMapper recipeMapper = new RecipeMapperImpl();

    @Test
    public void mapsDtoToEntity() {
        RecipeDto expected = aRecipeDto().build();

        Recipe actual = recipeMapper.toRecipe(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getInstructions()).isEqualTo(expected.getInstructions());
        assertThat(actual.getPreparationTime()).isEqualTo(expected.getPreparationTime());
        assertThat(actual.getServings()).isEqualTo(expected.getServings());
    }

    @Test
    public void mapsEntityToDto() {
        Recipe expected = aRecipe().build();

        RecipeDto actual = recipeMapper.toRecipeDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getInstructions()).isEqualTo(expected.getInstructions());
        assertThat(actual.getPreparationTime()).isEqualTo(expected.getPreparationTime());
        assertThat(actual.getServings()).isEqualTo(expected.getServings());
    }

}