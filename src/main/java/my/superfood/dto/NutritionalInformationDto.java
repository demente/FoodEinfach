package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NutritionalInformationDto {

    @JsonProperty
    private Long calories;
    @JsonProperty
    private WeightDto protein;
    @JsonProperty
    private WeightDto fat;
    @JsonProperty
    private WeightDto carbohydrates;
    @JsonProperty
    private WeightDto sugar;
    @JsonProperty
    private WeightDto fibre;
    @JsonProperty
    private List<VitaminDto> vitamins;
    @JsonProperty
    private List<MineralAmountDto> minerals;

    public Long getCalories() {
        return calories;
    }

    public void setCalories(Long calories) {
        this.calories = calories;
    }

    public WeightDto getProtein() {
        return protein;
    }

    public void setProtein(WeightDto protein) {
        this.protein = protein;
    }

    public WeightDto getFat() {
        return fat;
    }

    public void setFat(WeightDto fat) {
        this.fat = fat;
    }

    public WeightDto getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(WeightDto carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public WeightDto getSugar() {
        return sugar;
    }

    public void setSugar(WeightDto sugar) {
        this.sugar = sugar;
    }

    public WeightDto getFibre() {
        return fibre;
    }

    public void setFibre(WeightDto fibre) {
        this.fibre = fibre;
    }

    public List<VitaminDto> getVitamins() {
        return vitamins;
    }

    public void setVitamins(List<VitaminDto> vitamins) {
        this.vitamins = vitamins;
    }

    public List<MineralAmountDto> getMinerals() {
        return minerals;
    }

    public void setMinerals(List<MineralAmountDto> minerals) {
        this.minerals = minerals;
    }
}
