package my.superfood.dto;

import my.superfood.model.enums.VitaminName;

import javax.annotation.Generated;

import static my.superfood.dto.WeightDtoBuilder.aWeightDto;

@Generated("PojoBuilder")
public class VitaminDtoBuilder extends AbstractVitaminDtoBuilder {

    private VitaminDtoBuilder() {
    }

    public static VitaminDtoBuilder aVitaminDto() {
        return new VitaminDtoBuilder().withId(1L)
                                      .withName(VitaminName.A)
                                      .withAmount(aWeightDto().build())
                                      .withDailyNorm(aWeightDto().build());
    }
}
