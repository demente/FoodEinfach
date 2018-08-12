package my.superfood;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import my.superfood.dao.*;
import my.superfood.healthchecks.DatabaseConnectionHealthCheck;
import my.superfood.mapper.*;
import my.superfood.model.*;
import my.superfood.resolver.MineralResolver;
import my.superfood.resolver.VitaminResolver;
import my.superfood.resources.*;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.text.SimpleDateFormat;
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
        configureDateFormat(environment);

        final FoodDao foodDao = new FoodDao(hibernateBundle.getSessionFactory());
        RecipeDao recipeDao = new RecipeDao(hibernateBundle.getSessionFactory());
        MineralDao mineralDao = new MineralDao(hibernateBundle.getSessionFactory());
        MealPlanDao mealPlanDao = new MealPlanDao(hibernateBundle.getSessionFactory());
        VitaminDao vitaminDao = new VitaminDao(hibernateBundle.getSessionFactory());

        VitaminResolver vitaminResolver = new VitaminResolver(vitaminDao);
        MineralResolver mineralResolver = new MineralResolver(mineralDao);

        WeightMapper weightMapper = new WeightMapper();
        VitaminMapper vitaminMapper = new VitaminMapper(vitaminResolver, weightMapper);
        MineralMapper mineralMapper = new MineralMapper(mineralResolver, weightMapper);
        NutritionalInformationMapper nutritionalInformationMapper = new NutritionalInformationMapper(vitaminMapper, mineralMapper, weightMapper);
        FoodMapper foodMapper = new FoodMapper(nutritionalInformationMapper, weightMapper);
        IngredientMapper ingredientMapper = new IngredientMapper(foodMapper);
        RecipeMapper recipeMapper = new RecipeMapper(ingredientMapper);
        MealPlanRecipeMapper mealPlanRecipeMapper = new MealPlanRecipeMapper(recipeMapper);
        MealPlanFoodMapper mealPlanFoodMapper = new MealPlanFoodMapper(foodMapper);
        MealPlanMapper mealPlanMapper = new MealPlanMapper(mealPlanRecipeMapper, mealPlanFoodMapper);

        environment.jersey().register(new FoodResource(foodDao, foodMapper));
        environment.jersey().register(new FoodInfoResource(foodDao, foodMapper));
        environment.jersey().register(new RecipeResource(recipeDao, recipeMapper));
        environment.jersey().register(new MineralResource(mineralDao, mineralMapper));
        environment.jersey().register(new MealPlanResource(mealPlanDao, mealPlanMapper));
        environment.jersey().register(new VitaminResource(vitaminDao, vitaminMapper));

        environment.healthChecks().register("database", new DatabaseConnectionHealthCheck(null));

    }

    private void configureDateFormat(Environment environment) {
        environment.getObjectMapper().setDateFormat(new SimpleDateFormat());
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
