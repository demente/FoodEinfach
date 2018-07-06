package my.superfood.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Embeddable
public class NutritionalInformation {

    private Long protein;
    private Long fat;
    private Long carbohydrates;
    private Long sugar;
    private Long fibre;
    private Long calories;

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
