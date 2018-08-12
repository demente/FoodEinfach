package my.superfood.mapper;

import my.superfood.dto.MealPlanRecipeDto;
import my.superfood.model.RecipeInMealPlan;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.dto.MealPlanRecipeDtoBuilder.aMealPlanRecipeDto;
import static my.superfood.model.RecipeInMealPlanBuilder.aRecipeInMealPlan;
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

        RecipeInMealPlan actual = mealPlanRecipeMapper.toRecipeInMealPlan(expected);

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
        RecipeInMealPlan expected = aRecipeInMealPlan().build();

        MealPlanRecipeDto actual = mealPlanRecipeMapper.toMealPlanRecipeDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getDayOfWeek()).isEqualTo(expected.getDayOfWeek());
        assertThat(actual.getMealType()).isEqualTo(expected.getMealType());
    }

    @Test
    public void mapsRecipeToRecipeDto() {
        RecipeInMealPlan expected = aRecipeInMealPlan().build();

        mealPlanRecipeMapper.toMealPlanRecipeDto(expected);

        then(recipeMapper).should().toRecipeDto(expected.getRecipe());
    }

}