package my.superfood.dao;

import io.dropwizard.testing.junit.DAOTestRule;
import my.superfood.model.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static my.superfood.model.MealPlanBuilder.aNewMealPlan;
import static my.superfood.model.MealPlanFoodBuilder.aNewMealPlanFood;
import static my.superfood.model.MealPlanRecipeBuilder.aNewMealPlanRecipe;
import static my.superfood.model.RecipeBuilder.aNewRecipe;
import static org.assertj.core.api.Assertions.assertThat;

public class MealPlanDaoTest {

    @Rule
    public DAOTestRule database = DAOTestRule.newBuilder()
            .addEntityClass(MealPlan.class)
            .addEntityClass(MealPlanFood.class)
            .addEntityClass(MealPlanRecipe.class)
            .addEntityClass(Food.class)
            .addEntityClass(Recipe.class)
            .addEntityClass(Ingredient.class)
            .addEntityClass(Vitamin.class)
            .addEntityClass(VitaminAmount.class)
            .addEntityClass(Mineral.class)
            .addEntityClass(MineralAmount.class)
            .build();

    private MealPlanDao mealPlanDao;
    private RecipeDao recipeDao;

    @Before
    public void setUp() {
        mealPlanDao = new MealPlanDao(database.getSessionFactory());
        recipeDao = new RecipeDao(database.getSessionFactory());
    }

    @Test
    public void savesMealPlan() {
        Recipe recipe = database.inTransaction(() -> recipeDao.save(aNewRecipe().build()));
        MealPlan mealPlan = database.inTransaction(() -> mealPlanDao.save(aNewMealPlan().withFood(asList(aNewMealPlanFood().build()))
                .withRecipes(asList(aNewMealPlanRecipe().withRecipe(recipe).build())).build()));

        assertThat(mealPlan.getId()).isNotNull();
    }

    @Test
    public void findsById() {
        Recipe recipe = database.inTransaction(() -> recipeDao.save(aNewRecipe().build()));
        MealPlan expected = database.inTransaction(() -> mealPlanDao.save(aNewMealPlan().withFood(asList(aNewMealPlanFood().build()))
                .withRecipes(asList(aNewMealPlanRecipe().withRecipe(recipe).build())).build()));

        MealPlan actual = mealPlanDao.findById(expected.getId());

        assertThat(actual).isSameAs(expected);
    }

    @Test
    public void deletesMealPlan() {
        Recipe recipe = database.inTransaction(() -> recipeDao.save(aNewRecipe().build()));
        MealPlan persisted = database.inTransaction(() -> mealPlanDao.save(aNewMealPlan().withFood(asList(aNewMealPlanFood().build()))
                .withRecipes(asList(aNewMealPlanRecipe().withRecipe(recipe).build())).build()));

        mealPlanDao.delete(persisted.getId());

        assertThat(mealPlanDao.findById(persisted.getId())).isNull();
    }

    @Test
    public void findsAll() {
        Recipe recipe = database.inTransaction(() -> recipeDao.save(aNewRecipe().build()));
        MealPlan first = database.inTransaction(() -> mealPlanDao.save(aNewMealPlan().withFood(asList(aNewMealPlanFood().build()))
                .withRecipes(asList(aNewMealPlanRecipe().withRecipe(recipe).build())).build()));
        MealPlan second = database.inTransaction(() -> mealPlanDao.save(aNewMealPlan().withFood(asList(aNewMealPlanFood().build()))
                .withRecipes(asList(aNewMealPlanRecipe().withRecipe(recipe).build())).build()));

        List<MealPlan> actual = mealPlanDao.findAll();

        assertThat(actual).containsExactly(first, second);
    }

}