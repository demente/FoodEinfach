package my.superfood.resources;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.testing.junit.ResourceTestRule;
import my.superfood.assertions.DtoAssertions;
import my.superfood.dao.RecipeDao;
import my.superfood.dto.FoodDto;
import my.superfood.dto.RecipeDto;
import my.superfood.mapper.RecipeMapper;
import my.superfood.model.Recipe;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import static my.superfood.dto.FoodDtoBuilder.aFoodDto;
import static my.superfood.dto.RecipeDtoBuilder.aRecipeDto;
import static my.superfood.model.RecipeBuilder.aRecipe;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;

public class RecipeResourceTest {

    private static final RecipeDao recipeDao = mock(RecipeDao.class);
    private static final RecipeMapper recipeMapper = mock(RecipeMapper.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new RecipeResource(recipeDao, recipeMapper))
            .build();

    @Before
    public void setup() {
        reset(recipeDao);
        reset(recipeMapper);

        given(recipeDao.save(any(Recipe.class))).willReturn(aRecipe().build());
        given(recipeDao.findById(anyLong())).willReturn(aRecipe().build());
        given(recipeMapper.toRecipe(any(RecipeDto.class))).willReturn(aRecipe().build());
    }

    @Test
    public void savesRecipe() {
        Recipe expected = aRecipe().build();
        given(recipeMapper.toRecipe(any(RecipeDto.class))).willReturn(expected);

        resources.target("/recipes").request().post(Entity.json(aRecipeDto().build()));

        then(recipeDao).should().save(expected);
    }

    @Test
    public void mapsRecipeDtoToRecipe() {
        RecipeDto expected = aRecipeDto().build();

        resources.target("/recipes").request().post(Entity.json(expected));

        ArgumentCaptor<RecipeDto> recipeDtoArgumentCaptor = ArgumentCaptor.forClass(RecipeDto.class);

        then(recipeMapper).should().toRecipe(recipeDtoArgumentCaptor.capture());

        DtoAssertions.assertEqualRecipeDto(recipeDtoArgumentCaptor.getValue(), expected);
    }

    @Test
    public void returnsSavedRecipeId() {
        Recipe expected = aRecipe().withId(3L).build();
        given(recipeDao.save(any(Recipe.class))).willReturn(expected);

        Response response = resources.target("/recipes").request().post(Entity.json(aRecipeDto().build()));

        assertThat(response.readEntity(Long.class)).isEqualTo(expected.getId());
    }

    @Test
    public void deletesById() {
        resources.target("/recipes/2").request().delete();

        then(recipeDao).should().delete(2L);
    }

    @Test
    public void findsById() {
        resources.target("/recipes/1").request().get(RecipeDto.class);

        then(recipeDao).should().findById(1L);
    }

    @Test
    public void mapsFoundRecipeToRecipeDto() {
        Recipe expected = aRecipe().build();
        given(recipeDao.findById(anyLong())).willReturn(expected);

        resources.target("/recipes/1").request().get(RecipeDto.class);

        then(recipeMapper).should().toRecipeDto(expected);
    }

    @Test
    public void returnsFoundRecipeDto() {
        RecipeDto expected = aRecipeDto().build();
        given(recipeMapper.toRecipeDto(any(Recipe.class))).willReturn(expected);

        RecipeDto actual = resources.target("/recipes/1").request().get(RecipeDto.class);

        DtoAssertions.assertEqualRecipeDto(actual, expected);
    }

}