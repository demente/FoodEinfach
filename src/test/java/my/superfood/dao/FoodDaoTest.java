package my.superfood.dao;

import io.dropwizard.testing.junit.DAOTestRule;
import my.superfood.model.Food;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static my.superfood.model.FoodBuilder.aFood;
import static org.assertj.core.api.Assertions.assertThat;

public class FoodDaoTest {

    @Rule
    public DAOTestRule database = DAOTestRule.newBuilder().addEntityClass(Food.class).build();
    private FoodDao foodDao;

    @Before
    public void setUp() {
        foodDao = new FoodDao(database.getSessionFactory());
    }

    @Test
    public void createsFood() {
        Food food = database.inTransaction(() -> {
            return foodDao.save(aFood().build());
        });

        assertThat(food.getId()).isNotNull();
    }

    @Test
    public void roundtripsFoo() {
        Food food = database.inTransaction(() -> {
            return foodDao.save(aFood().build());
        });

        Food f = foodDao.findById(food.getId());

        assertThat(f).isSameAs(food);
    }
}