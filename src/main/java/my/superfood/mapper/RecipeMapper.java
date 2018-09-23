package my.superfood.mapper;

import my.superfood.dto.IngredientDto;
import my.superfood.dto.RecipeDto;
import my.superfood.dto.RecipeInfoDto;
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
        List<String> list_ = getMealTypesAsString(recipe.getType());
        if (list_ != null) {
            recipeDto.setType(list_);
        }
        recipeDto.setPreparationTime(recipe.getPreparationTime());
        recipeDto.setServings(recipe.getServings());
        recipeDto.setId(recipe.getId());
        recipeDto.setCookingTime(recipe.getCookingTime());

        return recipeDto;
    }

    public Recipe toRecipe(RecipeDto recipeDto) {
        if (recipeDto == null) {
            return null;
        }

        Recipe recipe = new Recipe();

        recipe.setCookingTime(recipeDto.getCookingTime());
        recipe.setId(recipeDto.getId());
        List<Ingredient> list = ingredientMapper.toIngredientList(recipeDto.getIngredients());
        if (list != null) {
            recipe.setIngredients(list);
        }
        recipe.setInstructions(recipeDto.getInstructions());
        List<MealType> list_ = getMealTypes(recipeDto.getType());
        if (list_ != null) {
            recipe.setType(list_);
        }
        recipe.setPreparationTime(recipeDto.getPreparationTime());
        recipe.setServings(recipeDto.getServings());
        recipe.setName(recipeDto.getName());

        return recipe;
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

    public RecipeInfoDto toRecipeInfoDto(Recipe recipe) {
        if (recipe == null) {
            return null;
        }

        RecipeInfoDto recipeInfoDto = new RecipeInfoDto();
        recipeInfoDto.setId(recipe.getId());
        recipeInfoDto.setName(recipe.getName());

        List<String> mealType = getMealTypesAsString(recipe.getType());
        if (mealType != null) {
            recipeInfoDto.setType(mealType);
        }

        return recipeInfoDto;
    }

    public List<RecipeInfoDto> toRecipeInfoDtoList(List<Recipe> recipeList) {
        if (recipeList == null) {
            return null;
        }

        List<RecipeInfoDto> list = new ArrayList<RecipeInfoDto>();
        for (Recipe recipe : recipeList) {
            list.add(toRecipeInfoDto(recipe));
        }

        return list;
    }

    protected List<String> getMealTypesAsString(List<MealType> list) {
        if (list == null) {
            return null;
        }

        List<String> list_ = new ArrayList<String>();
        for (MealType mealType : list) {
            list_.add(mealType.name());
        }

        return list_;
    }

    protected List<MealType> getMealTypes(List<String> list) {
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
