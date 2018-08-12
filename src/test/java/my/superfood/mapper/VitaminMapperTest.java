package my.superfood.mapper;

import my.superfood.dto.VitaminDto;
import my.superfood.model.Vitamin;
import my.superfood.model.VitaminAmount;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.dto.VitaminDtoBuilder.aVitaminDto;
import static my.superfood.model.VitaminAmountBuilder.aVitaminAmount;
import static my.superfood.model.VitaminBuilder.aVitamin;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class VitaminMapperTest {

    private VitaminMapper vitaminMapper;
    @Mock
    private WeightMapper weightMapper;

    @Before
    public void setup() {
        vitaminMapper = new VitaminMapper(weightMapper);
    }

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
    }

    @Test
    public void mapsToWeight() {
        VitaminDto expected = aVitaminDto().build();

        vitaminMapper.toVitamin(expected);

        then(weightMapper).should().toWeight(expected.getDailyNorm());
    }

    @Test
    public void mapsVitaminToDto() {
        Vitamin expected = aVitamin().build();

        VitaminDto actual = vitaminMapper.toVitaminDto(expected);

        assertThat(actual.getName()).isEqualTo(expected.getName());
    }

    @Test
    public void mapsToWeightDto() {

        Vitamin expected = aVitamin().build();

        vitaminMapper.toVitaminDto(expected);

        then(weightMapper).should().toWeightDto(expected.getDailyNorm());
    }

}