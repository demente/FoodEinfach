package my.superfood.dao;

import io.dropwizard.hibernate.AbstractDAO;
import my.superfood.model.Mineral;
import my.superfood.model.enums.MineralName;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class MineralDao extends AbstractDAO<Mineral> {


    public MineralDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Mineral save(Mineral mineral) {
        return persist(mineral);
    }

    public List<Mineral> findAll() {
        return list(currentSession().createNamedQuery("allMinerals", Mineral.class));
    }

    public Mineral findByName(MineralName name) {
        Query<Mineral> query = currentSession().createNamedQuery("mineralByName", Mineral.class);
        query.setParameter("name", name);
        return uniqueResult(query);
    }
}
