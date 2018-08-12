package my.superfood.mapper;

import my.superfood.dto.MealPlanFoodDto;
import my.superfood.dto.WeightDto;
import my.superfood.model.FoodInMealPlan;
import my.superfood.model.enums.Unit;

import java.util.ArrayList;
import java.util.List;

public class MealPlanFoodMapper {

    private final FoodMapper foodMapper;

    public MealPlanFoodMapper(FoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    public MealPlanFoodDto toMealPlanFoodDto(FoodInMealPlan FoodInMealPlan) {
        if (FoodInMealPlan == null) {
            return null;
        }

        MealPlanFoodDto mealPlanFoodDto = new MealPlanFoodDto();

        WeightDto amount = new WeightDto();
        mealPlanFoodDto.setAmount(amount);

        amount.setWeight(FoodInMealPlan.getAmount());
        if (FoodInMealPlan.getUnit() != null) {
            amount.setUnit(FoodInMealPlan.getUnit().name());
        }
        mealPlanFoodDto.setId(FoodInMealPlan.getId());
        mealPlanFoodDto.setMealType(FoodInMealPlan.getMealType());
        mealPlanFoodDto.setFood(foodMapper.toFoodDto(FoodInMealPlan.getFood()));
        mealPlanFoodDto.setDayOfWeek(FoodInMealPlan.getDayOfWeek());

        return mealPlanFoodDto;
    }

    public FoodInMealPlan toFoodInMealPlan(MealPlanFoodDto mealPlanFoodDto) {
        if (mealPlanFoodDto == null) {
            return null;
        }

        FoodInMealPlan foodInMealPlan = new FoodInMealPlan();

        String amount = mealPlanFoodDtoAmountUnit(mealPlanFoodDto);
        if (amount != null) {
            foodInMealPlan.setUnit(Enum.valueOf(Unit.class, amount));
        }
        foodInMealPlan.setAmount(mealPlanFoodDtoAmountWeight(mealPlanFoodDto));
        foodInMealPlan.setId(mealPlanFoodDto.getId());
        foodInMealPlan.setFood(foodMapper.toFood(mealPlanFoodDto.getFood()));
        foodInMealPlan.setDayOfWeek(mealPlanFoodDto.getDayOfWeek());
        foodInMealPlan.setMealType(mealPlanFoodDto.getMealType());

        return foodInMealPlan;
    }

    public List<MealPlanFoodDto> toMealPlanFoodDtoList(List<FoodInMealPlan> foodInMealPlanList) {
        if (foodInMealPlanList == null) {
            return null;
        }

        List<MealPlanFoodDto> list = new ArrayList<MealPlanFoodDto>();
        for (FoodInMealPlan foodInMealPlan : foodInMealPlanList) {
            list.add(toMealPlanFoodDto(foodInMealPlan));
        }

        return list;
    }

    public List<FoodInMealPlan> toFoodInMealPlanList(List<MealPlanFoodDto> mealPlanFoodDtoList) {
        if (mealPlanFoodDtoList == null) {
            return null;
        }

        List<FoodInMealPlan> list = new ArrayList<FoodInMealPlan>();
        for (MealPlanFoodDto mealPlanFoodDto : mealPlanFoodDtoList) {
            list.add(toFoodInMealPlan(mealPlanFoodDto));
        }

        return list;
    }

    private String mealPlanFoodDtoAmountUnit(MealPlanFoodDto mealPlanFoodDto) {

        if (mealPlanFoodDto == null) {
            return null;
        }
        WeightDto amount = mealPlanFoodDto.getAmount();
        if (amount == null) {
            return null;
        }
        String unit = amount.getUnit();
        if (unit == null) {
            return null;
        }
        return unit;
    }

    private Long mealPlanFoodDtoAmountWeight(MealPlanFoodDto mealPlanFoodDto) {

        if (mealPlanFoodDto == null) {
            return null;
        }
        WeightDto amount = mealPlanFoodDto.getAmount();
        if (amount == null) {
            return null;
        }
        Long weight = amount.getWeight();
        if (weight == null) {
            return null;
        }
        return weight;
    }
}
