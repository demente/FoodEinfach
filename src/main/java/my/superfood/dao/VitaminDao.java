package my.superfood.dao;

import io.dropwizard.hibernate.AbstractDAO;
import my.superfood.model.Food;
import my.superfood.model.Vitamin;
import org.hibernate.SessionFactory;

import java.util.List;

public class VitaminDao extends AbstractDAO<Vitamin> {

    public VitaminDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Vitamin save(Vitamin vitamin) {
        return persist(vitamin);
    }

    public List<Vitamin> findAll() {
        return list(currentSession().createNamedQuery("allVitamins", Vitamin.class));
    }
}
