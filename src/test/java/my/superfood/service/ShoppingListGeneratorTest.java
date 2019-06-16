package my.superfood.service;

import my.superfood.dto.ShoppingListElement;
import my.superfood.model.FoodAmount;
import my.superfood.model.Ingredient;
import my.superfood.model.MealPlan;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static my.superfood.model.FoodBuilder.aFood;
import static my.superfood.model.IngredientBuilder.anIngredient;
import static my.superfood.model.MealPlanBuilder.aMealPlan;
import static my.superfood.model.MealPlanRecipeBuilder.aMealPlanRecipe;
import static my.superfood.model.RecipeBuilder.aRecipe;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class ShoppingListGeneratorTest {

    private ShoppingListGenerator shoppingListGenerator = new ShoppingListGenerator();

    @Test
    public void generatesShoppingList(){
        Ingredient ingredient = anIngredient().withFood(aFood().withId(1L)
                .withName("Milk")
                .withMinimumPackageName("pack")
                .withPricePerMinimumWeightInCents(240L)
                .withMinimumWeight(1000000000L).build())
                .withAmount(1000000000L).build();

        Ingredient ingredient2 = anIngredient().withFood(aFood().withId(2L)
                .withName("Eggs")
                .withMinimumPackageName("eggs")
                .withPricePerMinimumWeightInCents(125L)
                .withMinimumWeight(2000000000L).build())
                .withAmount(20000000000L).build();

        MealPlan mealPlan = aMealPlan().withRecipes(asList(aMealPlanRecipe()
                        .withRecipe(aRecipe().withServings(1L)
                                .withIngredients(asList(ingredient)).build()
                        ).build(),
                aMealPlanRecipe()
                        .withRecipe(aRecipe().withServings(2L)
                                .withIngredients(asList(ingredient2, ingredient)).build()
                        ).build())).build();

        List<ShoppingListElement> elements = shoppingListGenerator.generateShoppingList(mealPlan);
        assertThat(elements).extracting(ShoppingListElement::getAmount).containsExactly(2L, 5L);
        assertThat(elements).extracting(ShoppingListElement::getPackageName).containsExactly("pack", "eggs");
        assertThat(elements).extracting(ShoppingListElement::getPrice).containsExactly(4.80, 6.25);

    }

}