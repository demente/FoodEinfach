package my.superfood.mapper;

import my.superfood.dto.MealPlanRecipeDto;
import my.superfood.model.RecipeInMealPlan;
import org.junit.Test;

import static my.superfood.dto.MealPlanRecipeDtoBuilder.aMealPlanRecipeDto;
import static my.superfood.model.RecipeInMealPlanBuilder.aRecipeInMealPlan;
import static org.assertj.core.api.Assertions.assertThat;

public class MealPlanRecipeMapperTest {
    private MealPlanRecipeMapper mealPlanRecipeMapper = new MealPlanRecipeMapperImpl();

    @Test
    public void mapsDtoToEntity() {
        MealPlanRecipeDto expected = aMealPlanRecipeDto().build();

        RecipeInMealPlan actual = mealPlanRecipeMapper.toRecipeInMealPlan(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getDayOfWeek()).isEqualTo(expected.getDayOfWeek());
        assertThat(actual.getMealType()).isEqualTo(expected.getMealType());
        assertThat(actual.getRecipe().getId()).isEqualTo(expected.getRecipe().getId());
    }

    @Test
    public void mapsEntityToDto() {
        RecipeInMealPlan expected = aRecipeInMealPlan().build();

        MealPlanRecipeDto actual = mealPlanRecipeMapper.toMealPlanRecipeDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getDayOfWeek()).isEqualTo(expected.getDayOfWeek());
        assertThat(actual.getMealType()).isEqualTo(expected.getMealType());
        assertThat(actual.getRecipe().getId()).isEqualTo(expected.getRecipe().getId());
    }

}