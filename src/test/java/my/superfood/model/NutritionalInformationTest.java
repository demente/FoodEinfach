package my.superfood.model;

import my.superfood.model.enums.MineralName;
import my.superfood.model.enums.VitaminName;
import org.junit.Test;

import static java.util.Arrays.asList;
import static my.superfood.model.MineralAmountBuilder.aMineralAmount;
import static my.superfood.model.MineralBuilder.aMineral;
import static my.superfood.model.NutritionalInformationBuilder.aNutritionalInformation;
import static my.superfood.model.VitaminAmountBuilder.aVitaminAmount;
import static my.superfood.model.VitaminBuilder.aVitamin;
import static org.assertj.core.api.Assertions.assertThat;

public class NutritionalInformationTest {

    @Test
    public void sumsNutritionalInformation() {
        NutritionalInformation nutritionalInformation = aNutritionalInformation()
                .withVitamins(asList(aVitaminAmount().withVitamin(aVitamin().withName(VitaminName.C).build()).withAmount(200L).build()))
                .withMinerals(asList(aMineralAmount().withMineral(aMineral().withName(MineralName.Fe).build()).withAmount(300L).build()))
                .withCalories(100L)
                .withCarbohydrates(10L)
                .withFibre(20L)
                .withProtein(40L)
                .withFat(60L)
                .withSugar(80L)
                .build();

        nutritionalInformation.addNutritionalInformation(nutritionalInformation);


        assertThat(nutritionalInformation.getCalories()).isEqualTo(200L);
        assertThat(nutritionalInformation.getProtein()).isEqualTo(80L);
        assertThat(nutritionalInformation.getCarbohydrates()).isEqualTo(20L);
        assertThat(nutritionalInformation.getFat()).isEqualTo(120L);
        assertThat(nutritionalInformation.getFibre()).isEqualTo(40L);
        assertThat(nutritionalInformation.getSugar()).isEqualTo(160L);
        assertThat(nutritionalInformation.getVitamins()).extracting(VitaminAmount::getAmount).containsExactly(400L);
        assertThat(nutritionalInformation.getMinerals()).extracting(MineralAmount::getAmount).containsExactly(600L);
    }

    @Test
    public void dividesNutritionalInformation() {
        NutritionalInformation nutritionalInformation = aNutritionalInformation()
                .withVitamins(asList(aVitaminAmount().withVitamin(aVitamin().withName(VitaminName.C).build()).withAmount(200L).build(),
                        aVitaminAmount().withVitamin(aVitamin().withName(VitaminName.A).build()).withAmount(100L).build()))
                .withMinerals(asList(aMineralAmount().withMineral(aMineral().withName(MineralName.Fe).build()).withAmount(300L).build()))
                .withCalories(100L)
                .withProtein(40L)
                .withCarbohydrates(10L)
                .withFat(60L)
                .withFibre(20L)
                .withSugar(80L)
                .build();

        nutritionalInformation.divide(10.0);

        assertThat(nutritionalInformation.getCalories()).isEqualTo(10L);
        assertThat(nutritionalInformation.getProtein()).isEqualTo(4L);
        assertThat(nutritionalInformation.getCarbohydrates()).isEqualTo(1L);
        assertThat(nutritionalInformation.getFat()).isEqualTo(6L);
        assertThat(nutritionalInformation.getFibre()).isEqualTo(2L);
        assertThat(nutritionalInformation.getSugar()).isEqualTo(8L);
        assertThat(nutritionalInformation.getVitamins()).extracting(VitaminAmount::getAmount).containsExactly(20L,10L);
        assertThat(nutritionalInformation.getMinerals()).extracting(MineralAmount::getAmount).containsExactly(30L);
    }

}