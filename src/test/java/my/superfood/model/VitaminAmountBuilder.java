package my.superfood.model;

import javax.annotation.Generated;

import static my.superfood.model.VitaminBuilder.aVitamin;

@Generated("PojoBuilder")
public class VitaminAmountBuilder extends AbstractVitaminAmountBuilder {

    private VitaminAmountBuilder() {
    }

    public static VitaminAmountBuilder aVitaminAmount() {
        return new VitaminAmountBuilder().withId(1L).withVitamin(aVitamin().build()).withAmount(10L);
    }
}
