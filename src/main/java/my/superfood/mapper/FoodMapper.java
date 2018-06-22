package my.superfood.mapper;

import my.superfood.dto.FoodDto;
import my.superfood.model.Food;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {NutritionalInformationMapper.class, WeightMapper.class})
public interface FoodMapper {

    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    @Mappings({@Mapping(source = "nutritionPerHundredGrams", target = "nutritionalInformation")})
    FoodDto toFoodDto(Food food);

    @Mappings({@Mapping(source = "nutritionalInformation", target = "nutritionPerHundredGrams")})
    Food toFood(FoodDto food);

    List<FoodDto> toFoodDtoList(List<Food> food);

    List<Food> toFoodList(List<FoodDto> foodDto);
}
