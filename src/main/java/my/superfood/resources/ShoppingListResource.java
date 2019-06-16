package my.superfood.resources;


import io.dropwizard.hibernate.UnitOfWork;
import my.superfood.dao.MealPlanDao;
import my.superfood.dto.ShoppingListElement;
import my.superfood.service.ShoppingListGenerator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/shoppinglist")
public class ShoppingListResource {

    private final MealPlanDao mealPlanDao;

    private final ShoppingListGenerator shoppingListGenerator;

    public ShoppingListResource(MealPlanDao mealPlanDao, ShoppingListGenerator shoppingListGenerator) {
        this.mealPlanDao = mealPlanDao;
        this.shoppingListGenerator = shoppingListGenerator;
    }

    @GET
    @UnitOfWork
    @Path("/{id}")
    public List<ShoppingListElement> generateShoppingList(@PathParam("id") Long id) {
        return shoppingListGenerator.generateShoppingList(mealPlanDao.findById(id));
    }
}
