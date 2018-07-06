package my.superFoodInfo.resources;

import io.dropwizard.testing.junit.ResourceTestRule;

import my.superfood.dao.FoodDao;
import my.superfood.dto.FoodDto;
import my.superfood.dto.FoodInfoDto;
import my.superfood.mapper.FoodMapper;
import my.superfood.model.Food;
import my.superfood.resources.FoodInfoResource;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static java.util.Arrays.asList;
import static my.superfood.dto.FoodInfoDtoBuilder.aFoodInfoDto;
import static my.superfood.model.FoodBuilder.aFood;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;

public class FoodInfoResourceTest {

    private static final FoodDao foodDao = mock(FoodDao.class);
    private static final FoodMapper foodMapper = mock(FoodMapper.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new FoodInfoResource(foodDao, foodMapper))
            .build();

    @Before
    public void setup() {
        reset(foodDao);
        reset(foodMapper);

        given(foodMapper.toFoodInfoDto(any(Food.class))).willReturn(aFoodInfoDto().build());
        given(foodMapper.toFoodInfoDtoList(anyList())).willReturn(asList(aFoodInfoDto().build()));
    }

    @Test
    public void findsAll() {
        resources.target("/foodinfo").request().get(new GenericType<List<FoodInfoDto>>() {
        });

        then(foodDao).should().findAll();
    }

    @Test
    public void mapsFoundFoodToFoodInfoDtoList() {
        List<Food> expected = asList(aFood().build());
        given(foodDao.findAll()).willReturn(expected);

        resources.target("/foodinfo").request().get(new GenericType<List<FoodInfoDto>>() {
        });

        then(foodMapper).should().toFoodInfoDtoList(expected);
    }

    @Test
    public void returnsMappedFoodInfoDto() {
        FoodInfoDto expected = aFoodInfoDto().build();
        given(foodMapper.toFoodInfoDtoList(anyList())).willReturn(asList(expected));

        List<FoodInfoDto> actual = resources.target("/foodinfo").request().get(new GenericType<List<FoodInfoDto>>() {
        });

        assertThat(actual).extracting(FoodInfoDto::getId).containsExactly(expected.getId());
        assertThat(actual).extracting(FoodInfoDto::getName).containsExactly(expected.getName());
        assertThat(actual).extracting(FoodInfoDto::getType).containsExactly(expected.getType());
    }

}