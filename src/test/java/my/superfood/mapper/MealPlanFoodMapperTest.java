package my.superfood.mapper;

import my.superfood.dto.MealPlanFoodDto;
import my.superfood.model.MealPlanFood;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.dto.MealPlanFoodDtoBuilder.aMealPlanFoodDto;
import static my.superfood.model.FoodInMealPlanBuilder.aFoodInMealPlan;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class MealPlanFoodMapperTest {

    private MealPlanFoodMapper mealPlanFoodMapper;
    @Mock
    private FoodMapper foodMapper;

    @Before
    public void setup() {
        mealPlanFoodMapper = new MealPlanFoodMapper(foodMapper);
    }

    @Test
    public void mapsDtoToEntity() {
        MealPlanFoodDto expected = aMealPlanFoodDto().build();

        MealPlanFood actual = mealPlanFoodMapper.toFoodInMealPlan(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getDayOfWeek()).isEqualTo(expected.getDayOfWeek());
        assertThat(actual.getMealType()).isEqualTo(expected.getMealType());
        assertThat(actual.getAmount()).isEqualTo(expected.getAmount().getWeight());
        assertThat(actual.getUnit().name()).isEqualTo(expected.getAmount().getUnit());
    }

    @Test
    public void mapsFoodDtoToFood() {
        MealPlanFoodDto expected = aMealPlanFoodDto().build();

        mealPlanFoodMapper.toFoodInMealPlan(expected);

        then(foodMapper).should().toFood(expected.getFood());
    }

    @Test
    public void mapsEntityToDto() {
        MealPlanFood expected = aFoodInMealPlan().build();

        MealPlanFoodDto actual = mealPlanFoodMapper.toMealPlanFoodDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getDayOfWeek()).isEqualTo(expected.getDayOfWeek());
        assertThat(actual.getMealType()).isEqualTo(expected.getMealType());
        assertThat(actual.getAmount().getWeight()).isEqualTo(expected.getAmount());
        assertThat(actual.getAmount().getUnit()).isEqualTo(expected.getUnit().name());
    }

    @Test
    public void mapsFoodToFoodDto() {
        MealPlanFood expected = aFoodInMealPlan().build();

        mealPlanFoodMapper.toMealPlanFoodDto(expected);

        then(foodMapper).should().toFoodDto(expected.getFood());
    }

}