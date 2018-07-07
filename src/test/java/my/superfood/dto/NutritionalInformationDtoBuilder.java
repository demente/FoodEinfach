package my.superfood.dto;

import javax.annotation.Generated;

import static java.util.Arrays.asList;
import static my.superfood.dto.MineralAmountDtoBuilder.aMineralAmountDto;
import static my.superfood.dto.VitaminDtoBuilder.aVitaminDto;
import static my.superfood.dto.WeightDtoBuilder.aWeightDto;

@Generated("PojoBuilder")
public class NutritionalInformationDtoBuilder extends AbstractNutritionalInformationDtoBuilder {

    private NutritionalInformationDtoBuilder() {
    }

    public static NutritionalInformationDtoBuilder aNutritionalInformationDto() {
        return new NutritionalInformationDtoBuilder()
                .withCalories(52L)
                .withFat(aWeightDto().build())
                .withProtein(aWeightDto().build())
                .withCarbohydrates(aWeightDto().build())
                .withFibre(aWeightDto().build())
                .withSugar(aWeightDto().build())
                .withMinerals(asList(aMineralAmountDto().build()))
                .withVitamins(asList(aVitaminDto().build()));
    }
}
