package my.superfood.model;

import my.superfood.model.enums.VitaminName;

import javax.annotation.Generated;


@Generated("PojoBuilder")
public class VitaminBuilder extends AbstractVitaminBuilder {

    private VitaminBuilder() {
    }

    public static VitaminBuilder aVitamin() {
        return new VitaminBuilder().withName(VitaminName.A).withDailyNorm(600L);
    }
}
