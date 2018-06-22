package my.superfood.mapper;

import my.superfood.dto.IngredientDto;
import my.superfood.model.Ingredient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.dto.IngredientDtoBuilder.anIngredientDto;
import static my.superfood.model.IngredientBuilder.anIngredient;
import static org.assertj.core.api.Assertions.assertThat;

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
    public void mapsToRecipe() {

    }

    @Test
    public void mapsToFood() {
        
    }

    @Test
    public void mapsEntityToDto() {
        Ingredient expected = anIngredient().build();
    }

}