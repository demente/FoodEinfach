package my.superfood.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import my.superfood.assertions.DtoAssertions;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static my.superfood.dto.NutritionalInformationDtoBuilder.aNutritionalInformationDto;
import static org.assertj.core.api.Assertions.assertThat;

public class NutritionalInformationDtoTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/nutritionalInfo.json"), NutritionalInformationDto.class));

        assertThat(MAPPER.writeValueAsString(aNutritionalInformationDto().build())).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        NutritionalInformationDto expected = aNutritionalInformationDto().build();

        NutritionalInformationDto actual = MAPPER.readValue(fixture("fixtures/nutritionalInfo.json"), NutritionalInformationDto.class);

        DtoAssertions.assertEqualNutritionalInformationDto(actual, expected);
    }
}