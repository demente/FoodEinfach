package my.superfood.mapper;

import my.superfood.dto.IngredientDto;
import my.superfood.dto.WeightDto;
import my.superfood.model.Ingredient;
import my.superfood.resolver.FoodResolver;

import java.util.ArrayList;
import java.util.List;


public class IngredientMapper {

    private final FoodMapper foodMapper;
    private final FoodResolver foodResolver;
    private final WeightMapper weightMapper;

    public IngredientMapper(FoodResolver foodResolver, FoodMapper foodMapper, WeightMapper weightMapper) {
        this.foodResolver = foodResolver;
        this.foodMapper = foodMapper;
        this.weightMapper = weightMapper;
    }

    public IngredientDto toIngredientDto(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }

        IngredientDto ingredientDto = new IngredientDto();

        ingredientDto.setId(ingredient.getId());
        ingredientDto.setAmount(weightMapper.toWeightDto(ingredient.getAmount()));
        ingredientDto.setFood(foodMapper.toFoodDto(ingredient.getFood()));

        return ingredientDto;
    }

    public List<IngredientDto> toIngredientDtoList(List<Ingredient> ingredientList) {
        if (ingredientList == null) {
            return null;
        }

        List<IngredientDto> list = new ArrayList<IngredientDto>();
        for (Ingredient ingredient : ingredientList) {
            list.add(toIngredientDto(ingredient));
        }

        return list;
    }

    public Ingredient toIngredient(IngredientDto ingredientDto) {
        if (ingredientDto == null) {
            return null;
        }

        Ingredient ingredient = new Ingredient();

        ingredient.setId(ingredientDto.getId());
        ingredient.setAmount(weightMapper.toWeightInMicrograms(ingredientDto.getAmount()));
        ingredient.setFood(foodResolver.toFood(ingredientDto.getFood().getId()));

        return ingredient;
    }

    public List<Ingredient> toIngredientList(List<IngredientDto> ingredientDtoList) {
        if (ingredientDtoList == null) {
            return null;
        }

        List<Ingredient> list = new ArrayList<Ingredient>();
        for (IngredientDto ingredientDto : ingredientDtoList) {
            list.add(toIngredient(ingredientDto));
        }

        return list;
    }

}
