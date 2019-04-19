package my.superfood.model;

import my.superfood.model.enums.Unit;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long amount;
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe; //TODO: do we need it here?

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public NutritionalInformation getNutritionalInformation() {
        NutritionalInformation nutritionPerHundredGrams = getFood().getNutritionPerHundredGrams();
        Double timesHundredGrams = Double.valueOf(getAmount()) / Double.valueOf(Unit.GRAM.getMultiplier() * 100);

        NutritionalInformation nutritionalInformation = new NutritionalInformation();
        nutritionalInformation.setCalories(Math.round(nutritionPerHundredGrams.getCalories() * timesHundredGrams));
        nutritionalInformation.setProtein(Math.round(nutritionPerHundredGrams.getProtein() * timesHundredGrams));
        nutritionalInformation.setCarbohydrates(Math.round(nutritionPerHundredGrams.getCarbohydrates() * timesHundredGrams));
        nutritionalInformation.setFat(Math.round(nutritionPerHundredGrams.getFat() * timesHundredGrams));
        nutritionalInformation.setFibre(Math.round(nutritionPerHundredGrams.getFibre() * timesHundredGrams));
        nutritionalInformation.setSugar(Math.round(nutritionPerHundredGrams.getSugar() * timesHundredGrams));
        nutritionalInformation.setVitamins(new ArrayList<>());
        nutritionalInformation.setMinerals(new ArrayList<>());
        for (VitaminAmount vitaminAmount : getFood().getNutritionPerHundredGrams().getVitamins()) {
            VitaminAmount vitamin = new VitaminAmount();
            vitamin.setVitamin(vitaminAmount.getVitamin());
            vitamin.setAmount(Math.round(vitaminAmount.getAmount() * timesHundredGrams));
            nutritionalInformation.getVitamins().add(vitamin);
        }
        for (MineralAmount mineralAmount : getFood().getNutritionPerHundredGrams().getMinerals()) {
            MineralAmount mineral = new MineralAmount();
            mineral.setMineral(mineralAmount.getMineral());
            mineral.setAmount(Math.round(mineralAmount.getAmount() * timesHundredGrams));
            nutritionalInformation.getMinerals().add(mineral);
        }

        return nutritionalInformation;
    }
}
