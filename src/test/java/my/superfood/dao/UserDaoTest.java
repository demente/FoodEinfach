package my.superfood.dao;

import io.dropwizard.testing.junit.DAOTestRule;
import my.superfood.model.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static my.superfood.model.UserBuilder.aNewUser;
import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoTest {

    @Rule
    public DAOTestRule database = DAOTestRule.newBuilder()
            .addEntityClass(User.class)
            .build();

    private UserDao userDao;

    @Before
    public void setUp() {
        userDao = new UserDao(database.getSessionFactory());
    }

    @Test
    public void savesUser() {
        User user = database.inTransaction(() -> userDao.save(aNewUser().build()));

        assertThat(user.getId()).isNotNull();
    }

    @Test
    public void findsUserByName() {
        User expected = database.inTransaction(() -> userDao.save(aNewUser().build()));

        User actual = userDao.findByName(expected.getName());

        assertThat(actual).isSameAs(expected);
    }
}