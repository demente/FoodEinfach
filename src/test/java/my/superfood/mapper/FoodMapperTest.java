package my.superfood.mapper;

import my.superfood.dto.FoodDto;
import my.superfood.dto.FoodInfoDto;
import my.superfood.model.Food;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.dto.FoodDtoBuilder.aFoodDto;
import static my.superfood.dto.WeightDtoBuilder.aWeightDto;
import static my.superfood.model.FoodBuilder.aFood;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class FoodMapperTest {

    private FoodMapper foodMapper;

    @Mock
    private NutritionalInformationMapper nutritionalInformationMapper;
    @Mock
    private WeightMapper weightMapper;

    @Before
    public void setup() {
        foodMapper = new FoodMapper(nutritionalInformationMapper, weightMapper);
    }

    @Test
    public void mapsDtoToEntity() {
        FoodDto expected = aFoodDto().build();

        Food actual = foodMapper.toFood(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getType().name()).isEqualTo(expected.getType());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getPieceName()).isEqualTo(expected.getPieceName());
        assertThat(actual.getPricePerMinimumWeightInCents()).isEqualTo(expected.getPricePerMinimumWeightInCents());
    }

    @Test
    public void mapsMinimumWeightToDto() {
        Food expected = aFood().withMinimumWeight(100000L).build();

        foodMapper.toFoodDto(expected);

        then(weightMapper).should().toWeightDto(expected.getMinimumWeight());
    }

    @Test
    public void mapsEntityToDto() {
        Food expected = aFood().build();

        FoodDto actual = foodMapper.toFoodDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getType()).isEqualTo(expected.getType().name());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getPricePerMinimumWeightInCents()).isEqualTo(expected.getPricePerMinimumWeightInCents());
    }

    @Test
    public void mapsMinimumWeightDto() {
        FoodDto expected = aFoodDto().withMinimumWeight(aWeightDto().build()).build();

        foodMapper.toFood(expected);

        then(weightMapper).should().toWeightInMicrograms(expected.getMinimumWeight());
    }

    @Test
    public void mapsToNutritionalInformationDto() {
        Food food = aFood().build();

        foodMapper.toFoodDto(food);

        then(nutritionalInformationMapper).should().toNutritionalInformationDto(food.getNutritionPerHundredGrams());
    }

    @Test
    public void mapsToNutritionalInformation() {
        FoodDto food = aFoodDto().build();

        foodMapper.toFood(food);

        then(nutritionalInformationMapper).should().toNutritionalInformation(food.getNutritionalInformation());
    }

    @Test
    public void mapsEntityToInfoDto() {
        Food expected = aFood().build();

        FoodInfoDto actual = foodMapper.toFoodInfoDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getType()).isEqualTo(expected.getType().name());
    }

}
