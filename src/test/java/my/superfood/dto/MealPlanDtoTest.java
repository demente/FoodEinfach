package my.superfood.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static my.superfood.assertions.DtoAssertions.assertEqualFoodDto;
import static my.superfood.assertions.DtoAssertions.assertEqualMealPlanDto;
import static my.superfood.dto.FoodDtoBuilder.aFoodDto;
import static my.superfood.dto.MealPlanDtoBuilder.aMealPlanDto;
import static org.assertj.core.api.Assertions.assertThat;

public class MealPlanDtoTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/mealplan.json"), MealPlanDto.class));

        assertThat(MAPPER.writeValueAsString(aMealPlanDto().build())).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        MealPlanDto expected = aMealPlanDto().build();

        MealPlanDto actual = MAPPER.readValue(fixture("fixtures/mealplan.json"), MealPlanDto.class);

        assertEqualMealPlanDto(actual, expected);
    }

}