package my.superfood.dao;

import io.dropwizard.testing.junit.DAOTestRule;
import my.superfood.model.Vitamin;
import my.superfood.model.enums.VitaminName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static my.superfood.model.VitaminBuilder.aVitamin;
import static my.superfood.model.enums.VitaminName.A;
import static my.superfood.model.enums.VitaminName.B6;
import static org.assertj.core.api.Assertions.assertThat;

public class VitaminDaoTest {

    @Rule
    public DAOTestRule database = DAOTestRule.newBuilder()
            .addEntityClass(Vitamin.class)
            .build();

    private VitaminDao vitaminDao;

    @Before
    public void setUp() {
        vitaminDao = new VitaminDao(database.getSessionFactory());
    }

    @Test
    public void savesVitamin() {
        Vitamin vitamin = database.inTransaction(() -> vitaminDao.save(aVitamin().build()));

        assertThat(vitamin.getName()).isNotNull();
    }

    @Test
    public void findsAll() {
        Vitamin a = database.inTransaction(() -> vitaminDao.save(aVitamin().withName(A).build()));
        Vitamin b6 = database.inTransaction(() -> vitaminDao.save(aVitamin().withName(B6).build()));

        List<Vitamin> actual = vitaminDao.findAll();

        assertThat(actual).containsExactly(a, b6);
    }

    @Test
    public void findsByName() {
        Vitamin a = database.inTransaction(() -> vitaminDao.save(aVitamin().withName(A).build()));

        Vitamin actual = vitaminDao.findByName(VitaminName.A);

        assertThat(actual).isEqualTo(a);
    }

}