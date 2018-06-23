package my.superfood.mapper;

import my.superfood.dto.IngredientDto;
import my.superfood.model.Food;
import my.superfood.model.Ingredient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.dto.FoodDtoBuilder.aFoodDto;
import static my.superfood.dto.IngredientDtoBuilder.anIngredientDto;
import static my.superfood.model.FoodBuilder.aFood;
import static my.superfood.model.IngredientBuilder.anIngredient;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class IngredientMapperTest {

    @InjectMocks
    private IngredientMapper ingredientMapper = new IngredientMapperImpl();

    @Test
    public void mapsDtoToEntity() {
        IngredientDto expected = anIngredientDto().build();

        Ingredient actual = ingredientMapper.toIngredient(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getUnit().name()).isEqualTo(expected.getUnit());
        assertThat(actual.getAmount()).isEqualTo(expected.getAmount());
    }

    @Test
    public void mapsEntityToDto() {
        Ingredient expected = anIngredient().build();

        IngredientDto actual = ingredientMapper.toIngredientDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getUnit()).isEqualTo(expected.getUnit().name());
        assertThat(actual.getAmount()).isEqualTo(expected.getAmount());
    }

    @Test
    public void mapsFoodToId(){
        Ingredient expected = anIngredient().withFood(aFood().withId(2L).build()).build();

        IngredientDto actual = ingredientMapper.toIngredientDto(expected);

        assertThat(actual.getFoodId()).isEqualTo(expected.getFood().getId());
    }

    @Test
    public void mapsFoodIdToFood(){
        IngredientDto expected = anIngredientDto().withFoodId(2L).build();

        Ingredient actual = ingredientMapper.toIngredient(expected);

        assertThat(actual.getFood().getId()).isEqualTo(expected.getFoodId());
    }

}