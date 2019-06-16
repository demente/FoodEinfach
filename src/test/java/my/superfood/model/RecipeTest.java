package my.superfood.model;

import my.superfood.model.enums.MineralName;
import my.superfood.model.enums.VitaminName;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static my.superfood.model.FoodBuilder.aFood;
import static my.superfood.model.IngredientBuilder.anIngredient;
import static my.superfood.model.MineralAmountBuilder.aMineralAmount;
import static my.superfood.model.MineralBuilder.aMineral;
import static my.superfood.model.NutritionalInformationBuilder.aNutritionalInformation;
import static my.superfood.model.RecipeBuilder.aRecipe;
import static my.superfood.model.VitaminAmountBuilder.aVitaminAmount;
import static my.superfood.model.VitaminBuilder.aVitamin;
import static org.assertj.core.api.Assertions.assertThat;

public class RecipeTest {

    @Test
    public void calculatesNutritionalInformation() {
        Ingredient ingredient = anIngredient().withFood(aFood().withNutritionPerHundredGrams(
                getNutritionalInfo(asList(aVitaminAmount().withVitamin(aVitamin().withName(VitaminName.C).build()).withAmount(200L).build()),
                        asList(aMineralAmount().withMineral(aMineral().withName(MineralName.Fe).build()).withAmount(300L).build()),
                        100L, 10L, 20L, 30L, 40L, 50L)).build())
                .withAmount(100000000L).build();

        Ingredient ingredient2 = anIngredient().withFood(aFood().withNutritionPerHundredGrams(
                getNutritionalInfo(asList(aVitaminAmount().withVitamin(aVitamin().withName(VitaminName.C).build()).withAmount(2400L).build()),
                        asList(aMineralAmount().withMineral(aMineral().withName(MineralName.Fe).build()).withAmount(2100L).build()),
                        1300L, 110L, 100L, 70L, 60L, 50L)).build())
                .withAmount(100000000L).build();

        Recipe recipe = aRecipe().withServings(2L).withIngredients(asList(ingredient, ingredient2)).build();


        assertThat(recipe.getNutritionalInformation().getCalories()).isEqualTo(1400L);
        assertThat(recipe.getNutritionalInformation().getProtein()).isEqualTo(120L);
        assertThat(recipe.getNutritionalInformation().getCarbohydrates()).isEqualTo(120L);
        assertThat(recipe.getNutritionalInformation().getFat()).isEqualTo(100L);
        assertThat(recipe.getNutritionalInformation().getFibre()).isEqualTo(100L);
        assertThat(recipe.getNutritionalInformation().getSugar()).isEqualTo(100L);
        assertThat(recipe.getNutritionalInformation().getVitamins()).extracting(VitaminAmount::getAmount).containsExactly(2600L);
        assertThat(recipe.getNutritionalInformation().getMinerals()).extracting(MineralAmount::getAmount).containsExactly(2400L);
    }

    @Test
    public void calculatesNutritionalInformationPerServing() {
        Ingredient ingredient = anIngredient().withFood(aFood().withNutritionPerHundredGrams(
                getNutritionalInfo(asList(aVitaminAmount().withVitamin(aVitamin().withName(VitaminName.C).build()).withAmount(200L).build()),
                        asList(aMineralAmount().withMineral(aMineral().withName(MineralName.Fe).build()).withAmount(300L).build()),
                        100L, 10L, 20L, 30L, 40L, 50L)).build())
                .withAmount(100000000L).build();

        Ingredient ingredient2 = anIngredient().withFood(aFood().withNutritionPerHundredGrams(
                getNutritionalInfo(asList(aVitaminAmount().withVitamin(aVitamin().withName(VitaminName.C).build()).withAmount(2400L).build()),
                        asList(aMineralAmount().withMineral(aMineral().withName(MineralName.Fe).build()).withAmount(2100L).build()),
                        1300L, 110L, 100L, 70L, 60L, 50L)).build())
                .withAmount(100000000L).build();

        Recipe recipe = aRecipe().withServings(2L).withIngredients(asList(ingredient, ingredient2)).build();


        assertThat(recipe.getNutritionalInformationPerServing().getCalories()).isEqualTo(700L);
        assertThat(recipe.getNutritionalInformationPerServing().getProtein()).isEqualTo(60L);
        assertThat(recipe.getNutritionalInformationPerServing().getCarbohydrates()).isEqualTo(60L);
        assertThat(recipe.getNutritionalInformationPerServing().getFat()).isEqualTo(50L);
        assertThat(recipe.getNutritionalInformationPerServing().getFibre()).isEqualTo(50L);
        assertThat(recipe.getNutritionalInformationPerServing().getSugar()).isEqualTo(50L);
        assertThat(recipe.getNutritionalInformationPerServing().getVitamins()).extracting(VitaminAmount::getAmount).containsExactly(1300L);
        assertThat(recipe.getNutritionalInformationPerServing().getMinerals()).extracting(MineralAmount::getAmount).containsExactly(1200L);
    }

    @Test
    public void getsIngredientsPerServing() {
        Ingredient ingredient = anIngredient().withFood(aFood().withId(1L).build())
                .withAmount(100000000L).build();

        Ingredient ingredient2 = anIngredient().withFood(aFood().withId(2L).build())
                .withAmount(200000000L).build();

        Recipe recipe = aRecipe().withServings(2L).withIngredients(asList(ingredient, ingredient2)).build();

        assertThat(recipe.getIngredientsPerServing()).extracting(FoodAmount::getAmount).containsExactly(50000000L, 100000000L);
        assertThat(recipe.getIngredientsPerServing()).extracting(FoodAmount::getFood).extracting(Food::getId).containsExactly(1L, 2L);
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