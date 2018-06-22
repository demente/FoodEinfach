package my.superfood.dto;

import my.superfood.dto.FoodDto;
import net.karneim.pojobuilder.GeneratePojoBuilder;

public class DtoFactory {

    private DtoFactory() {
    }

    @GeneratePojoBuilder(withGenerationGap = true)
    public static FoodDto newFoodDto() {
        return new FoodDto();
    }

}
