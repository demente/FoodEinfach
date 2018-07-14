package my.superfood.mapper;

import my.superfood.dto.VitaminDto;
import my.superfood.model.Vitamin;
import my.superfood.model.VitaminAmount;
import org.junit.Test;

import static my.superfood.dto.VitaminDtoBuilder.aVitaminDto;
import static my.superfood.model.VitaminAmountBuilder.aVitaminAmount;
import static my.superfood.model.VitaminBuilder.aVitamin;
import static org.assertj.core.api.Assertions.assertThat;

public class VitaminMapperTest {

    private VitaminMapper vitaminMapper = new VitaminMapperImpl();

    @Test
    public void mapsDtoToVitaminAmount() {
        VitaminDto expected = aVitaminDto().build();

        VitaminAmount actual = vitaminMapper.toVitaminAmount(expected);

        assertThat(actual.getVitamin().getName()).isEqualTo(expected.getName());
        assertThat(actual.getId()).isEqualTo(expected.getId());
    }

    @Test
    public void mapsVitaminAmountToDto() {
        VitaminAmount expected = aVitaminAmount().build();

        VitaminDto actual = vitaminMapper.toVitaminDto(expected);

        assertThat(actual.getName()).isEqualTo(expected.getVitamin().getName());
        assertThat(actual.getId()).isEqualTo(expected.getId());
    }

    @Test
    public void mapsDtoToVitamin() {
        VitaminDto expected = aVitaminDto().build();

        Vitamin actual = vitaminMapper.toVitamin(expected);

        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getDailyNorm()).isEqualTo(expected.getDailyNorm().getWeight());
    }

    @Test
    public void mapsVitaminToDto() {
        Vitamin expected = aVitamin().build();

        VitaminDto actual = vitaminMapper.toVitaminDto(expected);

        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getDailyNorm().getWeight()).isEqualTo(expected.getDailyNorm());
    }

}