package my.superfood.dto;

import my.superfood.model.enums.MineralName;

import javax.annotation.Generated;

import static my.superfood.dto.WeightDtoBuilder.aWeightDto;

@Generated("PojoBuilder")
public class MineralAmountDtoBuilder extends AbstractMineralAmountDtoBuilder {

    private MineralAmountDtoBuilder() {
    }

    public static MineralAmountDtoBuilder aMineralAmountDto() {
        return new MineralAmountDtoBuilder().withAmount(aWeightDto().build()).withName(MineralName.Ca).withId(1L).withDailyNorm(aWeightDto().build());
    }
}
