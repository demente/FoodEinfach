package my.superfood.resources;

import io.dropwizard.testing.junit.ResourceTestRule;
import my.superfood.dao.FoodDao;
import my.superfood.dto.FoodDto;
import my.superfood.model.Food;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import static my.superfood.dto.FoodDtoBuilder.aFoodDto;
import static my.superfood.model.FoodBuilder.aFood;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;

public class FoodResourceTest {

    private static final FoodDao foodDao = mock(FoodDao.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
                                                                     .addResource(new FoodResource(foodDao))
                                                                     .build();

    @Before
    public void setup() {

        reset(foodDao);
    }

    @Test
    public void findsById() {
        resources.target("/food/1").request().get(FoodDto.class);

        then(foodDao).should().findById(1L);
    }

}