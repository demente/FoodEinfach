package my.superfood.resources;

import io.dropwizard.hibernate.UnitOfWork;
import my.superfood.dao.FoodDao;
import my.superfood.dto.FoodDto;
import my.superfood.dto.FoodInfoDto;
import my.superfood.mapper.FoodMapper;
import my.superfood.model.Food;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/foodinfo")
public class FoodInfoResource {

    private final FoodDao foodDao;

    public FoodInfoResource(FoodDao dao) {
        this.foodDao = dao;
    }

    @GET
    @UnitOfWork
    public List<FoodInfoDto> findAll() {
        return FoodMapper.INSTANCE.toFoodInfoDtoList(foodDao.findAll());
    }
}
