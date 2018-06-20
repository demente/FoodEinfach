package my.superfood.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class FoodRepresentation {

    @JsonProperty
    private String name;
    @JsonProperty
    private Integer weightPerServing;
    @JsonProperty
    private Long protein;
    @JsonProperty
    private Long fat;
    @JsonProperty
    private Long carbohydrates;
    @JsonProperty
    private Long fiber;
    @JsonProperty
    private Long calories;
    @JsonProperty
    private List<VitaminRepresentation> vitamins;
    @JsonProperty
    private List<MineralRepresentation> minerals;
    @JsonProperty
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeightPerServing() {
        return weightPerServing;
    }

    public void setWeightPerServing(Integer weightPerServing) {
        this.weightPerServing = weightPerServing;
    }

    public Long getProtein() {
        return protein;
    }

    public void setProtein(Long protein) {
        this.protein = protein;
    }

    public Long getFat() {
        return fat;
    }

    public void setFat(Long fat) {
        this.fat = fat;
    }

    public Long getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Long carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Long getFiber() {
        return fiber;
    }

    public void setFiber(Long fiber) {
        this.fiber = fiber;
    }

    public List<VitaminRepresentation> getVitamins() {
        return vitamins;
    }

    public void setVitamins(List<VitaminRepresentation> vitamins) {
        this.vitamins = vitamins;
    }

    public List<MineralRepresentation> getMinerals() {
        return minerals;
    }

    public void setMinerals(List<MineralRepresentation> minerals) {
        this.minerals = minerals;
    }

    public Long getCalories() {
        return calories;
    }

    public void setCalories(Long calories) {
        this.calories = calories;
    }

}
