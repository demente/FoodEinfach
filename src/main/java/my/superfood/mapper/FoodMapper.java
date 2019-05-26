package my.superfood.mapper;

import my.superfood.dto.FoodDto;
import my.superfood.dto.FoodInfoDto;
import my.superfood.model.Food;
import my.superfood.model.enums.FoodType;

import java.util.ArrayList;
import java.util.List;

public class FoodMapper {

    private final NutritionalInformationMapper nutritionalInformationMapper;
    private final WeightMapper weightMapper;

    public FoodMapper(NutritionalInformationMapper nutritionalInformationMapper, WeightMapper weightMapper) {
        this.nutritionalInformationMapper = nutritionalInformationMapper;
        this.weightMapper = weightMapper;
    }

    public FoodDto toFoodDto(Food food) {
        if (food == null) {
            return null;
        }

        FoodDto foodDto = new FoodDto();

        foodDto.setNutritionalInformation(nutritionalInformationMapper.toNutritionalInformationDto(food.getNutritionPerHundredGrams()));
        foodDto.setId(food.getId());
        foodDto.setName(food.getName());
        if (food.getType() != null) {
            foodDto.setType(food.getType().name());
        }
        foodDto.setWeight(weightMapper.toWeightDto(food.getWeight()));
        foodDto.setPieceName(food.getPieceName());
        foodDto.setMinimumWeight(weightMapper.toWeightDto(food.getMinimumWeight()));
        foodDto.setPricePerMinimumWeightInCents(food.getPricePerMinimumWeightInCents());
        foodDto.setMinimumPackageName(food.getMinimumPackageName());

        return foodDto;
    }

    public Food toFood(FoodDto foodDto) {
        if (foodDto == null) {
            return null;
        }

        Food food = new Food();

        food.setNutritionPerHundredGrams(nutritionalInformationMapper.toNutritionalInformation(foodDto.getNutritionalInformation()));
        food.setId(foodDto.getId());
        food.setName(foodDto.getName());
        food.setWeight(weightMapper.toWeightInMicrograms(foodDto.getWeight()));
        food.setMinimumWeight(weightMapper.toWeightInMicrograms(foodDto.getMinimumWeight()));
        food.setPricePerMinimumWeightInCents(foodDto.getPricePerMinimumWeightInCents());
        food.setPieceName(foodDto.getPieceName());
        food.setMinimumPackageName(foodDto.getMinimumPackageName());
        if (foodDto.getType() != null) {
            food.setType(Enum.valueOf(FoodType.class, foodDto.getType()));
        }

        food.setActive(true);
        return food;
    }

    public List<FoodDto> toFoodDtoList(List<Food> foodList) {
        if (foodList == null) {
            return null;
        }

        List<FoodDto> list = new ArrayList<FoodDto>();
        for (Food food : foodList) {
            list.add(toFoodDto(food));
        }

        return list;
    }

    public List<Food> toFoodList(List<FoodDto> foodDtoList) {
        if (foodDtoList == null) {
            return null;
        }

        List<Food> list = new ArrayList<Food>();
        for (FoodDto foodDto_ : foodDtoList) {
            list.add(toFood(foodDto_));
        }

        return list;
    }

    public FoodInfoDto toFoodInfoDto(Food food) {
        if (food == null) {
            return null;
        }

        FoodInfoDto foodInfoDto = new FoodInfoDto();

        foodInfoDto.setId(food.getId());
        foodInfoDto.setName(food.getName());
        if (food.getType() != null) {
            foodInfoDto.setType(food.getType().name());
        }

        return foodInfoDto;
    }

    public List<FoodInfoDto> toFoodInfoDtoList(List<Food> foodList) {
        if (foodList == null) {
            return null;
        }

        List<FoodInfoDto> list = new ArrayList<FoodInfoDto>();
        for (Food food : foodList) {
            list.add(toFoodInfoDto(food));
        }

        return list;
    }
}
