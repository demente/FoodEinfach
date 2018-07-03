package my.superfood.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static my.superfood.assertions.DtoAssertions.assertEqualNutritionalInformationDto;
import static my.superfood.assertions.DtoAssertions.assertEqualWeightDto;
import static my.superfood.dto.FoodDtoBuilder.aFoodDto;
import static org.assertj.core.api.Assertions.assertThat;

public class FoodDtoTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/food.json"), FoodDto.class));

        assertThat(MAPPER.writeValueAsString(aFoodDto().build())).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        FoodDto expected = aFoodDto().build();

        FoodDto actual = MAPPER.readValue(fixture("fixtures/food.json"), FoodDto.class);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getType()).isEqualTo(expected.getType());
        assertEqualWeightDto(actual.getWeight(), expected.getWeight());
        assertEqualNutritionalInformationDto(actual.getNutritionalInformation(), expected.getNutritionalInformation());
    }

}