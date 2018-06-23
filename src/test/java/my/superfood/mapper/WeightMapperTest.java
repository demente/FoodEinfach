package my.superfood.mapper;


import my.superfood.dto.WeightDto;
import my.superfood.model.Weight;
import org.junit.Test;

import static my.superfood.dto.WeightDtoBuilder.aWeightDto;
import static my.superfood.model.WeightBuilder.aWeight;
import static org.assertj.core.api.Assertions.assertThat;

public class WeightMapperTest {

    private WeightMapper weightMapper = new WeightMapperImpl();

    @Test
    public void mapsEntityToDto() {
        Weight expected = aWeight().build();

        WeightDto actual = weightMapper.toWeightDto(expected);

        assertThat(actual.getUnit()).isEqualTo(expected.getUnit());
        assertThat(actual.getWeight()).isEqualTo(expected.getWeight());
    }

    @Test
    public void mapsDtoToEntity() {
        WeightDto expected = aWeightDto().build();

        Weight actual = weightMapper.toWeight(expected);

        assertThat(actual.getUnit()).isEqualTo(expected.getUnit());
        assertThat(actual.getWeight()).isEqualTo(expected.getWeight());
    }

}