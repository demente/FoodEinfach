package my.superfood.mapper;

import my.superfood.dto.FoodDto;
import my.superfood.model.Food;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.dto.FoodDtoBuilder.aFoodDto;
import static my.superfood.model.FoodBuilder.aFood;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class FoodMapperTest {

    @InjectMocks
    private FoodMapper foodMapper = new FoodMapperImpl();

    @Mock
    private NutritionalInformationMapper nutritionalInformationMapper;


    @Test
    public void mapsDtoToEntity() {
        FoodDto expected = aFoodDto().build();

        Food actual = foodMapper.toFood(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getType().name()).isEqualTo(expected.getType());
        assertThat(actual.getName()).isEqualTo(expected.getName());
    }

    @Test
    public void mapsEntityToDto() {
        Food expected = aFood().build();

        FoodDto actual = foodMapper.toFoodDto(expected);

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getType()).isEqualTo(expected.getType().name());
        assertThat(actual.getName()).isEqualTo(expected.getName());
    }

    @Test
    @Ignore(value = "until I find a way to use mocks")
    public void mapsToNutritionalInformationDto() {
        Food food = aFood().build();

        foodMapper.toFoodDto(food);

        then(nutritionalInformationMapper).should().toNutritionalInformationDto(food.getNutritionPerHundredGrams());
    }

    @Test
    @Ignore(value = "until I find a way to use mocks")
    public void mapsToNutritionalInformation() {
        FoodDto food = aFoodDto().build();

        foodMapper.toFood(food);

        then(nutritionalInformationMapper).should().toNutritionalInformation(food.getNutritionalInformation());
    }

}
