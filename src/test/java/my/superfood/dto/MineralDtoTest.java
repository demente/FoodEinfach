package my.superfood.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import my.superfood.assertions.DtoAssertions;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static my.superfood.assertions.DtoAssertions.assertEqualWeightDto;
import static my.superfood.dto.FoodInfoDtoBuilder.aFoodInfoDto;
import static my.superfood.dto.MineralDtoBuilder.aMineralDto;
import static org.assertj.core.api.Assertions.assertThat;

public class MineralDtoTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/mineral.json"), MineralDto.class));

        assertThat(MAPPER.writeValueAsString(aMineralDto().build())).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        MineralDto expected = aMineralDto().build();

        MineralDto actual = MAPPER.readValue(fixture("fixtures/mineral.json"), MineralDto.class);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertEqualWeightDto(actual.getAmount(), expected.getAmount());
        assertEqualWeightDto(actual.getDailyNorm(), expected.getDailyNorm());
    }


}