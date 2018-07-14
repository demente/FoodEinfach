package my.superfood.resources;

import io.dropwizard.testing.junit.ResourceTestRule;
import my.superfood.dao.RecipeDao;
import my.superfood.dto.RecipeDto;
import my.superfood.mapper.RecipeMapper;
import my.superfood.model.Recipe;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static java.util.Arrays.asList;
import static my.superfood.assertions.DtoAssertions.assertEqualRecipeDto;
import static my.superfood.dto.RecipeDtoBuilder.aRecipeDto;
import static my.superfood.model.RecipeBuilder.aRecipe;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
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

        assertEqualRecipeDto(recipeDtoArgumentCaptor.getValue(), expected);
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

        assertEqualRecipeDto(actual, expected);
    }


    @Test
    public void findsAll() {
        resources.target("/recipes").request().get(new GenericType<List<RecipeDto>>() {
        });

        then(recipeDao).should().findAll();
    }

    @Test
    public void mapsFoundRecipesToDtoList() {
        List<Recipe> expected = asList(aRecipe().build());
        given(recipeDao.findAll()).willReturn(expected);

        resources.target("/recipes").request().get(new GenericType<List<RecipeDto>>() {
        });

        then(recipeMapper).should().toRecipeDtoList(expected);

    }

    @Test
    public void returnsFoundRecipes() {
        RecipeDto expected = aRecipeDto().build();
        given(recipeMapper.toRecipeDtoList(anyList())).willReturn(asList(expected));

        List<RecipeDto> actual = resources.target("/recipes").request().get(new GenericType<List<RecipeDto>>() {
        });

        assertEqualRecipeDto(actual.get(0), expected);
    }
}