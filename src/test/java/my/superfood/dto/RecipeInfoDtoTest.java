package my.superfood.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static my.superfood.assertions.DtoAssertions.assertEqualRecipeInfoDto;
import static my.superfood.dto.RecipeInfoDtoBuilder.aRecipeInfoDto;
import static org.assertj.core.api.Assertions.assertThat;

public class RecipeInfoDtoTest {


    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/recipeInfo.json"), RecipeInfoDto.class));

        assertThat(MAPPER.writeValueAsString(aRecipeInfoDto().build())).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        RecipeInfoDto expected = aRecipeInfoDto().build();

        RecipeInfoDto actual = MAPPER.readValue(fixture("fixtures/recipeInfo.json"), RecipeInfoDto.class);

        assertEqualRecipeInfoDto(actual, expected);
    }
}