package my.superfood.dto;

import my.superfood.model.enums.VitaminName;

import javax.annotation.Generated;

import static my.superfood.dto.WeightDtoBuilder.aWeightDto;

@Generated("PojoBuilder")
public class VitaminDtoBuilder extends AbstractVitaminDtoBuilder {

    private VitaminDtoBuilder() {
    }

    public static VitaminDtoBuilder aVitaminDto() {
        return new VitaminDtoBuilder().withName(VitaminName.A)
                .withDailyNorm(aWeightDto().build());
    }
}
