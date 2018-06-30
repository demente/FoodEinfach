package my.superfood.dao;

import io.dropwizard.hibernate.AbstractDAO;
import my.superfood.model.Food;
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

    public List<Food> findByRecipeId(Long recipeId) {
        Query<Food> query = currentSession().createNamedQuery("foodByRecipeId", Food.class);
        query.setParameter("recipeId", recipeId);
        return list(query);
    }

    public List<Food> findByName(String name) {
        Query<Food> query = currentSession().createNamedQuery("foodByName", Food.class);
        query.setParameter("name", name);
        return list(query);
    }

}
