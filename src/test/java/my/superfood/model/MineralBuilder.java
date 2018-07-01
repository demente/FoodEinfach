package my.superfood.model;

import my.superfood.model.enums.MineralName;

import javax.annotation.Generated;


@Generated("PojoBuilder")
public class MineralBuilder extends AbstractMineralBuilder {

    private MineralBuilder() {
    }

    public static MineralBuilder aMineral() {
        return new MineralBuilder().withId(1L).withName(MineralName.Ca).withDailyNorm(1000000L);
    }
}
