package my.superfood.mapper;

import my.superfood.dto.IngredientDto;
import my.superfood.dto.WeightDto;
import my.superfood.model.Ingredient;
import my.superfood.model.enums.Unit;

import java.util.ArrayList;
import java.util.List;


public class IngredientMapper {

    private final FoodMapper foodMapper;


    public IngredientMapper(FoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    public IngredientDto toIngredientDto(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }

        IngredientDto ingredientDto = new IngredientDto();

        WeightDto amount = new WeightDto();
        ingredientDto.setAmount(amount);

        amount.setWeight(ingredient.getAmount());
        if (ingredient.getUnit() != null) {
            amount.setUnit(ingredient.getUnit().name());
        }
        ingredientDto.setId(ingredient.getId());
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

        String amount = ingredientDtoAmountUnit(ingredientDto);
        if (amount != null) {
            ingredient.setUnit(Enum.valueOf(Unit.class, amount));
        }
        ingredient.setAmount(ingredientDtoAmountWeight(ingredientDto));
        ingredient.setId(ingredientDto.getId());
        ingredient.setFood(foodMapper.toFood(ingredientDto.getFood()));

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

    private String ingredientDtoAmountUnit(IngredientDto ingredientDto) {

        if (ingredientDto == null) {
            return null;
        }
        WeightDto amount = ingredientDto.getAmount();
        if (amount == null) {
            return null;
        }
        String unit = amount.getUnit();
        if (unit == null) {
            return null;
        }
        return unit;
    }

    private Long ingredientDtoAmountWeight(IngredientDto ingredientDto) {

        if (ingredientDto == null) {
            return null;
        }
        WeightDto amount = ingredientDto.getAmount();
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
