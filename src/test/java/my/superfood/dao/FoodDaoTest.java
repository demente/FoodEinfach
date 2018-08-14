package my.superfood.dao;

import io.dropwizard.testing.junit.DAOTestRule;
import my.superfood.model.*;
import my.superfood.model.enums.MineralName;
import my.superfood.model.enums.VitaminName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static my.superfood.model.FoodBuilder.aNewFood;
import static my.superfood.model.MineralAmountBuilder.aNewMineralAmount;
import static my.superfood.model.MineralBuilder.aMineral;
import static my.superfood.model.NutritionalInformationBuilder.aNutritionalInformation;
import static my.superfood.model.VitaminAmountBuilder.aNewVitaminAmount;
import static my.superfood.model.VitaminBuilder.aVitamin;
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
    private MineralDao mineralDao;
    private VitaminDao vitaminDao;

    @Before
    public void setUp() {
        foodDao = new FoodDao(database.getSessionFactory());
        mineralDao = new MineralDao(database.getSessionFactory());
        vitaminDao = new VitaminDao(database.getSessionFactory());
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

    @Test
    public void findsByMineral() {
        Mineral ca = database.inTransaction(() -> mineralDao.save(aMineral().withName(MineralName.Ca).build()));

        Food apple = database.inTransaction(() ->
                foodDao.save(aNewFood().withName("Apple")
                        .withNutritionPerHundredGrams(aNutritionalInformation().withMinerals(
                                asList(aNewMineralAmount().withMineral(ca).withAmount(120L).build())).build()).build()));

        Food plum = database.inTransaction(() -> foodDao.save(aNewFood().withName("Plum")
                .withNutritionPerHundredGrams(aNutritionalInformation().withMinerals(
                        asList(aNewMineralAmount().withMineral(ca).withAmount(10L).build())).build()).build()));

        Food pear = database.inTransaction(() ->
                foodDao.save(aNewFood().withName("Pear")
                        .withNutritionPerHundredGrams(aNutritionalInformation().withMinerals(
                                asList(aNewMineralAmount().withMineral(aMineral().withName(MineralName.Fe).build()).build())).build()).build()));

        List<Food> actual = foodDao.findByMineral(MineralName.Ca);

        assertThat(actual).containsExactly(apple, plum);
        assertThat(actual).doesNotContain(pear);
    }

    @Test
    public void findsByVitamin() {
        Vitamin a = database.inTransaction(() -> vitaminDao.save(aVitamin().withName(VitaminName.A).build()));

        Food apple = database.inTransaction(() ->
                foodDao.save(aNewFood().withName("Apple")
                        .withNutritionPerHundredGrams(aNutritionalInformation().withVitamins(
                                asList(aNewVitaminAmount().withVitamin(a).withAmount(120L).build())).build()).build()));

        Food plum = database.inTransaction(() -> foodDao.save(aNewFood().withName("Plum")
                .withNutritionPerHundredGrams(aNutritionalInformation().withVitamins(
                        asList(aNewVitaminAmount().withVitamin(a).withAmount(10L).build())).build()).build()));

        Food pear = database.inTransaction(() ->
                foodDao.save(aNewFood().withName("Pear")
                        .withNutritionPerHundredGrams(aNutritionalInformation().withVitamins(
                                asList(aNewVitaminAmount().withVitamin(aVitamin().withName(VitaminName.C).build()).build())).build()).build()));

        List<Food> actual = foodDao.findByVitamin(VitaminName.A);

        assertThat(actual).containsExactly(apple, plum);
        assertThat(actual).doesNotContain(pear);
    }
}