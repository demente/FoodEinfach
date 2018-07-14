package my.superfood.dao;

import io.dropwizard.hibernate.AbstractDAO;
import my.superfood.model.Recipe;
import org.hibernate.SessionFactory;

import java.util.List;

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

    public void delete(Long id) {
        currentSession().delete(get(id));
    }

    public List<Recipe> findAll() {
        return list(currentSession().createNamedQuery("allRecipes", Recipe.class));
    }
}
