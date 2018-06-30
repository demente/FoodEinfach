package my.superfood.model;

import my.superfood.model.enums.Unit;

import javax.annotation.Generated;


@Generated("PojoBuilder")
public class MineralAmountBuilder extends AbstractMineralAmountBuilder {

    private MineralAmountBuilder() {
    }

    public static MineralAmountBuilder aMineralAmount() {
        return new MineralAmountBuilder().withAmount(12L);
    }
}
