package my.superfood.mapper;

import my.superfood.dto.IngredientRepresentation;
import my.superfood.model.Ingredient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {FoodMapper.class})
public interface IngredientMapper {

    Ingredient toIngredient(IngredientRepresentation ingredient);

    IngredientRepresentation toIngredientRepresentation(Ingredient ingredient);

    List<IngredientRepresentation> toIngredientRepresentationList(List<Ingredient> ingredients);

    List<Ingredient> toIngredientList(List<IngredientRepresentation> ingredients);
}
