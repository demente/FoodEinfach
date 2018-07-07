package my.superfood.dao;

import io.dropwizard.hibernate.AbstractDAO;
import my.superfood.model.Mineral;
import org.hibernate.SessionFactory;

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
}
