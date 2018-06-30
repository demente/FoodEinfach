package my.superfood.mapper;

import my.superfood.dto.IngredientDto;
import my.superfood.model.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {FoodMapper.class, WeightMapper.class})
public interface IngredientMapper {

    @Mapping(target = "foodId", source = "food.id")
    IngredientDto toIngredientDto(Ingredient ingredient);

    List<IngredientDto> toIngredientDtoList(List<Ingredient> ingredientList);

    @Mapping(target = "food.id", source = "foodId")
    Ingredient toIngredient(IngredientDto ingredientDto);

    List<Ingredient> toIngredientList(List<IngredientDto> ingredientDtoList);
}
