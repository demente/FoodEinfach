package my.superfood.mapper;

import my.superfood.dto.MealPlanFoodDto;
import my.superfood.model.FoodInMealPlan;
import org.junit.Test;

import static my.superfood.dto.MealPlanFoodDtoBuilder.aMealPlanFoodDto;
import static my.superfood.model.FoodInMealPlanBuilder.aFoodInMealPlan;
import static org.assertj.core.api.Assertions.assertThat;

public class MealPlanFoodMapperTest {

    private MealPlanFoodMapper mealPlanFoodMapper = new MealPlanFoodMapperImpl();

    @Test
    public void mapsDtoToEntity() {
        MealPlanFoodDto expected = aMealPlanFoodDto().build();

        FoodInMealPlan actual = mealPlanFoodMapper.toFoodInMealPlan(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getDayOfWeek()).isEqualTo(expected.getDayOfWeek());
        assertThat(actual.getMealType()).isEqualTo(expected.getMealType());
        assertThat(actual.getAmount()).isEqualTo(expected.getAmount().getWeight());
        assertThat(actual.getUnit().name()).isEqualTo(expected.getAmount().getUnit());
        assertThat(actual.getFood().getId()).isEqualTo(expected.getFood().getId());
    }

    @Test
    public void mapsEntityToDto() {
        FoodInMealPlan expected = aFoodInMealPlan().build();

        MealPlanFoodDto actual = mealPlanFoodMapper.toMealPlanFoodDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getDayOfWeek()).isEqualTo(expected.getDayOfWeek());
        assertThat(actual.getMealType()).isEqualTo(expected.getMealType());
        assertThat(actual.getFood().getId()).isEqualTo(expected.getFood().getId());
        assertThat(actual.getAmount().getWeight()).isEqualTo(expected.getAmount());
        assertThat(actual.getAmount().getUnit()).isEqualTo(expected.getUnit().name());
    }
}