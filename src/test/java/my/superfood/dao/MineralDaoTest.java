package my.superfood.dao;

import io.dropwizard.testing.junit.DAOTestRule;
import my.superfood.model.Mineral;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static my.superfood.model.MineralBuilder.aMineral;
import static my.superfood.model.enums.MineralName.Ca;
import static my.superfood.model.enums.MineralName.Fe;
import static org.assertj.core.api.Assertions.assertThat;

public class MineralDaoTest {

    @Rule
    public DAOTestRule database = DAOTestRule.newBuilder()
            .addEntityClass(Mineral.class)
            .build();

    private MineralDao mineralDao;

    @Before
    public void setUp() {
        mineralDao = new MineralDao(database.getSessionFactory());
    }

    @Test
    public void savesMineral() {
        Mineral mineral = database.inTransaction(() -> mineralDao.save(aMineral().build()));

        assertThat(mineral.getName()).isNotNull();
    }

    @Test
    public void findsAll() {
        Mineral calcium = database.inTransaction(() -> mineralDao.save(aMineral().withName(Ca).build()));
        Mineral iron = database.inTransaction(() -> mineralDao.save(aMineral().withName(Fe).build()));

        List<Mineral> actual = mineralDao.findAll();

        assertThat(actual).containsExactly(calcium, iron);
    }

}