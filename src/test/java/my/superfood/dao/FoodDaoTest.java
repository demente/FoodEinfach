package my.superfood.dao;

import io.dropwizard.testing.junit.DAOTestRule;
import my.superfood.model.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static my.superfood.model.FoodBuilder.aFood;
import static my.superfood.model.FoodBuilder.aNewFood;
import static org.assertj.core.api.Assertions.assertThat;

public class FoodDaoTest {

    @Rule
    public DAOTestRule database = DAOTestRule.newBuilder()
            .addEntityClass(Food.class)
            .addEntityClass(VitaminAmount.class)
            .addEntityClass(Vitamin.class)
            .addEntityClass(MineralAmount.class)
            .addEntityClass(Mineral.class)
            .build();

    private FoodDao foodDao;

    @Before
    public void setUp() {
        foodDao = new FoodDao(database.getSessionFactory());
    }

    @Test
    public void savesFood() {
        Food food = database.inTransaction(() -> foodDao.save(aNewFood().build()));

        assertThat(food.getId()).isNotNull();
    }

    @Test
    public void findsById() {
        Food expected = database.inTransaction(() -> foodDao.save(aNewFood().build()));

        Food actual = foodDao.findById(expected.getId());

        assertThat(actual).isSameAs(expected);
    }

    @Test
    public void deletesFood() {
        Food persisted = database.inTransaction(() -> foodDao.save(aNewFood().build()));

        foodDao.delete(persisted.getId());

        assertThat(foodDao.findById(persisted.getId())).isNull();
    }

    @Test
    public void findsAll() {
        Food apple = database.inTransaction(() -> foodDao.save(aNewFood().withName("Apple").build()));
        Food orange = database.inTransaction(() -> foodDao.save(aNewFood().withName("Orange").build()));

        List<Food> actual = foodDao.findAll();

        assertThat(actual).containsExactly(apple, orange);
    }

    @Test
    public void findsByName() {
        Food apple = database.inTransaction(() -> foodDao.save(aNewFood().withName("Apple").build()));
        Food apricot = database.inTransaction(() -> foodDao.save(aNewFood().withName("Apricot").build()));
        database.inTransaction(() -> foodDao.save(aNewFood().withName("Orange").build()));

        List<Food> actual = foodDao.findByName("AP");

        assertThat(actual).containsExactly(apple, apricot);
    }
}