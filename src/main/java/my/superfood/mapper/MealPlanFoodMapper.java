package my.superfood.mapper;

import my.superfood.dto.MealPlanFoodDto;
import my.superfood.dto.WeightDto;
import my.superfood.model.MealPlanFood;
import my.superfood.model.enums.Unit;

import java.util.ArrayList;
import java.util.List;

public class MealPlanFoodMapper {

    private final FoodMapper foodMapper;

    public MealPlanFoodMapper(FoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    public MealPlanFoodDto toMealPlanFoodDto(MealPlanFood MealPlanFood) {
        if (MealPlanFood == null) {
            return null;
        }

        MealPlanFoodDto mealPlanFoodDto = new MealPlanFoodDto();

        WeightDto amount = new WeightDto();
        mealPlanFoodDto.setAmount(amount);

        amount.setWeight(MealPlanFood.getAmount());
        if (MealPlanFood.getUnit() != null) {
            amount.setUnit(MealPlanFood.getUnit().name());
        }
        mealPlanFoodDto.setId(MealPlanFood.getId());
        mealPlanFoodDto.setMealType(MealPlanFood.getMealType());
        mealPlanFoodDto.setFood(foodMapper.toFoodDto(MealPlanFood.getFood()));
        mealPlanFoodDto.setDayOfWeek(MealPlanFood.getDayOfWeek());

        return mealPlanFoodDto;
    }

    public MealPlanFood toFoodInMealPlan(MealPlanFoodDto mealPlanFoodDto) {
        if (mealPlanFoodDto == null) {
            return null;
        }

        MealPlanFood mealPlanFood = new MealPlanFood();

        String amount = mealPlanFoodDtoAmountUnit(mealPlanFoodDto);
        if (amount != null) {
            mealPlanFood.setUnit(Enum.valueOf(Unit.class, amount));
        }
        mealPlanFood.setAmount(mealPlanFoodDtoAmountWeight(mealPlanFoodDto));
        mealPlanFood.setId(mealPlanFoodDto.getId());
        mealPlanFood.setFood(foodMapper.toFood(mealPlanFoodDto.getFood()));
        mealPlanFood.setDayOfWeek(mealPlanFoodDto.getDayOfWeek());
        mealPlanFood.setMealType(mealPlanFoodDto.getMealType());

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

    public List<MealPlanFood> toFoodInMealPlanList(List<MealPlanFoodDto> mealPlanFoodDtoList) {
        if (mealPlanFoodDtoList == null) {
            return null;
        }

        List<MealPlanFood> list = new ArrayList<MealPlanFood>();
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
