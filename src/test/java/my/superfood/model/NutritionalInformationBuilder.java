package my.superfood.model;

import javax.annotation.Generated;

@Generated("PojoBuilder")
public class NutritionalInformationBuilder extends AbstractNutritionalInformationBuilder {

    private NutritionalInformationBuilder() {
    }

    public static NutritionalInformationBuilder aNutritionalInformation() {
        return new NutritionalInformationBuilder().withCalories(100L)
                .withCarbohydrates(11L)
                .withProtein(20L)
                .withFat(5L)
                .withFibre(1000L);
    }

}
