package my.superfood.resources;

import io.dropwizard.testing.junit.ResourceTestRule;
import my.superfood.dao.FoodDao;
import my.superfood.dto.FoodDto;
import my.superfood.mapper.FoodMapper;
import my.superfood.model.Food;
import my.superfood.model.enums.MineralName;
import my.superfood.model.enums.VitaminName;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static java.util.Arrays.asList;
import static my.superfood.assertions.DtoAssertions.assertEqualFoodDto;
import static my.superfood.dto.FoodDtoBuilder.aFoodDto;
import static my.superfood.model.FoodBuilder.aFood;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;

public class FoodResourceTest {

    private static final FoodDao foodDao = mock(FoodDao.class);
    private static final FoodMapper foodMapper = mock(FoodMapper.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new FoodResource(foodDao, foodMapper))
            .build();

    @Before
    public void setup() {
        reset(foodDao);
        reset(foodMapper);

        given(foodDao.save(any(Food.class))).willReturn(aFood().build());
        given(foodMapper.toFood(any(FoodDto.class))).willReturn(aFood().build());
        given(foodDao.findByName(anyString())).willReturn(asList(aFood().build()));
        given(foodMapper.toFoodDtoList(anyList())).willReturn(asList(aFoodDto().build()));
    }

    @Test
    public void findsById() {
        resources.target("/food/1").request().get(FoodDto.class);

        then(foodDao).should().findById(1L);
    }

    @Test
    public void mapsFoundFoodToDto() {
        Food expected = aFood().build();
        given(foodDao.findById(anyLong())).willReturn(expected);

        resources.target("/food/1").request().get(FoodDto.class);

        then(foodMapper).should().toFoodDto(expected);
    }

    @Test
    public void returnsMappedFoodDto() {
        FoodDto expected = aFoodDto().build();
        given(foodMapper.toFoodDto(any())).willReturn(expected);

        FoodDto actual = resources.target("/food/1").request().get(FoodDto.class);

        assertEqualFoodDto(expected, actual);
    }

    @Test
    public void savesFood() {
        Food expected = aFood().build();
        given(foodMapper.toFood(any(FoodDto.class))).willReturn(expected);
        given(foodDao.save(any(Food.class))).willReturn(expected);

        resources.target("/food").request().post(Entity.json(aFoodDto().build()));

        then(foodDao).should().save(expected);
    }

    @Test
    public void mapsFoodDtoToFood() {
        FoodDto expected = aFoodDto().build();
        resources.target("/food").request().post(Entity.json(expected));

        ArgumentCaptor<FoodDto> foodDtoArgumentCaptor = ArgumentCaptor.forClass(FoodDto.class);

        then(foodMapper).should().toFood(foodDtoArgumentCaptor.capture());

        assertEqualFoodDto(foodDtoArgumentCaptor.getValue(), expected);
    }

    @Test
    public void returnsIdOfPersistedFood() {
        Long expectedId = 4L;
        given(foodDao.save(any(Food.class))).willReturn(aFood().withId(expectedId).build());

        Response response = resources.target("/food").request().post(Entity.json(aFoodDto().build()));
        assertThat(response.readEntity(Long.class)).isEqualTo(expectedId);
    }

    @Test
    public void deletesFood() {
        resources.target("/food/1").request().delete();

        then(foodDao).should().delete(1L);
    }

    @Test
    public void findsByName() {
        resources.target("/food").queryParam("name", "test").request().get(new GenericType<List<FoodDto>>() {
        });

        then(foodDao).should().findByName("test");
    }

    @Test
    public void mapsFoodFoundByNameToDtoList() {
        List<Food> expected = asList(aFood().build());
        given(foodDao.findByName(anyString())).willReturn(expected);

        resources.target("/food").queryParam("name", "test").request().get(new GenericType<List<FoodDto>>() {
        });

        then(foodMapper).should().toFoodDtoList(expected);
    }

    @Test
    public void returnsMappedFoodDtoList() {
        FoodDto expected = aFoodDto().build();
        given(foodMapper.toFoodDtoList(anyList())).willReturn(asList(expected));

        List<FoodDto> actual = resources.target("/food").queryParam("name", "test").request().get(new GenericType<List<FoodDto>>() {
        });

        assertEqualFoodDto(actual.get(0), expected);
    }

    @Test
    public void findsByMineral() {
        resources.target("/food/mineral/Ca").request().get(new GenericType<List<FoodDto>>() {
        });

        then(foodDao).should().findByMineral(MineralName.Ca);
    }

    @Test
    public void mapsFoodFoundByMineralToDtoList() {
        List<Food> expected = asList(aFood().build());
        given(foodDao.findByMineral(any())).willReturn(expected);

        resources.target("/food/mineral/Ca").request().get(new GenericType<List<FoodDto>>() {
        });

        then(foodMapper).should().toFoodDtoList(expected);
    }

    @Test
    public void returnsFoodFoundByMineral() {
        FoodDto expected = aFoodDto().build();
        given(foodMapper.toFoodDtoList(anyList())).willReturn(asList(expected));

        List<FoodDto> actual = resources.target("/food/mineral/Ca").request().get(new GenericType<List<FoodDto>>() {
        });


        assertEqualFoodDto(actual.get(0), expected);
    }

    @Test
    public void findsByVitamin() {
        resources.target("/food/vitamin/A").request().get(new GenericType<List<FoodDto>>() {
        });

        then(foodDao).should().findByVitamin(VitaminName.A);
    }

    @Test
    public void mapsFoodFoundByVitaminToDtoList() {
        List<Food> expected = asList(aFood().build());
        given(foodDao.findByVitamin(any())).willReturn(expected);

        resources.target("/food/vitamin/A").request().get(new GenericType<List<FoodDto>>() {
        });

        then(foodMapper).should().toFoodDtoList(expected);
    }

    @Test
    public void returnsFoodFoundByVitamin() {
        FoodDto expected = aFoodDto().build();
        given(foodMapper.toFoodDtoList(anyList())).willReturn(asList(expected));

        List<FoodDto> actual = resources.target("/food/vitamin/A").request().get(new GenericType<List<FoodDto>>() {
        });

        assertEqualFoodDto(actual.get(0), expected);
    }
}