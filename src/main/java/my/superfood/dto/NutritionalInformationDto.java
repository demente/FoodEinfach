package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NutritionalInformationDto {

    @JsonProperty
    private Long calories;
    @JsonProperty
    private WeightDto protein;
    @JsonProperty
    private WeightDto saturatedFat;
    @JsonProperty
    private WeightDto nonSaturatedFat;
    @JsonProperty
    private WeightDto carbohydrate;
    @JsonProperty
    private WeightDto sugar;
    @JsonProperty
    private WeightDto fibre;
    @JsonProperty
    private List<VitaminDto> vitamins;
    @JsonProperty
    private List<MineralDto> minerals;

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

    public WeightDto getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(WeightDto saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public WeightDto getNonSaturatedFat() {
        return nonSaturatedFat;
    }

    public void setNonSaturatedFat(WeightDto nonSaturatedFat) {
        this.nonSaturatedFat = nonSaturatedFat;
    }

    public WeightDto getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(WeightDto carbohydrate) {
        this.carbohydrate = carbohydrate;
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

    public List<MineralDto> getMinerals() {
        return minerals;
    }

    public void setMinerals(List<MineralDto> minerals) {
        this.minerals = minerals;
    }
}
