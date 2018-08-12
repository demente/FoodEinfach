package my.superfood.dto;

import my.superfood.model.enums.VitaminName;

import javax.annotation.Generated;

import static my.superfood.dto.WeightDtoBuilder.aWeightDto;

@Generated("PojoBuilder")
public class VitaminAmountDtoBuilder extends AbstractVitaminAmountDtoBuilder {

    private VitaminAmountDtoBuilder() {
    }

    public static VitaminAmountDtoBuilder aVitaminAmountDto() {
        return new VitaminAmountDtoBuilder().withId(1L)
                .withAmount(aWeightDto().build())
                .withDailyNorm(aWeightDto().build())
                .withName(VitaminName.A);
    }
}
