package my.superfood.dao;

import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;
import my.superfood.model.Food;

public class FoodDao extends AbstractDAO<Food> {

	public FoodDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public Food findById(Long id) {
		return get(id);
	}

	public void save(Food food) {
		persist(food);
	}

}
