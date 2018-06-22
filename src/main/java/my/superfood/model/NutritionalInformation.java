package my.superfood.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Embeddable
public class NutritionalInformation {

    private Weight protein;
    private Weight saturatedFat;
    private Weight nonSaturatedFat;
    private Weight carbohydrates;
    private Weight sugar;
    private Weight fibre;
    private Long calories;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "food_id")
    private List<VitaminAmount> vitamins;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "food_id")
    private List<MineralAmount> minerals;

    public Weight getProtein() {
        return protein;
    }

    public void setProtein(Weight protein) {
        this.protein = protein;
    }

    public Weight getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(Weight saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public Weight getNonSaturatedFat() {
        return nonSaturatedFat;
    }

    public void setNonSaturatedFat(Weight nonSaturatedFat) {
        this.nonSaturatedFat = nonSaturatedFat;
    }

    public Weight getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Weight carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Weight getSugar() {
        return sugar;
    }

    public void setSugar(Weight sugar) {
        this.sugar = sugar;
    }

    public Weight getFibre() {
        return fibre;
    }

    public void setFibre(Weight fibre) {
        this.fibre = fibre;
    }

    public Long getCalories() {
        return calories;
    }

    public void setCalories(Long calories) {
        this.calories = calories;
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
