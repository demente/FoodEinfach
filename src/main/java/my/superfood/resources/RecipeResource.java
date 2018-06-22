package my.superfood.resources;

import io.dropwizard.hibernate.UnitOfWork;
import my.superfood.dto.RecipeDto;
import my.superfood.dao.RecipeDao;
import my.superfood.mapper.RecipeMapper;
import my.superfood.model.Recipe;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/recipes")
public class RecipeResource {

    private final RecipeDao recipeDao;

    public RecipeResource(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    @POST
    @UnitOfWork
    public Long save(RecipeDto recipe) {
        Recipe persistedRecipe = recipeDao.save(RecipeMapper.INSTANCE.toRecipe(recipe));
        return persistedRecipe.getId();
    }

    @DELETE
    public void delete(Long id) {
        recipeDao.delete(id);
    }

    @GET
    @UnitOfWork
    @Path("/{id}")
    public RecipeDto findById(@PathParam("id") Long id) {
        return RecipeMapper.INSTANCE.toRecipeDto(recipeDao.findById(id));
    }

}
