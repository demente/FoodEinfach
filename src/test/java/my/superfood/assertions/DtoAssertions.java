package my.superfood.assertions;

import my.superfood.dto.*;

import static org.assertj.core.api.Assertions.assertThat;

public class DtoAssertions {

    public static void assertEqualWeightDto(WeightDto actual, WeightDto expected) {
        assertThat(actual.getUnit()).isEqualTo(expected.getUnit());
        assertThat(actual.getWeight()).isEqualTo(expected.getWeight());
    }

    public static void assertEqualNutritionalInformationDto(NutritionalInformationDto actual, NutritionalInformationDto expected) {
        assertThat(actual.getCalories()).isEqualTo(expected.getCalories());

        assertEqualWeightDto(actual.getCarbohydrates(), expected.getCarbohydrates());
        assertEqualWeightDto(actual.getFat(), expected.getFat());
        assertEqualWeightDto(actual.getProtein(), expected.getProtein());
        assertEqualWeightDto(actual.getSugar(), expected.getSugar());
        assertEqualWeightDto(actual.getFibre(), expected.getFibre());
    }

    public static void assertEqualVitaminAmountDto(VitaminAmountDto actual, VitaminAmountDto expected) {
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertEqualWeightDto(actual.getDailyNorm(), expected.getDailyNorm());
        assertEqualWeightDto(actual.getAmount(), expected.getAmount());
    }

    public static void assertEqualVitaminDto(VitaminDto actual, VitaminDto expected) {
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertEqualWeightDto(actual.getDailyNorm(), expected.getDailyNorm());
    }

    public static void assertEqualFoodDto(FoodDto actual, FoodDto expected) {
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getType()).isEqualTo(expected.getType());

        assertEqualWeightDto(actual.getWeight(), expected.getWeight());
        assertEqualNutritionalInformationDto(actual.getNutritionalInformation(), expected.getNutritionalInformation());
    }

    public static void assertEqualFoodInfoDto(FoodInfoDto actual, FoodInfoDto expected) {
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getType()).isEqualTo(expected.getType());
    }

    public static void assertEqualIngredientDto(IngredientDto actual, IngredientDto expected) {
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getRecipeId()).isEqualTo(expected.getRecipeId());

        assertEqualWeightDto(actual.getAmount(), expected.getAmount());
        assertEqualFoodDto(actual.getFood(), expected.getFood());
    }

    public static void assertEqualMineralAmountDto(MineralAmountDto actual, MineralAmountDto expected) {
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertEqualWeightDto(actual.getAmount(), expected.getAmount());
        assertEqualWeightDto(actual.getDailyNorm(), expected.getDailyNorm());
    }

    public static void assertEqualMineralDto(MineralDto actual, MineralDto expected) {
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertEqualWeightDto(actual.getDailyNorm(), expected.getDailyNorm());
    }

    public static void assertEqualRecipeDto(RecipeDto actual, RecipeDto expected) {
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getType()).isEqualTo(expected.getType());
        assertThat(actual.getPreparationTime()).isEqualTo(expected.getPreparationTime());
        assertThat(actual.getCookingTime()).isEqualTo(expected.getCookingTime());
    }

    public static void assertEqualRecipeInfoDto(RecipeInfoDto actual, RecipeInfoDto expected) {
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getType()).isEqualTo(expected.getType());
    }


    public static void assertEqualMealPlanRecipeDto(MealPlanRecipeDto actual, MealPlanRecipeDto expected) {
        assertEqualRecipeDto(actual.getRecipe(), expected.getRecipe());
        assertThat(actual.getDayOfWeek()).isEqualTo(expected.getDayOfWeek());
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getMealType()).isEqualTo(expected.getMealType());
    }

    public static void assertEqualMealPlanFoodDto(MealPlanFoodDto actual, MealPlanFoodDto expected) {
        assertEqualFoodDto(actual.getFood(), expected.getFood());
        assertEqualWeightDto(actual.getAmount(), expected.getAmount());
        assertThat(actual.getDayOfWeek()).isEqualTo(expected.getDayOfWeek());
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getMealType()).isEqualTo(expected.getMealType());
    }

    public static void assertEqualMealPlanDto(MealPlanDto actual, MealPlanDto expected) {
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertEqualMealPlanFoodDto(actual.getFood().get(0), expected.getFood().get(0));
        assertEqualMealPlanRecipeDto(actual.getRecipes().get(0), expected.getRecipes().get(0));
    }
}

