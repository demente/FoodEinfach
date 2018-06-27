package my.superfood.mapper;

import my.superfood.dto.MineralDto;
import my.superfood.model.MineralAmount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.dto.MineralDtoBuilder.aMineralDto;
import static my.superfood.model.MineralAmountBuilder.aMineralAmount;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class MineralMapperTest {

    @InjectMocks
    private MineralMapper mineralMapper = new MineralMapperImpl();

    @Test
    public void mapsEntityToDto() {
        MineralAmount expected = aMineralAmount().build();

        MineralDto actual = mineralMapper.toMineralDto(expected);

        assertThat(expected.getId()).isEqualTo(actual.getId());
        assertThat(expected.getName()).isEqualTo(actual.getName());
    }

    @Test
    public void mapsDtoToEntity() {
        MineralDto expected = aMineralDto().build();

        MineralAmount actual = mineralMapper.toMineral(expected);

        assertThat(expected.getId()).isEqualTo(actual.getId());
        assertThat(expected.getName()).isEqualTo(actual.getName());
    }
}