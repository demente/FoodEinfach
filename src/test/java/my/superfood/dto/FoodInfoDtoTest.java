package my.superfood.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static my.superfood.assertions.DtoAssertions.assertEqualFoodInfoDto;
import static my.superfood.dto.FoodInfoDtoBuilder.aFoodInfoDto;
import static org.assertj.core.api.Assertions.assertThat;

public class FoodInfoDtoTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/foodInfo.json"), FoodInfoDto.class));

        assertThat(MAPPER.writeValueAsString(aFoodInfoDto().build())).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        FoodInfoDto expected = aFoodInfoDto().build();

        FoodInfoDto actual = MAPPER.readValue(fixture("fixtures/foodInfo.json"), FoodInfoDto.class);

        assertEqualFoodInfoDto(actual, expected);
    }

}