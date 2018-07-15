package my.superfood.mapper;

import my.superfood.dto.IngredientDto;
import my.superfood.model.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(uses = {FoodMapper.class, WeightMapper.class})
public interface IngredientMapper {
    @Mappings({@Mapping(source = "unit", target = "amount.unit"),
            @Mapping(source = "amount", target = "amount.weight")})
    IngredientDto toIngredientDto(Ingredient ingredient);

    List<IngredientDto> toIngredientDtoList(List<Ingredient> ingredientList);

    @Mappings({@Mapping(target = "unit", source = "amount.unit"),
            @Mapping(target = "amount", source = "amount.weight")})
    Ingredient toIngredient(IngredientDto ingredientDto);

    List<Ingredient> toIngredientList(List<IngredientDto> ingredientDtoList);
}
