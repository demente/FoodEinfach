package my.superfood.mapper;

import my.superfood.dto.NutritionalInformationDto;
import my.superfood.dto.NutritionalInformationDtoBuilder;
import my.superfood.model.NutritionalInformation;
import my.superfood.model.NutritionalInformationBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.dto.NutritionalInformationDtoBuilder.aNutritionalInformationDto;
import static my.superfood.model.NutritionalInformationBuilder.aNutritionalInformation;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class NutritionalInformationMapperTest {

    @InjectMocks
    private NutritionalInformationMapper nutritionalInformationMapper = new NutritionalInformationMapperImpl();

    @Test
    public void mapsDtoToEntity() {
        NutritionalInformationDto expected = aNutritionalInformationDto().build();

        NutritionalInformation actual = nutritionalInformationMapper.toNutritionalInformation(expected);

        assertThat(actual.getCalories()).isEqualTo(expected.getCalories());
    }

    @Test
    public void mapsEntityToDto() {
        NutritionalInformation expected = aNutritionalInformation().build();

        NutritionalInformationDto actual = nutritionalInformationMapper.toNutritionalInformationDto(expected);

        assertThat(actual.getCalories()).isEqualTo(expected.getCalories());
    }
}