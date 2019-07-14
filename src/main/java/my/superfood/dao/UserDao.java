package my.superfood.dao;

import io.dropwizard.hibernate.AbstractDAO;
import my.superfood.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class UserDao extends AbstractDAO<User> {
    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public User findByName(String name) {
        Query<User> query = currentSession().createNamedQuery("userByName", User.class);
        query.setParameter("name", name);
        return uniqueResult(query);
    }

    public User save(User user) {
        return persist(user);
    }
}
