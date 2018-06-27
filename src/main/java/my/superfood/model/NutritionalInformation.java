package my.superfood.model;

import my.superfood.model.enums.Unit;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Embeddable
public class NutritionalInformation {

    private Long protein;
    private Long saturatedFat;
    private Long nonSaturatedFat;
    private Long carbohydrates;
    private Long sugar;
    private Long fibre;
    private Long calories;
    @Enumerated(EnumType.STRING)
    private Unit proteinUnit;
    @Enumerated(EnumType.STRING)
    private Unit saturatedFatUnit;
    @Enumerated(EnumType.STRING)
    private Unit nonSaturatedFatUnit;
    @Enumerated(EnumType.STRING)
    private Unit carbohydratesUnit;
    @Enumerated(EnumType.STRING)
    private Unit sugarUnit;
    @Enumerated(EnumType.STRING)
    private Unit fibreUnit;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "food_id")
    private List<VitaminAmount> vitamins;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "food_id")
    private List<MineralAmount> minerals;

    public Long getProtein() {
        return protein;
    }

    public void setProtein(Long protein) {
        this.protein = protein;
    }

    public Long getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(Long saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public Long getNonSaturatedFat() {
        return nonSaturatedFat;
    }

    public void setNonSaturatedFat(Long nonSaturatedFat) {
        this.nonSaturatedFat = nonSaturatedFat;
    }

    public Long getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Long carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Long getSugar() {
        return sugar;
    }

    public void setSugar(Long sugar) {
        this.sugar = sugar;
    }

    public Long getFibre() {
        return fibre;
    }

    public void setFibre(Long fibre) {
        this.fibre = fibre;
    }

    public Long getCalories() {
        return calories;
    }

    public void setCalories(Long calories) {
        this.calories = calories;
    }

    public Unit getProteinUnit() {
        return proteinUnit;
    }

    public void setProteinUnit(Unit proteinUnit) {
        this.proteinUnit = proteinUnit;
    }

    public Unit getSaturatedFatUnit() {
        return saturatedFatUnit;
    }

    public void setSaturatedFatUnit(Unit saturatedFatUnit) {
        this.saturatedFatUnit = saturatedFatUnit;
    }

    public Unit getNonSaturatedFatUnit() {
        return nonSaturatedFatUnit;
    }

    public void setNonSaturatedFatUnit(Unit nonSaturatedFatUnit) {
        this.nonSaturatedFatUnit = nonSaturatedFatUnit;
    }

    public Unit getCarbohydratesUnit() {
        return carbohydratesUnit;
    }

    public void setCarbohydratesUnit(Unit carbohydratesUnit) {
        this.carbohydratesUnit = carbohydratesUnit;
    }

    public Unit getSugarUnit() {
        return sugarUnit;
    }

    public void setSugarUnit(Unit sugarUnit) {
        this.sugarUnit = sugarUnit;
    }

    public Unit getFibreUnit() {
        return fibreUnit;
    }

    public void setFibreUnit(Unit fibreUnit) {
        this.fibreUnit = fibreUnit;
    }

    public List<VitaminAmount> getVitamins() {
        return vitamins;
    }

    public void setVitamins(List<VitaminAmount> vitamins) {
        this.vitamins = vitamins;
    }

    public List<MineralAmount> getMinerals() {
        return minerals;
    }

    public void setMinerals(List<MineralAmount> minerals) {
        this.minerals = minerals;
    }
}
