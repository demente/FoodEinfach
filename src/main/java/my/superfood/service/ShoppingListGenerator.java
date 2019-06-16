package my.superfood.service;

import my.superfood.dto.ShoppingListElement;
import my.superfood.model.FoodAmount;
import my.superfood.model.MealPlan;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListGenerator {
    public List<ShoppingListElement> generateShoppingList(MealPlan mealPlan) {
        List<ShoppingListElement> elements = new ArrayList<>();
        for (FoodAmount food : mealPlan.getIngredients()) {
            String name = food.getFood().getName();
            String packageName = food.getFood().getMinimumPackageName();
            double amount = Math.ceil(food.getAmount() * 1.0 / food.getFood().getMinimumWeight() * 1.0);
            double price = (Double.valueOf(food.getFood().getPricePerMinimumWeightInCents()* (long) amount / 100.00));
            elements.add(new ShoppingListElement(name, packageName, (long) amount, price));
        }
        return elements;
    }
}
