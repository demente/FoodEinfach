package my.superfood.dao;

import io.dropwizard.testing.junit.DAOTestRule;
import my.superfood.model.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static my.superfood.model.FoodBuilder.aNewFood;
import static my.superfood.model.RecipeBuilder.aNewRecipe;
import static org.assertj.core.api.Assertions.assertThat;

public class RecipeDaoTest {

    @Rule
    public DAOTestRule database = DAOTestRule.newBuilder()
            .addEntityClass(Recipe.class)
            .addEntityClass(Ingredient.class)
            .addEntityClass(Food.class)
            .addEntityClass(VitaminAmount.class)
            .addEntityClass(Vitamin.class)
            .addEntityClass(MineralAmount.class)
            .addEntityClass(Mineral.class)
            .build();

    private RecipeDao recipeDao;

    @Before
    public void setUp() {
        recipeDao = new RecipeDao(database.getSessionFactory());
    }

    @Test
    public void savesRecipe() {
        Recipe recipe = database.inTransaction(() -> recipeDao.save(aNewRecipe().build()));

        assertThat(recipe.getId()).isNotNull();
    }

    @Test
    public void deletesById() {
        Recipe recipe = database.inTransaction(() -> recipeDao.save(aNewRecipe().build()));

        recipeDao.delete(recipe.getId());

        assertThat(recipeDao.findById(recipe.getId())).isNull();
    }

    @Test
    public void findsById() {
        Recipe expected = database.inTransaction(() -> recipeDao.save(aNewRecipe().build()));

        Recipe actual = recipeDao.findById(expected.getId());

        assertThat(actual).isSameAs(expected);
    }

}