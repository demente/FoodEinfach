package my.superfood.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import my.superfood.dao.RecipeDao;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/recipe")
public class RecipeResource {

	private RecipeDao recipeDao;

	public RecipeResource(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
	}
}
