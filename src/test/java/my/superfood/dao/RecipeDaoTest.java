package my.superfood.dao;

import io.dropwizard.testing.junit.DAOTestRule;
import my.superfood.model.*;
import my.superfood.model.enums.MealType;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
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

    @Test
    public void findsAll() {
        Recipe applePie = database.inTransaction(() -> recipeDao.save(aNewRecipe().withName("Apple pie").build()));
        Recipe chocolateCake = database.inTransaction(() -> recipeDao.save(aNewRecipe().withName("Chocolate cake").build()));

        List<Recipe> actual = recipeDao.findAll();

        assertThat(actual).containsExactly(applePie, chocolateCake);
    }

    @Test
    public void findsByName() {
        Recipe applePie = database.inTransaction(() -> recipeDao.save(aNewRecipe().withName("Apple pie").build()));
        Recipe appleSouffle = database.inTransaction(() -> recipeDao.save(aNewRecipe().withName("Apple souffle").build()));
        Recipe apricotMuffin = database.inTransaction(() -> recipeDao.save(aNewRecipe().withName("Apricot muffin").build()));

        List<Recipe> actual = recipeDao.findByName("apple");

        assertThat(actual).containsExactly(applePie, appleSouffle);
        assertThat(actual).doesNotContain(apricotMuffin);
    }

    @Test
    public void findsByType() {
        Recipe applePie = database.inTransaction(() -> recipeDao.save(aNewRecipe().withName("Apple pie").withType(asList(MealType.BREAKFAST, MealType.SNACK)).build()));
        Recipe appleSouffle = database.inTransaction(() -> recipeDao.save(aNewRecipe().withName("Apple souffle").withType(asList(MealType.BREAKFAST)).build()));
        Recipe apricotMuffin = database.inTransaction(() -> recipeDao.save(aNewRecipe().withName("Apricot muffin").withType(asList(MealType.SNACK)).build()));

        List<Recipe> actual = recipeDao.findByType(MealType.BREAKFAST);

        assertThat(actual).containsExactly(applePie, appleSouffle);
        assertThat(actual).doesNotContain(apricotMuffin);
    }

}