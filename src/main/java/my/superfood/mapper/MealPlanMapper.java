package my.superfood.mapper;

import my.superfood.dto.MealPlanDto;
import my.superfood.model.MealPlan;
import org.mapstruct.Mapper;

@Mapper(uses = {MealPlanRecipeMapper.class, MealPlanFoodMapper.class})
public interface MealPlanMapper {

    MealPlan toMealPlan(MealPlanDto mealPlanDto);

    MealPlanDto toMealPlanDto(MealPlan mealPlan);
}
