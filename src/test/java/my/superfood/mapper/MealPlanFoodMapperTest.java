package my.superfood.mapper;

import my.superfood.dto.FoodDto;
import my.superfood.dto.MealPlanFoodDto;
import my.superfood.dto.WeightDto;
import my.superfood.model.Food;
import my.superfood.model.MealPlanFood;
import my.superfood.resolver.FoodResolver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static my.superfood.dto.FoodDtoBuilder.aFoodDto;
import static my.superfood.dto.MealPlanFoodDtoBuilder.aMealPlanFoodDto;
import static my.superfood.dto.WeightDtoBuilder.aWeightDto;
import static my.superfood.model.FoodBuilder.aFood;
import static my.superfood.model.MealPlanFoodBuilder.aMealPlanFood;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class MealPlanFoodMapperTest {

    private MealPlanFoodMapper mealPlanFoodMapper;
    @Mock
    private FoodMapper foodMapper;
    @Mock
    private FoodResolver foodResolver;
    @Mock
    private WeightMapper weightMapper;

    @Before
    public void setup() {
        mealPlanFoodMapper = new MealPlanFoodMapper(foodResolver, foodMapper, weightMapper);
    }

    @Test
    public void returnsNullWhenMappingNullToMealPlanFoodDto() {
        MealPlanFoodDto actual = mealPlanFoodMapper.toMealPlanFoodDto(null);

        assertThat(actual).isNull();
    }

    @Test
    public void mapsMealPlanFoodToMealPlanFoodDto() {
        MealPlanFood expected = aMealPlanFood().build();
        FoodDto expectedFood = aFoodDto().build();
        WeightDto expectedWeight = aWeightDto().build();

        given(foodMapper.toFoodDto(any())).willReturn(expectedFood);
        given(weightMapper.toWeightDto(any())).willReturn(expectedWeight);

        MealPlanFoodDto actual = mealPlanFoodMapper.toMealPlanFoodDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getDayOfWeek()).isEqualTo(expected.getDayOfWeek());
        assertThat(actual.getMealType()).isEqualTo(expected.getMealType());
        assertThat(actual.getFood()).isEqualTo(expectedFood);
        assertThat(actual.getAmount()).isEqualTo(expectedWeight);
    }

    @Test
    public void mapsToWeightDtoWhenMappingMealPlanFoodToMealPlanFoodDto() {
        mealPlanFoodMapper.toMealPlanFoodDto(aMealPlanFood().withAmount(12L).build());

        then(weightMapper).should().toWeightDto(12L);
    }

    @Test
    public void mapsToFoodDtoWhenMappingMealPlanFoodToMealPlanFoodDto() {
        Food expected = aFood().build();

        mealPlanFoodMapper.toMealPlanFoodDto(aMealPlanFood().withFood(expected).build());

        then(foodMapper).should().toFoodDto(expected);
    }

    @Test
    public void returnsNullWhenMappingNullToMealPlanFood() {
        MealPlanFood actual = mealPlanFoodMapper.toMealPlanFood(null);

        assertThat(actual).isNull();
    }

    @Test
    public void mapsMealPlanFoodDtoToMealPlanFood() {
        MealPlanFoodDto expected = aMealPlanFoodDto().build();
        Food food = aFood().build();
        long weight = 12L;

        given(foodResolver.toFood(anyLong())).willReturn(food);
        given(weightMapper.toWeight(any())).willReturn(weight);

        MealPlanFood actual = mealPlanFoodMapper.toMealPlanFood(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getDayOfWeek()).isEqualTo(expected.getDayOfWeek());
        assertThat(actual.getMealType()).isEqualTo(expected.getMealType());
        assertThat(actual.getFood()).isEqualTo(food);
        assertThat(actual.getAmount()).isEqualTo(weight);
    }

    @Test
    public void mapsToWeightWhenMappingMealPlanFoodDtoToMealPlanFood() {
        WeightDto expected = aWeightDto().build();
        mealPlanFoodMapper.toMealPlanFood(aMealPlanFoodDto().withAmount(expected).build());

        then(weightMapper).should().toWeight(expected);
    }

    @Test
    public void resolvesFoodWhenMappingMealPlanFoodDtoToMealPlanFood() {
        FoodDto expected = aFoodDto().withId(3L).build();

        mealPlanFoodMapper.toMealPlanFood(aMealPlanFoodDto().withFood(expected).build());

        then(foodResolver).should().toFood(expected.getId());
    }

    @Test
    public void mapsMealPlanFoodListToMealPlanFoodDtoList() {
        MealPlanFood expected = aMealPlanFood().build();
        FoodDto expectedFood = aFoodDto().build();
        WeightDto expectedWeight = aWeightDto().build();

        given(foodMapper.toFoodDto(any())).willReturn(expectedFood);
        given(weightMapper.toWeightDto(any())).willReturn(expectedWeight);

        List<MealPlanFoodDto> actual = mealPlanFoodMapper.toMealPlanFoodDtoList(asList(expected));

        assertThat(actual).extracting(MealPlanFoodDto::getId).containsExactly(expected.getId());
        assertThat(actual).extracting(MealPlanFoodDto::getDayOfWeek).containsExactly(expected.getDayOfWeek());
        assertThat(actual).extracting(MealPlanFoodDto::getMealType).containsExactly(expected.getMealType());
        assertThat(actual).extracting(MealPlanFoodDto::getFood).containsExactly(expectedFood);
        assertThat(actual).extracting(MealPlanFoodDto::getAmount).containsExactly(expectedWeight);
    }

    @Test
    public void mapsMealPlanFoodDtoListToMealPlanFoodList() {
        MealPlanFoodDto expected = aMealPlanFoodDto().build();
        Food food = aFood().build();
        long weight = 12L;

        given(foodResolver.toFood(anyLong())).willReturn(food);
        given(weightMapper.toWeight(any())).willReturn(weight);

        List<MealPlanFood> actual = mealPlanFoodMapper.toMealPlanFoodList(asList(expected));

        assertThat(actual).extracting(MealPlanFood::getId).containsExactly(expected.getId());
        assertThat(actual).extracting(MealPlanFood::getDayOfWeek).containsExactly(expected.getDayOfWeek());
        assertThat(actual).extracting(MealPlanFood::getMealType).containsExactly(expected.getMealType());
        assertThat(actual).extracting(MealPlanFood::getFood).containsExactly(food);
        assertThat(actual).extracting(MealPlanFood::getAmount).containsExactly(weight);
    }

}