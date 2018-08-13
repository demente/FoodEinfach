package my.superfood.mapper;

import my.superfood.dto.VitaminAmountDto;
import my.superfood.dto.VitaminDto;
import my.superfood.dto.WeightDto;
import my.superfood.model.Vitamin;
import my.superfood.model.VitaminAmount;
import my.superfood.model.enums.VitaminName;
import my.superfood.resolver.VitaminResolver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static my.superfood.dto.VitaminAmountDtoBuilder.aVitaminAmountDto;
import static my.superfood.dto.WeightDtoBuilder.aWeightDto;
import static my.superfood.model.VitaminAmountBuilder.aVitaminAmount;
import static my.superfood.model.VitaminBuilder.aVitamin;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class VitaminMapperTest {

    private VitaminMapper vitaminMapper;
    @Mock
    private WeightMapper weightMapper;
    @Mock
    private VitaminResolver vitaminResolver;

    @Before
    public void setup() {
        vitaminMapper = new VitaminMapper(vitaminResolver, weightMapper);
    }

    @Test
    public void returnsNullWhenMappingNullToVitaminAmount() {
        VitaminAmount actual = vitaminMapper.toVitaminAmount(null);

        assertThat(actual).isNull();
        verifyZeroInteractions(weightMapper);
        verifyZeroInteractions(vitaminResolver);
    }

    @Test
    public void mapsDtoToVitaminAmount() {
        Vitamin expectedVitamin = aVitamin().build();
        VitaminAmountDto expected = aVitaminAmountDto().build();
        Long expectedWeight = 112L;

        given(vitaminResolver.toVitamin(any())).willReturn(expectedVitamin);
        given(weightMapper.toWeightInMicrograms(any())).willReturn(expectedWeight);

        VitaminAmount actual = vitaminMapper.toVitaminAmount(expected);

        assertThat(actual.getVitamin()).isEqualTo(expectedVitamin);
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getAmount()).isEqualTo(expectedWeight);
    }

    @Test
    public void resolvesVitaminByVitaminNameWhenMappingDtoToVitaminAmount() {
        vitaminMapper.toVitaminAmount(aVitaminAmountDto().withName(VitaminName.A).build());

        then(vitaminResolver).should().toVitamin(VitaminName.A);
    }

    @Test
    public void mapsAmountWhenMappingDtoToVitaminAmount() {
        WeightDto weight = aWeightDto().build();
        vitaminMapper.toVitaminAmount(aVitaminAmountDto().withAmount(weight).build());

        then(weightMapper).should().toWeightInMicrograms(weight);
    }

    @Test
    public void mapsVitaminAmountToDto() {
        VitaminAmount expected = aVitaminAmount().build();
        WeightDto weightDto = aWeightDto().build();

        given(weightMapper.toWeightDto(any())).willReturn(weightDto);

        VitaminAmountDto actual = vitaminMapper.toVitaminAmountDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getVitamin().getName());
        assertThat(actual.getAmount()).isEqualTo(weightDto);
        assertThat(actual.getDailyNorm()).isEqualTo(weightDto);
    }

    @Test
    public void returnsNullWhenMappingNullToVitaminDto() {
        VitaminDto actual = vitaminMapper.toVitaminDto(null);
        assertThat(actual).isNull();
    }

    @Test
    public void mapsVitaminToVitaminDto() {
        Vitamin expected = aVitamin().build();
        WeightDto weightDto = aWeightDto().build();

        given(weightMapper.toWeightDto(any())).willReturn(weightDto);

        VitaminDto actual = vitaminMapper.toVitaminDto(expected);

        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getDailyNorm()).isEqualTo(weightDto);
    }

    @Test
    public void mapsToWeightDtoWhenMappingVitaminToVitaminDto() {
        vitaminMapper.toVitaminDto(aVitamin().withDailyNorm(12L).build());

        then(weightMapper).should().toWeightDto(12L);
    }


    @Test
    public void mapsToVitaminDtoList() {
        Vitamin expected = aVitamin().build();
        WeightDto weightDto = aWeightDto().build();

        given(weightMapper.toWeightDto(any())).willReturn(weightDto);

        List<VitaminDto> actual = vitaminMapper.toVitaminDtoList(asList(expected));

        assertThat(actual).extracting(VitaminDto::getDailyNorm).containsExactly(weightDto);
        assertThat(actual).extracting(VitaminDto::getName).containsExactly(expected.getName());
    }


    @Test
    public void mapsToVitaminAmountDtoList() {
        VitaminAmount expected = aVitaminAmount().build();
        WeightDto weightDto = aWeightDto().build();

        given(weightMapper.toWeightDto(any())).willReturn(weightDto);

        List<VitaminAmountDto> actual = vitaminMapper.toVitaminAmountDtoList(asList(expected));

        assertThat(actual).extracting(VitaminAmountDto::getId).containsExactly(expected.getId());
        assertThat(actual).extracting(VitaminAmountDto::getName).containsExactly(expected.getVitamin().getName());
        assertThat(actual).extracting(VitaminAmountDto::getAmount).containsExactly(weightDto);
        assertThat(actual).extracting(VitaminAmountDto::getDailyNorm).containsExactly(weightDto);
    }

    @Test
    public void mapsToVitaminAmountList() {
        Vitamin expectedVitamin = aVitamin().build();
        VitaminAmountDto expected = aVitaminAmountDto().build();
        Long expectedWeight = 112L;

        given(vitaminResolver.toVitamin(any())).willReturn(expectedVitamin);
        given(weightMapper.toWeightInMicrograms(any())).willReturn(expectedWeight);

        List<VitaminAmount> actual = vitaminMapper.toVitaminAmountList(asList(expected));

        assertThat(actual).extracting(VitaminAmount::getId).containsExactly(expected.getId());
        assertThat(actual).extracting(VitaminAmount::getVitamin).containsExactly(expectedVitamin);
        assertThat(actual).extracting(VitaminAmount::getAmount).containsExactly(expectedWeight);
    }

}