package my.superfood.model;

import my.superfood.model.enums.MineralName;
import my.superfood.model.enums.VitaminName;
import org.junit.Test;

import static java.util.Arrays.asList;
import static my.superfood.model.FoodBuilder.aFood;
import static my.superfood.model.IngredientBuilder.anIngredient;
import static my.superfood.model.MineralAmountBuilder.aMineralAmount;
import static my.superfood.model.MineralBuilder.aMineral;
import static my.superfood.model.NutritionalInformationBuilder.aNutritionalInformation;
import static my.superfood.model.VitaminAmountBuilder.aVitaminAmount;
import static my.superfood.model.VitaminBuilder.aVitamin;
import static org.assertj.core.api.Assertions.assertThat;

public class IngredientTest {

    @Test
    public void calculatesNutritionalInformation() {
        Ingredient ingredient = anIngredient().withFood(aFood().withNutritionPerHundredGrams(
                aNutritionalInformation()
                        .withVitamins(asList(aVitaminAmount().withVitamin(aVitamin().withName(VitaminName.C).build()).withAmount(200L).build()))
                        .withMinerals(asList(aMineralAmount().withMineral(aMineral().withName(MineralName.Fe).build()).withAmount(300L).build()))
                        .withCalories(100L)
                        .withCarbohydrates(10L)
                        .withFibre(20L)
                        .withProtein(40L)
                        .withFat(60L)
                        .withSugar(80L)
                        .build())
                .build())
                .withAmount(50000000L).build();


        assertThat(ingredient.getNutritionalInformation().getCalories()).isEqualTo(50L);
        assertThat(ingredient.getNutritionalInformation().getProtein()).isEqualTo(20L);
        assertThat(ingredient.getNutritionalInformation().getCarbohydrates()).isEqualTo(5L);
        assertThat(ingredient.getNutritionalInformation().getFat()).isEqualTo(30L);
        assertThat(ingredient.getNutritionalInformation().getFibre()).isEqualTo(10L);
        assertThat(ingredient.getNutritionalInformation().getSugar()).isEqualTo(40L);
        assertThat(ingredient.getNutritionalInformation().getVitamins()).extracting(VitaminAmount::getAmount).containsExactly(100L);
        assertThat(ingredient.getNutritionalInformation().getMinerals()).extracting(MineralAmount::getAmount).containsExactly(150L);
    }

}