package my.superfood.mapper;

import my.superfood.assertions.DtoAssertions;
import my.superfood.dto.MealPlanDto;
import my.superfood.dto.MealPlanFoodDto;
import my.superfood.model.FoodInMealPlan;
import my.superfood.model.MealPlan;
import org.junit.Test;

import java.util.List;

import static my.superfood.dto.MealPlanDtoBuilder.aMealPlanDto;
import static my.superfood.model.MealPlanBuilder.aMealPlan;
import static org.assertj.core.api.Assertions.assertThat;

public class MealPlanMapperTest {

    private MealPlanMapper mealPlanMapper = new MealPlanMapperImpl();

    @Test
    public void mapsDtoToEntity() {
        MealPlanDto expected = aMealPlanDto().build();

        MealPlan actual = mealPlanMapper.toMealPlan(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getStartDate()).isEqualTo(expected.getStartDate());
        assertThat(actual.getEndDate()).isEqualTo(expected.getEndDate());

        assertThat(actual.getFood().get(0).getId()).isEqualTo(expected.getFood().get(0).getId());
        assertThat(actual.getRecipes().get(0).getId()).isEqualTo(expected.getRecipes().get(0).getId());
    }

    @Test
    public void mapsEntityToDto() {
        MealPlan expected = aMealPlan().build();

        MealPlanDto actual = mealPlanMapper.toMealPlanDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getStartDate()).isEqualTo(expected.getStartDate());
        assertThat(actual.getEndDate()).isEqualTo(expected.getEndDate());
    }
}