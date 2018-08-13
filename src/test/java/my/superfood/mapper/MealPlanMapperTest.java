package my.superfood.mapper;

import my.superfood.dto.MealPlanDto;
import my.superfood.model.MealPlan;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.dto.MealPlanDtoBuilder.aMealPlanDto;
import static my.superfood.model.MealPlanBuilder.aMealPlan;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class MealPlanMapperTest {

    private MealPlanMapper mealPlanMapper;
    @Mock
    private MealPlanRecipeMapper mealPlanRecipeMapper;
    @Mock
    private MealPlanFoodMapper mealPlanFoodMapper;

    @Before
    public void setup() {
        mealPlanMapper = new MealPlanMapper(mealPlanRecipeMapper, mealPlanFoodMapper);
    }

    @Test
    public void mapsDtoToEntity() {
        MealPlanDto expected = aMealPlanDto().build();

        MealPlan actual = mealPlanMapper.toMealPlan(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getStartDate()).isEqualTo(expected.getStartDate());
        assertThat(actual.getEndDate()).isEqualTo(expected.getEndDate());
    }

    @Test
    public void mapsToFoodList() {
        MealPlanDto expected = aMealPlanDto().build();

        mealPlanMapper.toMealPlan(expected);

        then(mealPlanFoodMapper).should().toMealPlanFoodList(expected.getFood());
    }

    @Test
    public void mapsToRecipeList() {
        MealPlanDto expected = aMealPlanDto().build();

        mealPlanMapper.toMealPlan(expected);

        then(mealPlanRecipeMapper).should().toRecipeInMealPlanList(expected.getRecipes());
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