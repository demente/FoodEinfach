package my.superfood.model;

import my.superfood.model.Food;
import net.karneim.pojobuilder.GeneratePojoBuilder;

public class EntityFactory {

    private EntityFactory() {
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static Food newFood() {
        return new Food();
    }

}
