package my.superfood.model;

import javax.annotation.Generated;

import static my.superfood.model.WeightBuilder.aWeight;

@Generated("PojoBuilder")
public class MineralAmountBuilder extends AbstractMineralAmountBuilder {

    private MineralAmountBuilder() {
    }

    public static MineralAmountBuilder aMineralAmount() {
        return new MineralAmountBuilder().withAmount(aWeight().build());
    }
}
