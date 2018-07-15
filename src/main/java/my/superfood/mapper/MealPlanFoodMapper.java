package my.superfood.mapper;

import my.superfood.dto.MealPlanFoodDto;
import my.superfood.model.FoodInMealPlan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(uses = {FoodMapper.class, WeightMapper.class})
public interface MealPlanFoodMapper {


    @Mappings({@Mapping(source = "unit", target = "amount.unit"),
            @Mapping(source = "amount", target = "amount.weight")})
    MealPlanFoodDto toMealPlanFoodDto(FoodInMealPlan FoodInMealPlan);

    @Mappings({@Mapping(target = "unit", source = "amount.unit"),
            @Mapping(target = "amount", source = "amount.weight")})
    FoodInMealPlan toFoodInMealPlan(MealPlanFoodDto mealPlanFoodDto);

    List<MealPlanFoodDto> toMealPlanFoodDtoList(List<FoodInMealPlan> foodInMealPlanList);

    List<FoodInMealPlan> toFoodInMealPlanList(List<MealPlanFoodDto> mealPlanFoodDtoList);
}
