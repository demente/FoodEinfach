package my.superfood.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import my.superfood.assertions.DtoAssertions;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static my.superfood.assertions.DtoAssertions.assertEqualWeightDto;
import static my.superfood.dto.WeightDtoBuilder.aWeightDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class WeightDtoTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/weight.json"), WeightDto.class));

        assertThat(MAPPER.writeValueAsString(aWeightDto().build())).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        WeightDto expected = aWeightDto().build();

        WeightDto actual = MAPPER.readValue(fixture("fixtures/weight.json"), WeightDto.class);

        assertEqualWeightDto(actual,expected);
    }
}