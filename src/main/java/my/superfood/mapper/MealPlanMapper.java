package my.superfood.mapper;

import my.superfood.dto.MealPlanDto;
import my.superfood.dto.MealPlanFoodDto;
import my.superfood.dto.MealPlanRecipeDto;
import my.superfood.model.FoodInMealPlan;
import my.superfood.model.MealPlan;
import my.superfood.model.RecipeInMealPlan;

import java.util.ArrayList;
import java.util.List;

public class MealPlanMapper {

    private final MealPlanRecipeMapper mealPlanRecipeMapper;
    private final MealPlanFoodMapper mealPlanFoodMapper;

    public MealPlanMapper(MealPlanRecipeMapper mealPlanRecipeMapper, MealPlanFoodMapper mealPlanFoodMapper) {
        this.mealPlanRecipeMapper = mealPlanRecipeMapper;
        this.mealPlanFoodMapper = mealPlanFoodMapper;
    }

    public MealPlan toMealPlan(MealPlanDto mealPlanDto) {
        if (mealPlanDto == null) {
            return null;
        }

        MealPlan mealPlan = new MealPlan();

        mealPlan.setId(mealPlanDto.getId());
        List<FoodInMealPlan> list = mealPlanFoodMapper.toFoodInMealPlanList(mealPlanDto.getFood());
        if (list != null) {
            mealPlan.setFood(list);
        }
        mealPlan.setStartDate(mealPlanDto.getStartDate());
        mealPlan.setEndDate(mealPlanDto.getEndDate());
        List<RecipeInMealPlan> list_ = mealPlanRecipeMapper.toRecipeInMealPlanList(mealPlanDto.getRecipes());
        if (list_ != null) {
            mealPlan.setRecipes(list_);
        }

        return mealPlan;
    }

    public MealPlanDto toMealPlanDto(MealPlan mealPlan) {
        if (mealPlan == null) {
            return null;
        }

        MealPlanDto mealPlanDto = new MealPlanDto();

        mealPlanDto.setId(mealPlan.getId());
        List<MealPlanFoodDto> list = mealPlanFoodMapper.toMealPlanFoodDtoList(mealPlan.getFood());
        if (list != null) {
            mealPlanDto.setFood(list);

        }
        List<MealPlanRecipeDto> list_ = mealPlanRecipeMapper.toMealPlanRecipeDtoList(mealPlan.getRecipes());
        if (list_ != null) {
            mealPlanDto.setRecipes(list_);
        }
        mealPlanDto.setStartDate(mealPlan.getStartDate());
        mealPlanDto.setEndDate(mealPlan.getEndDate());

        return mealPlanDto;
    }

    public List<MealPlanDto> toMealPlanDtoList(List<MealPlan> mealPlanList) {
        if (mealPlanList == null) {
            return null;
        }

        List<MealPlanDto> list = new ArrayList<MealPlanDto>();
        for (MealPlan mealPlan : mealPlanList) {
            list.add(toMealPlanDto(mealPlan));
        }

        return list;
    }

}