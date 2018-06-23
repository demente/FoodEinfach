package my.superfood.model;

import my.superfood.model.enums.Unit;

import javax.annotation.Generated;

@Generated("PojoBuilder")
public class IngredientBuilder extends AbstractIngredientBuilder {

    private IngredientBuilder() {
    }

    public static IngredientBuilder anIngredient() {
        return new IngredientBuilder().withUnit(Unit.GRAM);
    }
}
