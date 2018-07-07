package my.superfood.dto;

import javax.annotation.Generated;

import static my.superfood.dto.WeightDtoBuilder.aWeightDto;


@Generated("PojoBuilder")
public class MineralDtoBuilder extends AbstractMineralDtoBuilder {

    private MineralDtoBuilder() {
    }

    public static MineralDtoBuilder aMineralDto() {
        return new MineralDtoBuilder().withName("Ca").withDailyNorm(aWeightDto().build());
    }
}
