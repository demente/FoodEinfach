package my.superfood.resources;

import io.dropwizard.hibernate.UnitOfWork;
import my.superfood.dao.FoodDao;
import my.superfood.dto.FoodDto;
import my.superfood.mapper.FoodMapper;
import my.superfood.model.Food;
import my.superfood.model.enums.MineralName;
import my.superfood.model.enums.VitaminName;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/food")
public class FoodResource {

    private final FoodDao foodDao;
    private final FoodMapper foodMapper;

    public FoodResource(FoodDao dao, FoodMapper foodMapper) {
        this.foodDao = dao;
        this.foodMapper = foodMapper;
    }

    @POST
    @UnitOfWork
    public Long saveFood(FoodDto food) {
        Food persistedFood = foodDao.save(foodMapper.toFood(food));
        return persistedFood.getId();
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void deleteFood(@PathParam("id") Long id) {
        foodDao.delete(id);
    }

    @GET
    @UnitOfWork
    @Path("/{id}")
    public FoodDto findById(@PathParam("id") Long id) {
        return foodMapper.toFoodDto(foodDao.findById(id));
    }

    @GET
    @UnitOfWork
    public List<FoodDto> findByCriteria(@QueryParam("name") String name) {
        if (name != null) {
            return foodMapper.toFoodDtoList(foodDao.findByName(name));
        }
        return foodMapper.toFoodDtoList(foodDao.findAll());
    }

    @GET
    @UnitOfWork
    @Path("/mineral/{name}")
    public List<FoodDto> findByMineral(@PathParam("name") MineralName name) {
        return foodMapper.toFoodDtoList(foodDao.findByMineral(name));
    }

    @GET
    @UnitOfWork
    @Path("/vitamin/{name}")
    public List<FoodDto> findByVitamin(@PathParam("name") VitaminName name) {
        return foodMapper.toFoodDtoList(foodDao.findByVitamin(name));
    }
}
