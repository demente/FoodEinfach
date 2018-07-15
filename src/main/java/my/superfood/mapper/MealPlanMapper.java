package my.superfood.mapper;

import my.superfood.dto.MealPlanDto;
import my.superfood.model.MealPlan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {MealPlanRecipeMapper.class, MealPlanFoodMapper.class})
public interface MealPlanMapper {

    MealPlanMapper INSTANCE = Mappers.getMapper(MealPlanMapper.class);

    MealPlan toMealPlan(MealPlanDto mealPlanDto);

    MealPlanDto toMealPlanDto(MealPlan mealPlan);
}
