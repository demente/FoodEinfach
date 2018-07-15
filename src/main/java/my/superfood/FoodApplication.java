package my.superfood;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import my.superfood.dao.FoodDao;
import my.superfood.dao.MealPlanDao;
import my.superfood.dao.MineralDao;
import my.superfood.dao.RecipeDao;
import my.superfood.healthchecks.DatabaseConnectionHealthCheck;
import my.superfood.mapper.FoodMapper;
import my.superfood.mapper.MealPlanMapper;
import my.superfood.mapper.MineralMapper;
import my.superfood.mapper.RecipeMapper;
import my.superfood.model.*;
import my.superfood.resources.*;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class FoodApplication extends Application<FoodConfiguration> {

    private final HibernateBundle<FoodConfiguration> hibernateBundle = new HibernateBundle<FoodConfiguration>(
            Food.class, MineralAmount.class, VitaminAmount.class, Ingredient.class, Recipe.class,
            Vitamin.class, Mineral.class, FoodInMealPlan.class,
            RecipeInMealPlan.class, MealPlan.class) {
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
    public void run(FoodConfiguration conf, Environment environment) {
        configureCors(environment);

        final FoodDao foodDao = new FoodDao(hibernateBundle.getSessionFactory());
        RecipeDao recipeDao = new RecipeDao(hibernateBundle.getSessionFactory());
        MineralDao mineralDao = new MineralDao(hibernateBundle.getSessionFactory());
        MealPlanDao mealPlanDao = new MealPlanDao(hibernateBundle.getSessionFactory());
        environment.jersey().register(new FoodResource(foodDao, FoodMapper.INSTANCE));
        environment.jersey().register(new FoodInfoResource(foodDao, FoodMapper.INSTANCE));
        environment.jersey().register(new RecipeResource(recipeDao, RecipeMapper.INSTANCE));
        environment.jersey().register(new MineralResource(mineralDao, MineralMapper.INSTANCE));
        environment.jersey().register(new MealPlanResource(mealPlanDao, MealPlanMapper.INSTANCE));

        environment.healthChecks().register("database", new DatabaseConnectionHealthCheck(null));

    }

    private void configureCors(Environment environment) {
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin,Authorization");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

    }

}
