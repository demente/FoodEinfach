package my.superfood.dao;

import io.dropwizard.hibernate.AbstractDAO;
import my.superfood.model.MealPlan;
import org.hibernate.SessionFactory;

public class MealPlanDao extends AbstractDAO<MealPlan> {

    public MealPlanDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public MealPlan save(MealPlan mealPlan) {
        return persist(mealPlan);
    }

    public MealPlan findById(Long id) {
        return get(id);
    }

    public void delete(Long id) {
        currentSession().delete(get(id));
    }
}
