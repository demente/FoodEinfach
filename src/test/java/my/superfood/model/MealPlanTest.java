package my.superfood.model;

import my.superfood.model.enums.MineralName;
import my.superfood.model.enums.VitaminName;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static my.superfood.model.FoodBuilder.aFood;
import static my.superfood.model.IngredientBuilder.anIngredient;
import static my.superfood.model.MealPlanBuilder.aMealPlan;
import static my.superfood.model.MealPlanRecipeBuilder.aMealPlanRecipe;
import static my.superfood.model.MineralAmountBuilder.aMineralAmount;
import static my.superfood.model.MineralBuilder.aMineral;
import static my.superfood.model.NutritionalInformationBuilder.aNutritionalInformation;
import static my.superfood.model.RecipeBuilder.aRecipe;
import static my.superfood.model.VitaminAmountBuilder.aVitaminAmount;
import static my.superfood.model.VitaminBuilder.aVitamin;
import static org.assertj.core.api.Assertions.assertThat;

public class MealPlanTest {

    @Test
    public void calculatesDailyAverageNutrition() {
        Ingredient ingredient = anIngredient().withFood(aFood().withNutritionPerHundredGrams(
                getNutritionalInfo(asList(aVitaminAmount().withVitamin(aVitamin().withName(VitaminName.C).build()).withAmount(200L).build()),
                        asList(aMineralAmount().withMineral(aMineral().withName(MineralName.Fe).build()).withAmount(300L).build()),
                        100L, 10L, 20L, 30L, 40L, 50L)).build()).build();

        Ingredient ingredient2 = anIngredient().withFood(aFood().withNutritionPerHundredGrams(
                getNutritionalInfo(asList(aVitaminAmount().withVitamin(aVitamin().withName(VitaminName.C).build()).withAmount(2400L).build()),
                        asList(aMineralAmount().withMineral(aMineral().withName(MineralName.Fe).build()).withAmount(2200L).build()),
                        1200L, 120L, 100L, 80L, 60L, 40L)).build()).build();

        MealPlan mealPlan = aMealPlan().withRecipes(asList(aMealPlanRecipe()
                        .withRecipe(aRecipe().withServings(1L)
                                .withIngredients(asList(ingredient)).build()
                        ).build(),
                aMealPlanRecipe()
                        .withRecipe(aRecipe().withServings(2L)
                                .withIngredients(asList(ingredient2)).build()
                        ).build())).build();

        assertThat(mealPlan.getDailyAverageNutrition().getCalories()).isEqualTo(100L);
        assertThat(mealPlan.getDailyAverageNutrition().getProtein()).isEqualTo(10L);
        assertThat(mealPlan.getDailyAverageNutrition().getCarbohydrates()).isEqualTo(10L);
        assertThat(mealPlan.getDailyAverageNutrition().getFat()).isEqualTo(10L);
        assertThat(mealPlan.getDailyAverageNutrition().getFibre()).isEqualTo(10L);
        assertThat(mealPlan.getDailyAverageNutrition().getSugar()).isEqualTo(10L);
        assertThat(mealPlan.getDailyAverageNutrition().getVitamins()).extracting(VitaminAmount::getAmount).containsExactly(200L);
        assertThat(mealPlan.getDailyAverageNutrition().getMinerals()).extracting(MineralAmount::getAmount).containsExactly(200L);
    }

    @Test
    public void calculatesIngredientList() {
        Ingredient ingredient = anIngredient().withFood(aFood().withId(1L).build())
                .withAmount(1000000000L).build();

        Ingredient ingredient2 = anIngredient().withFood(aFood().withId(2L).build())
                .withAmount(20000000000L).build();

        MealPlan mealPlan = aMealPlan().withRecipes(asList(aMealPlanRecipe()
                        .withRecipe(aRecipe().withServings(1L)
                                .withIngredients(asList(ingredient)).build()
                        ).build(),
                aMealPlanRecipe()
                        .withRecipe(aRecipe().withServings(2L)
                                .withIngredients(asList(ingredient2, ingredient)).build()
                        ).build())).build();

        assertThat(mealPlan.getIngredients()).extracting(FoodAmount::getAmount).containsExactly(1500000000L, 10000000000L);
        assertThat(mealPlan.getIngredients()).extracting(FoodAmount::getFood).extracting(Food::getId).containsExactly(1L, 2L);
    }

    private NutritionalInformation getNutritionalInfo(List<VitaminAmount> vitamins, List<MineralAmount> minerals, Long calories, Long protein, Long carbs, Long fat, Long fibre, Long sugar) {
        return aNutritionalInformation()
                .withVitamins(vitamins)
                .withMinerals(minerals)
                .withCalories(calories)
                .withCarbohydrates(carbs)
                .withFibre(fibre)
                .withProtein(protein)
                .withFat(fat)
                .withSugar(sugar)
                .build();
    }

}