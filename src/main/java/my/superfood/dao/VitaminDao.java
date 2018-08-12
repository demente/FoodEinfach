package my.superfood.dao;

import io.dropwizard.hibernate.AbstractDAO;
import my.superfood.model.Vitamin;
import my.superfood.model.enums.VitaminName;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

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

    public Vitamin findByName(VitaminName name) {
        Query<Vitamin> query = currentSession().createNamedQuery("vitaminByName", Vitamin.class);
        query.setParameter("name", name);
        return uniqueResult(query);
    }
}
