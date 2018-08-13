package my.superfood.mapper;

import my.superfood.dto.FoodDto;
import my.superfood.dto.IngredientDto;
import my.superfood.dto.WeightDto;
import my.superfood.model.Food;
import my.superfood.model.Ingredient;
import my.superfood.resolver.FoodResolver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static my.superfood.dto.FoodDtoBuilder.aFoodDto;
import static my.superfood.dto.IngredientDtoBuilder.anIngredientDto;
import static my.superfood.dto.WeightDtoBuilder.aWeightDto;
import static my.superfood.model.FoodBuilder.aFood;
import static my.superfood.model.IngredientBuilder.anIngredient;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class IngredientMapperTest {

    private IngredientMapper ingredientMapper;
    @Mock
    private FoodMapper foodMapper;
    @Mock
    private WeightMapper weightMapper;
    @Mock
    private FoodResolver foodResolver;

    @Before
    public void setup() {
        ingredientMapper = new IngredientMapper(foodResolver, foodMapper, weightMapper);
    }

    @Test
    public void mapsIngredientDtoToIngredient() {
        IngredientDto expected = anIngredientDto().build();
        Long weight = 12L;
        Food food = aFood().build();

        given(weightMapper.toWeightInMicrograms(any())).willReturn(weight);
        given(foodResolver.toFood(anyLong())).willReturn(food);

        Ingredient actual = ingredientMapper.toIngredient(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getAmount()).isEqualTo(weight);
        assertThat(actual.getFood()).isEqualTo(food);
    }

    @Test
    public void returnsNullWhenMappingNullToIngredient() {
        Ingredient actual = ingredientMapper.toIngredient(null);

        assertThat(actual).isNull();
    }

    @Test
    public void mapsToWeightInMicrogramsWhenMappingIngredientDtoToIngredient() {
        WeightDto weightDto = aWeightDto().build();
        ingredientMapper.toIngredient(anIngredientDto().withAmount(weightDto).build());

        then(weightMapper).should().toWeightInMicrograms(weightDto);
    }

    @Test
    public void resolvesFoodWhenMappingIngredientDtoToIngredient() {
        FoodDto foodDto = aFoodDto().withId(3L).build();

        ingredientMapper.toIngredient(anIngredientDto().withFood(foodDto).build());

        then(foodResolver).should().toFood(foodDto.getId());
    }

    @Test
    public void returnsNullWhenMappingNullToIngredientDto() {
        IngredientDto actual = ingredientMapper.toIngredientDto(null);

        assertThat(actual).isNull();
    }

    @Test
    public void mapsIngredientToIngredientDto() {
        Ingredient expected = anIngredient().build();
        WeightDto expectedWeight = aWeightDto().build();
        FoodDto expectedFood = aFoodDto().build();

        given(weightMapper.toWeightDto(anyLong())).willReturn(expectedWeight);
        given(foodMapper.toFoodDto(any())).willReturn(expectedFood);

        IngredientDto actual = ingredientMapper.toIngredientDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getFood()).isEqualTo(expectedFood);
        assertThat(actual.getAmount()).isEqualTo(expectedWeight);
    }

    @Test
    public void mapsToWeightDtoWhenMappingIngredientToIngredientDto() {
        ingredientMapper.toIngredientDto(anIngredient().withAmount(12L).build());

        then(weightMapper).should().toWeightDto(12L);
    }

    @Test
    public void mapsToFoodDtoWhenMappingIngredientToIngredientDto() {
        Food food = aFood().build();
        ingredientMapper.toIngredientDto(anIngredient().withFood(food).build());

        then(foodMapper).should().toFoodDto(food);
    }

    @Test
    public void mapsIngredientDtoListToIngredientList() {
        IngredientDto expected = anIngredientDto().build();
        Long weight = 12L;
        Food food = aFood().build();

        given(weightMapper.toWeightInMicrograms(any())).willReturn(weight);
        given(foodResolver.toFood(anyLong())).willReturn(food);

        List<Ingredient> actual = ingredientMapper.toIngredientList(asList(expected));

        assertThat(actual).extracting(Ingredient::getId).containsExactly(expected.getId());
        assertThat(actual).extracting(Ingredient::getAmount).containsExactly(weight);
        assertThat(actual).extracting(Ingredient::getFood).containsExactly(food);
    }

    @Test
    public void mapsIngredientListToIngredientDtoList() {
        Ingredient expected = anIngredient().build();
        WeightDto expectedWeight = aWeightDto().build();
        FoodDto expectedFood = aFoodDto().build();

        given(weightMapper.toWeightDto(anyLong())).willReturn(expectedWeight);
        given(foodMapper.toFoodDto(any())).willReturn(expectedFood);

        List<IngredientDto> actual = ingredientMapper.toIngredientDtoList(asList(expected));


        assertThat(actual).extracting(IngredientDto::getId).containsExactly(expected.getId());
        assertThat(actual).extracting(IngredientDto::getAmount).containsExactly(expectedWeight);
        assertThat(actual).extracting(IngredientDto::getFood).containsExactly(expectedFood);
    }

}