package my.superfood.dao;

import io.dropwizard.hibernate.AbstractDAO;
import my.superfood.model.Food;
import my.superfood.model.enums.MineralName;
import my.superfood.model.enums.VitaminName;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class FoodDao extends AbstractDAO<Food> {

    public FoodDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Food findById(Long id) {
        return get(id);
    }

    public Food save(Food food) {
        return persist(food);
    }

    public List<Food> findAll() {
        return list(currentSession().createNamedQuery("allFood", Food.class));
    }

    public void delete(Long id) {
        currentSession().delete(get(id));
    }

    public List<Food> findByName(String name) {
        Query<Food> query = currentSession().createNamedQuery("foodByName", Food.class);
        query.setParameter("name", name);
        return list(query);
    }

    public List<Food> findByMineral(MineralName mineralName) {
        Query<Food> query = currentSession().createNamedQuery("foodByMineral", Food.class);
        query.setParameter("name", mineralName);
        query.setMaxResults(100);
        return list(query);
    }

    public List<Food> findByVitamin(VitaminName vitaminName) {
        Query<Food> query = currentSession().createNamedQuery("foodByVitamin", Food.class);
        query.setParameter("name", vitaminName);
        query.setMaxResults(100);
        return list(query);
    }
}
