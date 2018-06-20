package my.superfood.resources;

import io.dropwizard.hibernate.UnitOfWork;
import my.superfood.api.FoodRepresentation;
import my.superfood.api.FoodShortRepresentation;
import my.superfood.dao.FoodDao;
import my.superfood.mapper.FoodMapper;
import my.superfood.model.Food;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/food")
public class FoodResource {

    private final FoodDao foodDao;

    public FoodResource(FoodDao dao) {
        this.foodDao = dao;
    }

    @POST
    @UnitOfWork
    public Long saveFood(FoodRepresentation food) {
        Food persistedFood = foodDao.save(FoodMapper.INSTANCE.toFood(food));
        return persistedFood.getId();
    }

    @DELETE
    public void deleteFood(Long id) {
        foodDao.delete(id);
    }

    @GET
    @UnitOfWork
    @Path("/{id}")
    public FoodRepresentation findById(@PathParam("id") Long id) {
        return FoodMapper.INSTANCE.toFoodRepresentation(foodDao.findById(id));
    }

    @GET
    @UnitOfWork
    public List<FoodShortRepresentation> findByName(@QueryParam("name") String name) {
        return FoodMapper.INSTANCE.toFoodShortRepresentationList(foodDao.findByName(name));
    }
}
