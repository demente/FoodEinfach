package my.superfood.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static my.superfood.dto.FoodInfoDtoBuilder.aFoodInfoDto;
import static my.superfood.dto.IngredientDtoBuilder.anIngredientDto;
import static org.assertj.core.api.Assertions.assertThat;

public class IngredientDtoTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/ingredient.json"), IngredientDto.class));

        assertThat(MAPPER.writeValueAsString(anIngredientDto().build())).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        IngredientDto expected = anIngredientDto().build();

        IngredientDto actual = MAPPER.readValue(fixture("fixtures/ingredient.json"), IngredientDto.class);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getFoodId()).isEqualTo(expected.getFoodId());
        assertThat(actual.getRecipeId()).isEqualTo(expected.getRecipeId());
        assertThat(actual.getUnit()).isEqualTo(expected.getUnit());
        assertThat(actual.getAmount()).isEqualTo(expected.getAmount());
    }

}