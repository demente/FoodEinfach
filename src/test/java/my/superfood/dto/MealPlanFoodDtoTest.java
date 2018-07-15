package my.superfood.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static my.superfood.assertions.DtoAssertions.assertEqualMealPlanFoodDto;
import static my.superfood.assertions.DtoAssertions.assertEqualMealPlanRecipeDto;
import static my.superfood.dto.MealPlanFoodDtoBuilder.aMealPlanFoodDto;
import static my.superfood.dto.MealPlanRecipeDtoBuilder.aMealPlanRecipeDto;
import static org.assertj.core.api.Assertions.assertThat;

public class MealPlanFoodDtoTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/mealPlanFood.json"), MealPlanFoodDto.class));

        assertThat(MAPPER.writeValueAsString(aMealPlanFoodDto().build())).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        MealPlanFoodDto expected = aMealPlanFoodDto().build();

        MealPlanFoodDto actual = MAPPER.readValue(fixture("fixtures/mealPlanFood.json"), MealPlanFoodDto.class);

        assertEqualMealPlanFoodDto(actual, expected);
    }

}