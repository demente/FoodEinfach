package my.superfood.model;

import javax.annotation.Generated;

import static my.superfood.model.MineralBuilder.aMineral;


@Generated("PojoBuilder")
public class MineralAmountBuilder extends AbstractMineralAmountBuilder {

    private MineralAmountBuilder() {
    }

    public static MineralAmountBuilder aMineralAmount() {
        return new MineralAmountBuilder().withAmount(12L).withId(1L).withMineral(aMineral().build());
    }

    public static MineralAmountBuilder aNewMineralAmount() {
        return aMineralAmount().withId(null);
    }
}
