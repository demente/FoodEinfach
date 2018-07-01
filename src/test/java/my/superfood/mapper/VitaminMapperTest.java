package my.superfood.mapper;

import my.superfood.dto.VitaminDto;
import my.superfood.model.VitaminAmount;
import org.junit.Test;

import static my.superfood.dto.VitaminDtoBuilder.aVitaminDto;
import static my.superfood.model.VitaminAmountBuilder.aVitaminAmount;
import static org.assertj.core.api.Assertions.assertThat;

public class VitaminMapperTest {

    private VitaminMapper vitaminMapper = new VitaminMapperImpl();

    @Test
    public void mapsDtoToEntity() {
        VitaminDto expected = aVitaminDto().build();

        VitaminAmount actual = vitaminMapper.toVitamin(expected);

        assertThat(actual.getVitamin().getName()).isEqualTo(expected.getName());
        assertThat(actual.getId()).isEqualTo(expected.getId());
    }

    @Test
    public void mapsEntityToDto() {
        VitaminAmount expected = aVitaminAmount().build();

        VitaminDto actual = vitaminMapper.toVitaminDto(expected);

        assertThat(actual.getName()).isEqualTo(expected.getVitamin().getName());
        assertThat(actual.getId()).isEqualTo(expected.getId());
    }

}