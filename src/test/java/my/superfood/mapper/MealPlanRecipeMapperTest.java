package my.superfood.mapper;

import my.superfood.dto.MealPlanRecipeDto;
import my.superfood.model.MealPlanRecipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.dto.MealPlanRecipeDtoBuilder.aMealPlanRecipeDto;
import static my.superfood.model.MealPlanRecipeBuilder.aMealPlanRecipe;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class MealPlanRecipeMapperTest {
    private MealPlanRecipeMapper mealPlanRecipeMapper;
    @Mock
    private RecipeMapper recipeMapper;

    @Before
    public void setup() {
        mealPlanRecipeMapper = new MealPlanRecipeMapper(recipeMapper);
    }

    @Test
    public void mapsDtoToEntity() {
        MealPlanRecipeDto expected = aMealPlanRecipeDto().build();

        MealPlanRecipe actual = mealPlanRecipeMapper.toRecipeInMealPlan(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getDayOfWeek()).isEqualTo(expected.getDayOfWeek());
        assertThat(actual.getMealType()).isEqualTo(expected.getMealType());
    }

    @Test
    public void mapsRecipeDtoToRecipe() {
        MealPlanRecipeDto expected = aMealPlanRecipeDto().build();

        mealPlanRecipeMapper.toRecipeInMealPlan(expected);

        then(recipeMapper).should().toRecipe(expected.getRecipe());
    }

    @Test
    public void mapsEntityToDto() {
        MealPlanRecipe expected = aMealPlanRecipe().build();

        MealPlanRecipeDto actual = mealPlanRecipeMapper.toMealPlanRecipeDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getDayOfWeek()).isEqualTo(expected.getDayOfWeek());
        assertThat(actual.getMealType()).isEqualTo(expected.getMealType());
    }

    @Test
    public void mapsRecipeToRecipeDto() {
        MealPlanRecipe expected = aMealPlanRecipe().build();

        mealPlanRecipeMapper.toMealPlanRecipeDto(expected);

        then(recipeMapper).should().toRecipeDto(expected.getRecipe());
    }

}