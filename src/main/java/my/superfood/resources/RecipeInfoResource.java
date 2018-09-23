package my.superfood.resources;

import io.dropwizard.hibernate.UnitOfWork;
import my.superfood.dao.RecipeDao;
import my.superfood.dto.RecipeInfoDto;
import my.superfood.mapper.RecipeMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/recipeinfo")
public class RecipeInfoResource {

    private final RecipeDao recipeDao;
    private final RecipeMapper recipeMapper;

    public RecipeInfoResource(RecipeDao recipeDao, RecipeMapper recipeMapper) {
        this.recipeDao = recipeDao;
        this.recipeMapper = recipeMapper;
    }


    @GET
    @UnitOfWork
    public List<RecipeInfoDto> findAll() {
        return recipeMapper.toRecipeInfoDtoList(recipeDao.findAll());
    }
}
