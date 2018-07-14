package my.superfood.mapper;

import my.superfood.dto.RecipeDto;
import my.superfood.model.Ingredient;
import my.superfood.model.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {IngredientMapper.class})
public interface RecipeMapper {

    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    RecipeDto toRecipeDto(Recipe recipe);

    Recipe toRecipe(RecipeDto recipe);

    List<RecipeDto> toRecipeDtoList(List<Recipe> recipeList);
}
