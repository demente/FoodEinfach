package my.superfood.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import my.superfood.assertions.DtoAssertions;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static my.superfood.assertions.DtoAssertions.assertEqualVitaminDto;
import static my.superfood.assertions.DtoAssertions.assertEqualWeightDto;
import static my.superfood.dto.VitaminDtoBuilder.aVitaminDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class VitaminDtoTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/vitamin.json"), VitaminDto.class));

        assertThat(MAPPER.writeValueAsString(aVitaminDto().build())).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        VitaminDto expected = aVitaminDto().build();

        VitaminDto actual = MAPPER.readValue(fixture("fixtures/vitamin.json"), VitaminDto.class);

        assertEqualVitaminDto(actual, expected);
    }
}