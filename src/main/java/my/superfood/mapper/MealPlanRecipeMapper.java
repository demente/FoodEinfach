package my.superfood.mapper;

import my.superfood.dto.MealPlanRecipeDto;
import my.superfood.model.MealPlanRecipe;

import java.util.ArrayList;
import java.util.List;

public class MealPlanRecipeMapper {

    private final RecipeMapper recipeMapper;

    public MealPlanRecipeMapper(RecipeMapper recipeMapper) {
        this.recipeMapper = recipeMapper;
    }

    public MealPlanRecipeDto toMealPlanRecipeDto(MealPlanRecipe mealPlanRecipe) {
        if (mealPlanRecipe == null) {
            return null;
        }

        MealPlanRecipeDto mealPlanRecipeDto = new MealPlanRecipeDto();

        mealPlanRecipeDto.setId(mealPlanRecipe.getId());
        mealPlanRecipeDto.setRecipe(recipeMapper.toRecipeDto(mealPlanRecipe.getRecipe()));
        mealPlanRecipeDto.setMealType(mealPlanRecipe.getMealType());
        mealPlanRecipeDto.setDayOfWeek(mealPlanRecipe.getDayOfWeek());

        return mealPlanRecipeDto;
    }

    public MealPlanRecipe toRecipeInMealPlan(MealPlanRecipeDto mealPlanRecipeDto) {
        if (mealPlanRecipeDto == null) {
            return null;
        }

        MealPlanRecipe mealPlanRecipe = new MealPlanRecipe();

        mealPlanRecipe.setId(mealPlanRecipeDto.getId());
        mealPlanRecipe.setRecipe(recipeMapper.toRecipe(mealPlanRecipeDto.getRecipe()));
        mealPlanRecipe.setDayOfWeek(mealPlanRecipeDto.getDayOfWeek());
        mealPlanRecipe.setMealType(mealPlanRecipeDto.getMealType());

        return mealPlanRecipe;
    }

    public List<MealPlanRecipe> toRecipeInMealPlanList(List<MealPlanRecipeDto> mealPlanRecipeDtoList) {
        if (mealPlanRecipeDtoList == null) {
            return null;
        }

        List<MealPlanRecipe> list = new ArrayList<MealPlanRecipe>();
        for (MealPlanRecipeDto mealPlanRecipeDto : mealPlanRecipeDtoList) {
            list.add(toRecipeInMealPlan(mealPlanRecipeDto));
        }

        return list;
    }

    public List<MealPlanRecipeDto> toMealPlanRecipeDtoList(List<MealPlanRecipe> mealPlanRecipeList) {
        if (mealPlanRecipeList == null) {
            return null;
        }

        List<MealPlanRecipeDto> list = new ArrayList<MealPlanRecipeDto>();
        for (MealPlanRecipe mealPlanRecipe : mealPlanRecipeList) {
            list.add(toMealPlanRecipeDto(mealPlanRecipe));
        }

        return list;
    }
}
