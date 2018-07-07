package my.superfood.mapper;

import my.superfood.dto.MineralAmountDto;
import my.superfood.model.MineralAmount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.dto.MineralAmountDtoBuilder.aMineralAmountDto;
import static my.superfood.model.MineralAmountBuilder.aMineralAmount;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MineralMapperTest {

    @InjectMocks
    private MineralMapper mineralMapper = new MineralMapperImpl();

    @Test
    public void mapsEntityToDto() {
        MineralAmount expected = aMineralAmount().build();

        MineralAmountDto actual = mineralMapper.toMineralAmountDto(expected);

        assertThat(expected.getId()).isEqualTo(actual.getId());
        assertThat(expected.getMineral().getName()).isEqualTo(actual.getName());
    }

    @Test
    public void mapsDtoToEntity() {
        MineralAmountDto expected = aMineralAmountDto().build();

        MineralAmount actual = mineralMapper.toMineral(expected);

        assertThat(expected.getId()).isEqualTo(actual.getId());
        assertThat(expected.getName()).isEqualTo(actual.getMineral().getName());
    }
}