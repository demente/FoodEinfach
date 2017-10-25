package my.superfood.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;
import my.superfood.api.RecipeRepresentation;
import my.superfood.dao.RecipeDao;
import my.superfood.mapper.RecipeMapper;
import my.superfood.model.Recipe;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/recipes")
public class RecipeResource {

	private RecipeDao recipeDao;

	public RecipeResource(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
	}

	@POST
	@UnitOfWork
	public Long save(RecipeRepresentation recipe) {
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
	public RecipeRepresentation findById(@PathParam("id") Long id) {
		return RecipeMapper.INSTANCE.toRecipeRepresentation(recipeDao.findById(id));
	}

}
