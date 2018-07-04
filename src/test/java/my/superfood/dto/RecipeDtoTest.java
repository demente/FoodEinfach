package my.superfood.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static my.superfood.assertions.DtoAssertions.assertEqualRecipeDto;
import static my.superfood.dto.FoodInfoDtoBuilder.aFoodInfoDto;
import static my.superfood.dto.RecipeDtoBuilder.aRecipeDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class RecipeDtoTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/recipe.json"), RecipeDto.class));

        assertThat(MAPPER.writeValueAsString(aRecipeDto().build())).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        RecipeDto expected = aRecipeDto().build();

        RecipeDto actual = MAPPER.readValue(fixture("fixtures/recipe.json"), RecipeDto.class);

        assertEqualRecipeDto(actual, expected);
    }

}