package my.superfood.mapper;

import my.superfood.dto.MealPlanFoodDto;
import my.superfood.model.MealPlanFood;
import my.superfood.resolver.FoodResolver;

import java.util.ArrayList;
import java.util.List;

public class MealPlanFoodMapper {

    private final FoodMapper foodMapper;
    private final FoodResolver foodResolver;
    private final WeightMapper weightMapper;

    public MealPlanFoodMapper(FoodResolver foodResolver, FoodMapper foodMapper, WeightMapper weightMapper) {
        this.foodResolver = foodResolver;
        this.foodMapper = foodMapper;
        this.weightMapper = weightMapper;
    }

    public MealPlanFoodDto toMealPlanFoodDto(MealPlanFood mealPlanFood) {
        if (mealPlanFood == null) {
            return null;
        }

        MealPlanFoodDto mealPlanFoodDto = new MealPlanFoodDto();
        mealPlanFoodDto.setId(mealPlanFood.getId());
        mealPlanFoodDto.setDayOfWeek(mealPlanFood.getDayOfWeek());
        mealPlanFoodDto.setMealType(mealPlanFood.getMealType());

        mealPlanFoodDto.setAmount(weightMapper.toWeightDto(mealPlanFood.getAmount()));
        mealPlanFoodDto.setFood(foodMapper.toFoodDto(mealPlanFood.getFood()));

        return mealPlanFoodDto;
    }

    public MealPlanFood toMealPlanFood(MealPlanFoodDto mealPlanFoodDto) {
        if (mealPlanFoodDto == null) {
            return null;
        }

        MealPlanFood mealPlanFood = new MealPlanFood();

        mealPlanFood.setId(mealPlanFoodDto.getId());
        mealPlanFood.setDayOfWeek(mealPlanFoodDto.getDayOfWeek());
        mealPlanFood.setMealType(mealPlanFoodDto.getMealType());

        mealPlanFood.setAmount(weightMapper.toWeightInMicrograms(mealPlanFoodDto.getAmount()));
        mealPlanFood.setFood(foodResolver.toFood(mealPlanFoodDto.getFood().getId()));

        return mealPlanFood;
    }

    public List<MealPlanFoodDto> toMealPlanFoodDtoList(List<MealPlanFood> mealPlanFoodList) {
        if (mealPlanFoodList == null) {
            return null;
        }

        List<MealPlanFoodDto> list = new ArrayList<MealPlanFoodDto>();
        for (MealPlanFood mealPlanFood : mealPlanFoodList) {
            list.add(toMealPlanFoodDto(mealPlanFood));
        }

        return list;
    }

    public List<MealPlanFood> toMealPlanFoodList(List<MealPlanFoodDto> mealPlanFoodDtoList) {
        if (mealPlanFoodDtoList == null) {
            return null;
        }

        List<MealPlanFood> list = new ArrayList<MealPlanFood>();
        for (MealPlanFoodDto mealPlanFoodDto : mealPlanFoodDtoList) {
            list.add(toMealPlanFood(mealPlanFoodDto));
        }

        return list;
    }
}
