package my.superfood.mapper;

import my.superfood.dto.MineralAmountDto;
import my.superfood.dto.MineralDto;
import my.superfood.dto.WeightDto;
import my.superfood.model.Mineral;
import my.superfood.model.MineralAmount;
import my.superfood.model.enums.MineralName;
import my.superfood.resolver.MineralResolver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static my.superfood.dto.MineralAmountDtoBuilder.aMineralAmountDto;
import static my.superfood.dto.WeightDtoBuilder.aWeightDto;
import static my.superfood.model.MineralAmountBuilder.aMineralAmount;
import static my.superfood.model.MineralBuilder.aMineral;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class MineralMapperTest {

    private MineralMapper mineralMapper;
    @Mock
    private WeightMapper weightMapper;
    @Mock
    private MineralResolver mineralResolver;

    @Before
    public void setup() {
        mineralMapper = new MineralMapper(mineralResolver, weightMapper);
    }

    @Test
    public void returnsNullWhenMappingNullToMineralAmount() {
        MineralAmount actual = mineralMapper.toMineralAmount(null);

        assertThat(actual).isNull();
    }

    @Test
    public void mapsMineralAmountDtoToMineralAmount() {
        MineralAmountDto expected = aMineralAmountDto().build();
        Long weight = 12L;
        Mineral mineral = aMineral().build();

        given(weightMapper.toWeight(any())).willReturn(weight);
        given(mineralResolver.toMineral(any())).willReturn(mineral);

        MineralAmount actual = mineralMapper.toMineralAmount(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getMineral()).isEqualTo(mineral);
        assertThat(actual.getAmount()).isEqualTo(weight);
    }

    @Test
    public void mapsToWeightWhenMappingMineralAmountDtoToMineralAmount() {
        WeightDto expected = aWeightDto().build();

        mineralMapper.toMineralAmount(aMineralAmountDto().withAmount(expected).build());

        then(weightMapper).should().toWeight(expected);
    }

    @Test
    public void mapsToMineralWhenMappingMineralAmountDtoToMineralAmount() {
        mineralMapper.toMineralAmount(aMineralAmountDto().withName(MineralName.Ca).build());

        then(mineralResolver).should().toMineral(MineralName.Ca);
    }


    @Test
    public void mapsMineralAmountToMineralAmountDto() {
        MineralAmount expected = aMineralAmount().build();
        WeightDto weightDto = aWeightDto().build();

        given(weightMapper.toWeightDto(any())).willReturn(weightDto);

        MineralAmountDto actual = mineralMapper.toMineralAmountDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getMineral().getName());
        assertThat(actual.getAmount()).isEqualTo(weightDto);
        assertThat(actual.getDailyNorm()).isEqualTo(weightDto);
    }

    @Test
    public void mapsToWeightDtoWhenMappingMineralAmountToMineralAmountDto() {
        long amount = 12L;
        long dailyNorm = 10L;

        mineralMapper.toMineralAmountDto(aMineralAmount().withAmount(amount).withMineral(aMineral().withDailyNorm(dailyNorm).build()).build());

        then(weightMapper).should().toWeightDto(amount);
        then(weightMapper).should().toWeightDto(dailyNorm);
    }

    @Test
    public void mapsMineralToMineralDto() {
        Mineral expected = aMineral().build();
        WeightDto weight = aWeightDto().build();

        given(weightMapper.toWeightDto(any())).willReturn(weight);

        MineralDto actual = mineralMapper.toMineralDto(expected);

        assertThat(actual.getName()).isEqualTo(expected.getName().name());
        assertThat(actual.getDailyNorm()).isEqualTo(weight);
    }

    @Test
    public void mapsToWeightDtoWhenMappingMineralToMineralDto() {
        mineralMapper.toMineralDto(aMineral().withDailyNorm(12L).build());

        then(weightMapper).should().toWeightDto(12L);
    }

    @Test
    public void mapsToMineralDtoList() {
        Mineral expected = aMineral().build();
        WeightDto weight = aWeightDto().build();

        given(weightMapper.toWeightDto(any())).willReturn(weight);

        List<MineralDto> actual = mineralMapper.toMineralDtoList(asList(expected));

        assertThat(actual).extracting(MineralDto::getName).containsExactly(expected.getName().name());
        assertThat(actual).extracting(MineralDto::getDailyNorm).containsExactly(weight);
    }

    @Test
    public void mapsToMineralAmountDtoList() {
        MineralAmount expected = aMineralAmount().build();
        WeightDto weightDto = aWeightDto().build();

        given(weightMapper.toWeightDto(any())).willReturn(weightDto);

        List<MineralAmountDto> actual = mineralMapper.toMineralAmountDtoList(asList(expected));

        assertThat(actual).extracting(MineralAmountDto::getId).containsExactly(expected.getId());
        assertThat(actual).extracting(MineralAmountDto::getName).containsExactly(expected.getMineral().getName());
        assertThat(actual).extracting(MineralAmountDto::getAmount).containsExactly(weightDto);
        assertThat(actual).extracting(MineralAmountDto::getDailyNorm).containsExactly(weightDto);
    }

    @Test
    public void mapsToMineralAmountList() {
        MineralAmountDto expected = aMineralAmountDto().build();
        Long weight = 12L;
        Mineral mineral = aMineral().build();

        given(weightMapper.toWeight(any())).willReturn(weight);
        given(mineralResolver.toMineral(any())).willReturn(mineral);

        List<MineralAmount> actual = mineralMapper.toMineralAmountList(asList(expected));

        assertThat(actual).extracting(MineralAmount::getId).containsExactly(expected.getId());
        assertThat(actual).extracting(MineralAmount::getMineral).containsExactly(mineral);
        assertThat(actual).extracting(MineralAmount::getAmount).containsExactly(weight);
    }
}