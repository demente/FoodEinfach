package my.superfood.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import my.superfood.api.RecipeRepresentation;
import my.superfood.model.Recipe;

@Mapper(uses = { IngredientMapper.class })
public interface RecipeMapper {

	RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

	Recipe toRecipe(RecipeRepresentation recipe);

	RecipeRepresentation toRecipeRepresentation(Recipe recipe);

}
