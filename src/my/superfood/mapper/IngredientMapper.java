package my.superfood.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import my.superfood.api.IngredientRepresentation;
import my.superfood.model.Ingredient;

@Mapper(uses = { FoodMapper.class })
public interface IngredientMapper {

	Ingredient toIngredient(IngredientRepresentation ingredient);

	IngredientRepresentation toIngredientRepresentation(Ingredient ingredient);

	List<IngredientRepresentation> toIngredientRepresentationList(List<Ingredient> ingredients);

	List<Ingredient> toIngredientList(List<IngredientRepresentation> ingredients);
}
