package my.superfood.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static my.superfood.assertions.DtoAssertions.assertEqualMineralAmountDto;
import static my.superfood.dto.MineralAmountDtoBuilder.aMineralAmountDto;
import static org.assertj.core.api.Assertions.assertThat;

public class MineralAmountDtoTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/mineral.json"), MineralAmountDto.class));

        assertThat(MAPPER.writeValueAsString(aMineralAmountDto().build())).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        MineralAmountDto expected = aMineralAmountDto().build();

        MineralAmountDto actual = MAPPER.readValue(fixture("fixtures/mineral.json"), MineralAmountDto.class);

        assertEqualMineralAmountDto(actual, expected);
    }


}