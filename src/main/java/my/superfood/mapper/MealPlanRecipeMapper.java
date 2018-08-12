package my.superfood.mapper;

import my.superfood.dto.MealPlanRecipeDto;
import my.superfood.model.RecipeInMealPlan;

import java.util.ArrayList;
import java.util.List;

public class MealPlanRecipeMapper {

    private final RecipeMapper recipeMapper;

    public MealPlanRecipeMapper(RecipeMapper recipeMapper) {
        this.recipeMapper = recipeMapper;
    }

    public MealPlanRecipeDto toMealPlanRecipeDto(RecipeInMealPlan recipeInMealPlan) {
        if (recipeInMealPlan == null) {
            return null;
        }

        MealPlanRecipeDto mealPlanRecipeDto = new MealPlanRecipeDto();

        mealPlanRecipeDto.setId(recipeInMealPlan.getId());
        mealPlanRecipeDto.setRecipe(recipeMapper.toRecipeDto(recipeInMealPlan.getRecipe()));
        mealPlanRecipeDto.setMealType(recipeInMealPlan.getMealType());
        mealPlanRecipeDto.setDayOfWeek(recipeInMealPlan.getDayOfWeek());

        return mealPlanRecipeDto;
    }

    public RecipeInMealPlan toRecipeInMealPlan(MealPlanRecipeDto mealPlanRecipeDto) {
        if (mealPlanRecipeDto == null) {
            return null;
        }

        RecipeInMealPlan recipeInMealPlan = new RecipeInMealPlan();

        recipeInMealPlan.setId(mealPlanRecipeDto.getId());
        recipeInMealPlan.setRecipe(recipeMapper.toRecipe(mealPlanRecipeDto.getRecipe()));
        recipeInMealPlan.setDayOfWeek(mealPlanRecipeDto.getDayOfWeek());
        recipeInMealPlan.setMealType(mealPlanRecipeDto.getMealType());

        return recipeInMealPlan;
    }

    public List<RecipeInMealPlan> toRecipeInMealPlanList(List<MealPlanRecipeDto> mealPlanRecipeDtoList) {
        if (mealPlanRecipeDtoList == null) {
            return null;
        }

        List<RecipeInMealPlan> list = new ArrayList<RecipeInMealPlan>();
        for (MealPlanRecipeDto mealPlanRecipeDto : mealPlanRecipeDtoList) {
            list.add(toRecipeInMealPlan(mealPlanRecipeDto));
        }

        return list;
    }

    public List<MealPlanRecipeDto> toMealPlanRecipeDtoList(List<RecipeInMealPlan> recipeInMealPlanList) {
        if (recipeInMealPlanList == null) {
            return null;
        }

        List<MealPlanRecipeDto> list = new ArrayList<MealPlanRecipeDto>();
        for (RecipeInMealPlan recipeInMealPlan : recipeInMealPlanList) {
            list.add(toMealPlanRecipeDto(recipeInMealPlan));
        }

        return list;
    }
}
