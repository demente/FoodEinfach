package my.superfood.dao;

import io.dropwizard.testing.junit.DAOTestRule;
import my.superfood.model.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static my.superfood.model.FoodBuilder.aNewFood;
import static my.superfood.model.MealPlanBuilder.aNewMealPlan;
import static org.assertj.core.api.Assertions.assertThat;

public class MealPlanDaoTest {

    @Rule
    public DAOTestRule database = DAOTestRule.newBuilder()
            .addEntityClass(MealPlan.class)
            .addEntityClass(FoodInMealPlan.class)
            .addEntityClass(RecipeInMealPlan.class)
            .addEntityClass(Food.class)
            .addEntityClass(Recipe.class)
            .addEntityClass(Ingredient.class)
            .addEntityClass(Vitamin.class)
            .addEntityClass(VitaminAmount.class)
            .addEntityClass(Mineral.class)
            .addEntityClass(MineralAmount.class)
            .build();

    private MealPlanDao mealPlanDao;

    @Before
    public void setUp() {
        mealPlanDao = new MealPlanDao(database.getSessionFactory());
    }

    @Test
    public void savesMealPlan() {
        MealPlan mealPlan = database.inTransaction(() -> mealPlanDao.save(aNewMealPlan().build()));

        assertThat(mealPlan.getId()).isNotNull();
    }

    @Test
    public void findsById() {
        MealPlan expected = database.inTransaction(() -> mealPlanDao.save(aNewMealPlan().build()));

        MealPlan actual = mealPlanDao.findById(expected.getId());

        assertThat(actual).isSameAs(expected);
    }

    @Test
    public void deletesMealPlan() {
        MealPlan persisted = database.inTransaction(() -> mealPlanDao.save(aNewMealPlan().build()));

        mealPlanDao.delete(persisted.getId());

        assertThat(mealPlanDao.findById(persisted.getId())).isNull();
    }

    @Test
    public void findsAll() {
        MealPlan first = database.inTransaction(() -> mealPlanDao.save(aNewMealPlan().build()));
        MealPlan second = database.inTransaction(() -> mealPlanDao.save(aNewMealPlan().build()));

        List<MealPlan> actual = mealPlanDao.findAll();

        assertThat(actual).containsExactly(first, second);
    }

}