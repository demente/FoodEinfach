package my.superfood.mapper;

import my.superfood.dto.MealPlanDto;
import my.superfood.model.MealPlan;
import org.junit.Test;

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