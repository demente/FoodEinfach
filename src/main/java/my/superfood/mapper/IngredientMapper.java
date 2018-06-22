package my.superfood.mapper;

import my.superfood.dto.IngredientDto;
import my.superfood.model.Ingredient;
import org.mapstruct.Mapper;

@Mapper(uses = {FoodMapper.class})
public interface IngredientMapper {

    IngredientDto toIngredientDto(Ingredient ingredient);

    Ingredient toIngredient(IngredientDto ingredientDto);



}
