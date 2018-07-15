package my.superfood.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static my.superfood.assertions.DtoAssertions.assertEqualIngredientDto;
import static my.superfood.assertions.DtoAssertions.assertEqualMealPlanRecipeDto;
import static my.superfood.dto.IngredientDtoBuilder.anIngredientDto;
import static my.superfood.dto.MealPlanRecipeDtoBuilder.aMealPlanRecipeDto;
import static org.assertj.core.api.Assertions.assertThat;

public class MealPlanRecipeDtoTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/mealPlanRecipe.json"), MealPlanRecipeDto.class));

        assertThat(MAPPER.writeValueAsString(aMealPlanRecipeDto().build())).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        MealPlanRecipeDto expected = aMealPlanRecipeDto().build();

        MealPlanRecipeDto actual = MAPPER.readValue(fixture("fixtures/mealPlanRecipe.json"), MealPlanRecipeDto.class);

        assertEqualMealPlanRecipeDto(actual, expected);
    }

}