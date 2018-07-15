package my.superfood.resources;

import io.dropwizard.hibernate.UnitOfWork;
import my.superfood.dao.MealPlanDao;
import my.superfood.dto.MealPlanDto;
import my.superfood.mapper.MealPlanMapper;
import my.superfood.model.MealPlan;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/mealplan")
public class MealPlanResource {

    private final MealPlanDao mealPlanDao;
    private final MealPlanMapper mealPlanMapper;

    public MealPlanResource(MealPlanDao mealPlanDao, MealPlanMapper mealPlanMapper) {
        this.mealPlanDao = mealPlanDao;
        this.mealPlanMapper = mealPlanMapper;
    }

    @POST
    @UnitOfWork
    public Long saveMealPlan(MealPlanDto food) {
        MealPlan persistedMealPlan = mealPlanDao.save(mealPlanMapper.toMealPlan(food));
        return persistedMealPlan.getId();
    }

    @DELETE
    @Path("/{id}")
    public void deleteMealPlan(@PathParam("id") Long id) {
        mealPlanDao.delete(id);
    }

    @GET
    @UnitOfWork
    @Path("/{id}")
    public MealPlanDto findById(@PathParam("id") Long id) {
        return mealPlanMapper.toMealPlanDto(mealPlanDao.findById(id));
    }

}


