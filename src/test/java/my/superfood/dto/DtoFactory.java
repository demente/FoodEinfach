package my.superfood.dto;

import net.karneim.pojobuilder.GeneratePojoBuilder;

public class DtoFactory {

    private DtoFactory() {
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static IngredientDto newIngredientDto() {
        return new IngredientDto();
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static MineralDto newMineralDto() {
        return new MineralDto();
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static NutritionalInformationDto newNutritionalInformationDto() {
        return new NutritionalInformationDto();
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static RecipeDto newRecipeDto() {
        return new RecipeDto();
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static VitaminDto newVitaminDto() {
        return new VitaminDto();
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static WeightDto newWeightDto() {
        return new WeightDto();
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static FoodDto newFoodDto() {
        return new FoodDto();
    }
}
