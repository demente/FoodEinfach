package my.superfood.resolver;

import my.superfood.dao.FoodDao;
import my.superfood.model.Food;
import my.superfood.resolver.FoodResolver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.model.FoodBuilder.aFood;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class FoodResolverTest {

    private FoodResolver foodResolver;
    @Mock
    private FoodDao foodDao;

    @Before
    public void setup() {
        foodResolver = new FoodResolver(foodDao);
    }

    @Test
    public void findsFoodById() {
        foodResolver.toFood(1L);

        then(foodDao).should().findById(1L);
    }

    @Test
    public void returnsFoodFoundById() {
        Food expected = aFood().build();
        given(foodDao.findById(anyLong())).willReturn(expected);

        Food actual = foodResolver.toFood(1L);

        assertThat(actual).isEqualTo(expected);
    }

}