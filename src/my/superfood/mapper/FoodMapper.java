package my.superfood.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import my.superfood.api.FoodRepresentation;
import my.superfood.model.Food;

@Mapper
public interface FoodMapper {

	FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

	FoodRepresentation foodToFoodRepresentation(Food food);

	Food foodRepresentationToFood(FoodRepresentation food);
}
