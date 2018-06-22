package my.superfood.mapper;

import my.superfood.dto.FoodDto;
import my.superfood.dto.FoodShortRepresentation;
import my.superfood.model.Food;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {MineralMapper.class, VitaminMapper.class, NutritionalInformationMapper.class})
public interface FoodMapper {

    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    @Mappings({@Mapping(source = "nutritionPerHundredGrams.protein", target = "protein"),
            @Mapping(source = "nutritionPerHundredGrams.fat", target = "fat"),
            @Mapping(source = "nutritionPerHundredGrams.carbohydrates", target = "carbohydrates"),
            @Mapping(source = "nutritionPerHundredGrams.fiber", target = "fiber"),
            @Mapping(source = "nutritionPerHundredGrams.calories", target = "calories"),
            @Mapping(source = "nutritionPerHundredGrams.vitamins", target = "vitamins"),
            @Mapping(source = "nutritionPerHundredGrams.minerals", target = "minerals")})
    FoodDto toFoodRepresentation(Food food);

    FoodShortRepresentation toFoodShortRepresentation(Food food);

    @Mappings({@Mapping(source = "protein", target = "nutritionPerHundredGrams.protein"),
            @Mapping(source = "fat", target = "nutritionPerHundredGrams.fat"),
            @Mapping(source = "carbohydrates", target = "nutritionPerHundredGrams.carbohydrates"),
            @Mapping(source = "fiber", target = "nutritionPerHundredGrams.fiber"),
            @Mapping(source = "calories", target = "nutritionPerHundredGrams.calories"),
            @Mapping(source = "vitamins", target = "nutritionPerHundredGrams.vitamins"),
            @Mapping(source = "minerals", target = "nutritionPerHundredGrams.minerals")})
    Food toFood(FoodDto food);

    Food toFood(FoodShortRepresentation food);

    List<FoodDto> toFoodRepresentationList(List<Food> food);

    List<Food> toFoodList(List<FoodDto> foodDto);

    List<FoodShortRepresentation> toFoodShortRepresentationList(List<Food> food);
}
