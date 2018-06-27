package my.superfood.mapper;

import my.superfood.dto.FoodDto;
import my.superfood.model.Food;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {NutritionalInformationMapper.class})
public interface FoodMapper {

    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    @Mappings({@Mapping(source = "nutritionPerHundredGrams", target = "nutritionalInformation"),
            @Mapping(source = "weightPerServing", target = "weightPerServing.weight"),
            @Mapping(source = "weightPerServingUnit", target = "weightPerServing.unit")
    })
    FoodDto toFoodDto(Food food);

    @Mappings({@Mapping(source = "nutritionalInformation", target = "nutritionPerHundredGrams"),
            @Mapping(source = "weightPerServing.weight", target = "weightPerServing"),
            @Mapping(source = "weightPerServing.unit", target = "weightPerServingUnit")
    })
    Food toFood(FoodDto food);

    List<FoodDto> toFoodDtoList(List<Food> food);

    List<Food> toFoodList(List<FoodDto> foodDto);
}
