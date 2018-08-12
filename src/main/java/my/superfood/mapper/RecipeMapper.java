package my.superfood.mapper;

import my.superfood.dto.IngredientDto;
import my.superfood.dto.RecipeDto;
import my.superfood.model.Ingredient;
import my.superfood.model.Recipe;
import my.superfood.model.enums.MealType;

import java.util.ArrayList;
import java.util.List;

public class RecipeMapper {

    private final IngredientMapper ingredientMapper;

    public RecipeMapper(IngredientMapper ingredientMapper) {
        this.ingredientMapper = ingredientMapper;
    }

    public RecipeDto toRecipeDto(Recipe recipe) {
        if (recipe == null) {
            return null;
        }

        RecipeDto recipeDto = new RecipeDto();

        recipeDto.setName(recipe.getName());
        List<IngredientDto> list = ingredientMapper.toIngredientDtoList(recipe.getIngredients());
        if (list != null) {
            recipeDto.setIngredients(list);
        }
        recipeDto.setInstructions(recipe.getInstructions());
        List<String> list_ = mealTypeListToStringList(recipe.getType());
        if (list_ != null) {
            recipeDto.setType(list_);
        }
        recipeDto.setPreparationTime(recipe.getPreparationTime());
        recipeDto.setServings(recipe.getServings());
        recipeDto.setId(recipe.getId());
        recipeDto.setCookingTime(recipe.getCookingTime());

        return recipeDto;
    }

    public Recipe toRecipe(RecipeDto recipe) {
        if (recipe == null) {
            return null;
        }

        Recipe recipe_ = new Recipe();

        recipe_.setCookingTime(recipe.getCookingTime());
        recipe_.setId(recipe.getId());
        List<Ingredient> list = ingredientMapper.toIngredientList(recipe.getIngredients());
        if (list != null) {
            recipe_.setIngredients(list);
        }
        recipe_.setInstructions(recipe.getInstructions());
        List<MealType> list_ = stringListToMealTypeList(recipe.getType());
        if (list_ != null) {
            recipe_.setType(list_);
        }
        recipe_.setPreparationTime(recipe.getPreparationTime());
        recipe_.setServings(recipe.getServings());
        recipe_.setName(recipe.getName());

        return recipe_;
    }

    public List<RecipeDto> toRecipeDtoList(List<Recipe> recipeList) {
        if (recipeList == null) {
            return null;
        }

        List<RecipeDto> list = new ArrayList<RecipeDto>();
        for (Recipe recipe : recipeList) {
            list.add(toRecipeDto(recipe));
        }

        return list;
    }

    protected List<String> mealTypeListToStringList(List<MealType> list) {
        if (list == null) {
            return null;
        }

        List<String> list_ = new ArrayList<String>();
        for (MealType mealType : list) {
            list_.add(mealType.name());
        }

        return list_;
    }

    protected List<MealType> stringListToMealTypeList(List<String> list) {
        if (list == null) {
            return null;
        }

        List<MealType> list_ = new ArrayList<MealType>();
        for (String string : list) {
            list_.add(Enum.valueOf(MealType.class, string));
        }

        return list_;
    }

}
