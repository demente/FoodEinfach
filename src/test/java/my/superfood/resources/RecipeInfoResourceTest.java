package my.superfood.resources;

import io.dropwizard.testing.junit.ResourceTestRule;
import my.superfood.dao.RecipeDao;
import my.superfood.dto.FoodInfoDto;
import my.superfood.dto.RecipeInfoDto;
import my.superfood.mapper.RecipeMapper;
import my.superfood.model.Recipe;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static java.util.Arrays.asList;
import static my.superfood.dto.RecipeInfoDtoBuilder.aRecipeInfoDto;
import static my.superfood.model.RecipeBuilder.aRecipe;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;

public class RecipeInfoResourceTest {

    private static final RecipeDao recipeDao = mock(RecipeDao.class);
    private static final RecipeMapper recipeMapper = mock(RecipeMapper.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new RecipeInfoResource(recipeDao, recipeMapper))
            .build();

    @Before
    public void setup() {
        reset(recipeDao);
        reset(recipeMapper);

        given(recipeMapper.toRecipeInfoDto(any(Recipe.class))).willReturn(aRecipeInfoDto().build());
        given(recipeMapper.toRecipeInfoDtoList(anyList())).willReturn(asList(aRecipeInfoDto().build()));
    }

    @Test
    public void findsAll() {
        resources.target("/recipeinfo").request().get(new GenericType<List<RecipeInfoDto>>() {
        });

        then(recipeDao).should().findAll();
    }

    @Test
    public void mapsFoundRecipesToRecipeInfoDtoList() {
        List<Recipe> expected = asList(aRecipe().build());
        given(recipeDao.findAll()).willReturn(expected);

        resources.target("/recipeinfo").request().get(new GenericType<List<RecipeInfoDto>>() {
        });

        then(recipeMapper).should().toRecipeInfoDtoList(expected);
    }

    @Test
    public void returnsMappedRecipeInfoDto() {
        RecipeInfoDto expected = aRecipeInfoDto().build();
        given(recipeMapper.toRecipeInfoDtoList(anyList())).willReturn(asList(expected));

        List<RecipeInfoDto> actual = resources.target("/recipeinfo").request().get(new GenericType<List<RecipeInfoDto>>() {
        });

        assertThat(actual).extracting(RecipeInfoDto::getId).containsExactly(expected.getId());
        assertThat(actual).extracting(RecipeInfoDto::getName).containsExactly(expected.getName());
        assertThat(actual).extracting(RecipeInfoDto::getType).containsExactly(expected.getType());
    }

}