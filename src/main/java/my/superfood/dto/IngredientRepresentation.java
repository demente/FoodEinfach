package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IngredientRepresentation {

    @JsonProperty
    private FoodShortRepresentation food;
    @JsonProperty
    private Long amount;
    @JsonProperty
    private String unit;

    public FoodShortRepresentation getFood() {
        return food;
    }

    public void setFood(FoodShortRepresentation food) {
        this.food = food;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
