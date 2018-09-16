package my.superfood.mapper;

import my.superfood.dto.WeightDto;
import my.superfood.model.enums.Unit;
import org.junit.Test;

import static my.superfood.dto.WeightDtoBuilder.aWeightDto;
import static my.superfood.model.enums.Unit.GRAM;
import static org.assertj.core.api.Assertions.assertThat;

public class WeightMapperTest {

    private WeightMapper weightMapper = new WeightMapper();

    @Test
    public void mapsToWeightDtoInMicrograms() {
        WeightDto actual = weightMapper.toWeightDto(120L);

        assertThat(actual.getWeight()).isEqualTo(120L);
        assertThat(actual.getUnit()).isEqualTo(Unit.MICROGRAM.name());
    }

    @Test
    public void mapsToWeightDtoInGivenUnits() {
        WeightDto actual = weightMapper.toWeightDto(12000024L, GRAM);

        assertThat(actual.getWeight()).isEqualTo(12.000024);
        assertThat(actual.getUnit()).isEqualTo(Unit.GRAM.name());
    }

    @Test
    public void returnsNullIfNoWeightGiven() {
        WeightDto actual = weightMapper.toWeightDto(null);

        assertThat(actual).isNull();
    }

    @Test
    public void mapsToWeightInMicrograms() {
        Long actual = weightMapper.toWeightInMicrograms(aWeightDto().withWeight(Double.valueOf(10)).withUnit(GRAM.name()).build());

        assertThat(actual).isEqualTo(10000000L);
    }

}