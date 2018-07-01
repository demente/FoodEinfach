package my.superfood.dto;

import my.superfood.model.enums.MineralName;

import javax.annotation.Generated;

import static my.superfood.dto.WeightDtoBuilder.aWeightDto;

@Generated("PojoBuilder")
public class MineralDtoBuilder extends AbstractMineralDtoBuilder {

    private MineralDtoBuilder() {
    }

    public static MineralDtoBuilder aMineralDto() {
        return new MineralDtoBuilder().withAmount(aWeightDto().build()).withName(MineralName.Ca).withId(1L).withDailyNorm(aWeightDto().build());
    }
}
