package my.superfood.mapper;

import my.superfood.dto.IngredientDto;
import my.superfood.model.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {FoodMapper.class})
public interface IngredientMapper {

    @Mapping(target = "foodId", source = "food.id")
    IngredientDto toIngredientDto(Ingredient ingredient);

    @Mapping(target = "food.id", source = "foodId")
    Ingredient toIngredient(IngredientDto ingredientDto);


}
