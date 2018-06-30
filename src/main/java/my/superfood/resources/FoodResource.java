package my.superfood.resources;

import io.dropwizard.hibernate.UnitOfWork;
import my.superfood.dao.FoodDao;
import my.superfood.dto.FoodDto;
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
    public Long saveFood(FoodDto food) {
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
    public FoodDto findById(@PathParam("id") Long id) {
        return FoodMapper.INSTANCE.toFoodDto(foodDao.findById(id));
    }

    @GET
    @UnitOfWork
    public List<FoodDto> findByCriteria(@QueryParam("name") String name) {
        if (name != null) {
            return FoodMapper.INSTANCE.toFoodDtoList(foodDao.findByName(name));
        }
        return FoodMapper.INSTANCE.toFoodDtoList(foodDao.findAll());
    }
}
