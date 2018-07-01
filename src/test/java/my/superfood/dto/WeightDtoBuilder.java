package my.superfood.dto;

import my.superfood.model.enums.Unit;

import javax.annotation.Generated;

@Generated("PojoBuilder")
public class WeightDtoBuilder extends AbstractWeightDtoBuilder {

    private WeightDtoBuilder() {
    }

    public static WeightDtoBuilder aWeightDto() {
        return new WeightDtoBuilder().withUnit(Unit.MICROGRAM.name()).withWeight(100L);
    }
}
