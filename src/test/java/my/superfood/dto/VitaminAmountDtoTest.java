package my.superfood.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static my.superfood.assertions.DtoAssertions.assertEqualMineralAmountDto;
import static my.superfood.assertions.DtoAssertions.assertEqualVitaminAmountDto;
import static my.superfood.dto.MineralAmountDtoBuilder.aMineralAmountDto;
import static my.superfood.dto.VitaminAmountDtoBuilder.aVitaminAmountDto;
import static org.assertj.core.api.Assertions.assertThat;

public class VitaminAmountDtoTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/vitaminAmount.json"), VitaminAmountDto.class));

        assertThat(MAPPER.writeValueAsString(aVitaminAmountDto().build())).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        VitaminAmountDto expected = aVitaminAmountDto().build();

        VitaminAmountDto actual = MAPPER.readValue(fixture("fixtures/vitaminAmount.json"), VitaminAmountDto.class);

        assertEqualVitaminAmountDto(actual, expected);
    }
}