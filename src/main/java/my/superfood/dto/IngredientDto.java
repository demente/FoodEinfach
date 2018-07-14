package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IngredientDto {

    @JsonProperty
    private Long id;
    @JsonProperty
    private FoodDto food;
    @JsonProperty
    private Long recipeId;
    @JsonProperty
    private WeightDto amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FoodDto getFood() {
        return food;
    }

    public void setFood(FoodDto food) {
        this.food = food;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public WeightDto getAmount() {
        return amount;
    }

    public void setAmount(WeightDto amount) {
        this.amount = amount;
    }
}
