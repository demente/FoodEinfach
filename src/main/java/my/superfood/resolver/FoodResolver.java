package my.superfood.resolver;

import my.superfood.dao.FoodDao;
import my.superfood.model.Food;

public class FoodResolver {

    private final FoodDao foodDao;

    public FoodResolver(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    public Food toFood(Long id) {
        return foodDao.findById(id);
    }
}
