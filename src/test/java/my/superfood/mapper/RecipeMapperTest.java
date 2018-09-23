package my.superfood.mapper;

import my.superfood.dto.RecipeDto;
import my.superfood.dto.RecipeInfoDto;
import my.superfood.model.Recipe;
import my.superfood.model.enums.MealType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.stream.Collectors.toList;
import static my.superfood.dto.RecipeDtoBuilder.aRecipeDto;
import static my.superfood.model.RecipeBuilder.aRecipe;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class RecipeMapperTest {

    private RecipeMapper recipeMapper;
    @Mock
    private IngredientMapper ingredientMapper;

    @Before
    public void setup() {
        recipeMapper = new RecipeMapper(ingredientMapper);
    }

    @Test
    public void mapsDtoToEntity() {
        RecipeDto expected = aRecipeDto().build();

        Recipe actual = recipeMapper.toRecipe(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getInstructions()).isEqualTo(expected.getInstructions());
        assertThat(actual.getPreparationTime()).isEqualTo(expected.getPreparationTime());
        assertThat(actual.getCookingTime()).isEqualTo(expected.getCookingTime());
        assertThat(actual.getServings()).isEqualTo(expected.getServings());
        assertThat(actual.getType()).extracting(MealType::name).containsExactlyElementsOf(expected.getType());
    }

    @Test
    public void mapsEntityToDto() {
        Recipe expected = aRecipe().build();

        RecipeDto actual = recipeMapper.toRecipeDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getInstructions()).isEqualTo(expected.getInstructions());
        assertThat(actual.getPreparationTime()).isEqualTo(expected.getPreparationTime());
        assertThat(actual.getServings()).isEqualTo(expected.getServings());
        assertThat(actual.getCookingTime()).isEqualTo(expected.getCookingTime());
        assertThat(actual.getType()).containsExactlyElementsOf(expected.getType().stream().map(type -> type.name()).collect(toList()));
    }

    @Test
    public void mapsEntityToInfoDto() {
        Recipe expected = aRecipe().build();

        RecipeInfoDto actual = recipeMapper.toRecipeInfoDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getType()).containsExactlyElementsOf(expected.getType().stream().map(type -> type.name()).collect(toList()));
    }

}