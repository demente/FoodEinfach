package my.superfood.resources;

import io.dropwizard.hibernate.UnitOfWork;
import my.superfood.dao.FoodDao;
import my.superfood.dto.FoodInfoDto;
import my.superfood.mapper.FoodMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/foodinfo")
public class FoodInfoResource {

    private final FoodDao foodDao;
    private final FoodMapper foodMapper;

    public FoodInfoResource(FoodDao dao, FoodMapper foodMapper) {
        this.foodDao = dao;
        this.foodMapper = foodMapper;
    }

    @GET
    @UnitOfWork
    public List<FoodInfoDto> findAll() {
        return foodMapper.toFoodInfoDtoList(foodDao.findAll());
    }
}
