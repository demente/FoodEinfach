package my.superfood.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import my.superfood.api.FoodRepresentation;
import my.superfood.model.Food;

@Mapper(uses = { MineralMapper.class, VitaminMapper.class })
public interface FoodMapper {

	FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

	@Mappings({ @Mapping(source = "nutritionPerHundredGrams.protein", target = "protein"),
			@Mapping(source = "nutritionPerHundredGrams.fat", target = "fat"),
			@Mapping(source = "nutritionPerHundredGrams.carbohydrates", target = "carbohydrates"),
			@Mapping(source = "nutritionPerHundredGrams.fiber", target = "fiber"),
			@Mapping(source = "nutritionPerHundredGrams.vitamins", target = "vitamins"),
			@Mapping(source = "nutritionPerHundredGrams.minerals", target = "minerals") })
	FoodRepresentation toFoodRepresentation(Food food);

	@Mappings({ @Mapping(source = "protein", target = "nutritionPerHundredGrams.protein"),
			@Mapping(source = "fat", target = "nutritionPerHundredGrams.fat"),
			@Mapping(source = "carbohydrates", target = "nutritionPerHundredGrams.carbohydrates"),
			@Mapping(source = "fiber", target = "nutritionPerHundredGrams.fiber"),
			@Mapping(source = "vitamins", target = "nutritionPerHundredGrams.vitamins"),
			@Mapping(source = "minerals", target = "nutritionPerHundredGrams.minerals") })
	Food toFood(FoodRepresentation food);
}
