package my.superfood.mapper;

import my.superfood.dto.MineralAmountDto;
import my.superfood.dto.MineralDto;
import my.superfood.model.Mineral;
import my.superfood.model.MineralAmount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.dto.MineralAmountDtoBuilder.aMineralAmountDto;
import static my.superfood.model.MineralAmountBuilder.aMineralAmount;
import static my.superfood.model.MineralBuilder.aMineral;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MineralMapperTest {

    @InjectMocks
    private MineralMapper mineralMapper = new MineralMapperImpl();

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
        assertThat(actual.getDailyNorm().getWeight()).isEqualTo(expected.getDailyNorm());
    }
}