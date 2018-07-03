package my.superfood.assertions;

import my.superfood.dto.NutritionalInformationDto;
import my.superfood.dto.VitaminDto;
import my.superfood.dto.WeightDto;
import my.superfood.model.NutritionalInformation;

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

    public static void assertEqualVitaminDto(VitaminDto actual, VitaminDto expected){
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertEqualWeightDto(actual.getDailyNorm(), expected.getDailyNorm());
        assertEqualWeightDto(actual.getAmount(), expected.getAmount());
    }
}

