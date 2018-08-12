package my.superfood.mapper;

import my.superfood.dto.IngredientDto;
import my.superfood.model.Food;
import my.superfood.model.Ingredient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.dto.IngredientDtoBuilder.anIngredientDto;
import static my.superfood.model.IngredientBuilder.anIngredient;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class IngredientMapperTest {

    private IngredientMapper ingredientMapper;
@Mock
private FoodMapper foodMapper;

    @Before
    public void setup(){
        ingredientMapper = new IngredientMapper(foodMapper);
    }

    @Test
    public void mapsDtoToEntity() {
        IngredientDto expected = anIngredientDto().build();

        Ingredient actual = ingredientMapper.toIngredient(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getUnit().name()).isEqualTo(expected.getAmount().getUnit());
        assertThat(actual.getAmount()).isEqualTo(expected.getAmount().getWeight());
    }

    @Test
    public void mapsEntityToDto() {
        Ingredient expected = anIngredient().build();

        IngredientDto actual = ingredientMapper.toIngredientDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getAmount().getUnit()).isEqualTo(expected.getUnit().name());
        assertThat(actual.getAmount().getWeight()).isEqualTo(expected.getAmount());
    }
}