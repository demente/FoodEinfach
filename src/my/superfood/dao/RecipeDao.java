package my.superfood.dao;

import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;
import my.superfood.model.Recipe;

public class RecipeDao extends AbstractDAO<Recipe> {

	public RecipeDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public Recipe findById(Long id) {
		return get(id);
	}

	public Recipe save(Recipe recipe) {
		return persist(recipe);
	}

}
