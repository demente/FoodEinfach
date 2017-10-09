package my.superfood;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import my.superfood.dao.FoodDao;
import my.superfood.dao.RecipeDao;
import my.superfood.healthchecks.DatabaseConnectionHealthCheck;
import my.superfood.model.Food;
import my.superfood.model.Ingredient;
import my.superfood.model.MineralAmount;
import my.superfood.model.Recipe;
import my.superfood.model.VitaminAmount;
import my.superfood.resources.FoodResource;
import my.superfood.resources.RecipeResource;

public class FoodApplication extends Application<FoodConfiguration> {

	private final HibernateBundle<FoodConfiguration> hibernateBundle = new HibernateBundle<FoodConfiguration>(
			Food.class, MineralAmount.class, VitaminAmount.class, Ingredient.class, Recipe.class) {
		public DataSourceFactory getDataSourceFactory(FoodConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}
	};

	public static void main(String[] args) throws Exception {
		new FoodApplication().run(args);
	}

	@Override
	public void initialize(Bootstrap<FoodConfiguration> bootstrap) {
		super.initialize(bootstrap);
		bootstrap.addBundle(hibernateBundle);
	}

	@Override
	public void run(FoodConfiguration conf, Environment environment) throws Exception {

		final FoodDao foodDao = new FoodDao(hibernateBundle.getSessionFactory());
		RecipeDao recipeDao = new RecipeDao(hibernateBundle.getSessionFactory());
		environment.jersey().register(new FoodResource(foodDao));
		environment.jersey().register(new RecipeResource(recipeDao));

		environment.healthChecks().register("database", new DatabaseConnectionHealthCheck(null));

	}

}
