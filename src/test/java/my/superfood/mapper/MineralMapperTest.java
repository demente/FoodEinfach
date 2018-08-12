package my.superfood.mapper;

import my.superfood.dto.MineralAmountDto;
import my.superfood.dto.MineralDto;
import my.superfood.model.Mineral;
import my.superfood.model.MineralAmount;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.dto.MineralAmountDtoBuilder.aMineralAmountDto;
import static my.superfood.model.MineralAmountBuilder.aMineralAmount;
import static my.superfood.model.MineralBuilder.aMineral;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class MineralMapperTest {

    private MineralMapper mineralMapper;
    @Mock
    private WeightMapper weightMapper;

    @Before
    public void setup() {
        mineralMapper = new MineralMapper(weightMapper);
    }

    @Test
    public void mapsMineralAmountToDto() {
        MineralAmount expected = aMineralAmount().build();

        MineralAmountDto actual = mineralMapper.toMineralAmountDto(expected);

        assertThat(expected.getId()).isEqualTo(actual.getId());
        assertThat(expected.getMineral().getName()).isEqualTo(actual.getName());
    }

    @Test
    public void mapsMineralAmountDtoToEntity() {
        MineralAmountDto expected = aMineralAmountDto().build();

        MineralAmount actual = mineralMapper.toMineralAmount(expected);

        assertThat(expected.getId()).isEqualTo(actual.getId());
        assertThat(expected.getName()).isEqualTo(actual.getMineral().getName());
    }

    @Test
    public void mapsMineralToDto() {
        Mineral expected = aMineral().build();

        MineralDto actual = mineralMapper.toMineralDto(expected);

        assertThat(actual.getName()).isEqualTo(expected.getName().name());
    }

    @Test
    public void mapsWeightToWeightDto() {
        Mineral expected = aMineral().build();
        mineralMapper.toMineralDto(expected);

        then(weightMapper).should().toWeightDto(expected.getDailyNorm());
    }
}