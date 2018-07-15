package my.superfood.mapper;

import my.superfood.dto.MealPlanRecipeDto;
import my.superfood.model.RecipeInMealPlan;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {RecipeMapper.class})
public interface MealPlanRecipeMapper {

    MealPlanRecipeDto toMealPlanRecipeDto(RecipeInMealPlan recipeInMealPlan);

    RecipeInMealPlan toRecipeInMealPlan(MealPlanRecipeDto mealPlanRecipeDto);

    List<RecipeInMealPlan> toRecipeInMealPlanList(List<MealPlanRecipeDto> mealPlanRecipeDtoList);

    List<MealPlanRecipeDto> toMealPlanRecipeDtoList(List<RecipeInMealPlan> recipeInMealPlanList);
}
