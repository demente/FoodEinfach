package my.superfood.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;
import my.superfood.api.FoodRepresentation;
import my.superfood.dao.FoodDao;
import my.superfood.mapper.FoodMapper;
import my.superfood.model.Food;

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

	@GET
	@UnitOfWork
	public FoodRepresentation getFood(@QueryParam("id") Long id) {
		return FoodMapper.INSTANCE.toFoodRepresentation(foodDao.findById(id));
	}

}
