package my.superfood.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
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
    @JoinColumn(name = "food_id", nullable = false)
    private List<VitaminAmount> vitamins;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "food_id", nullable = false)
    private List<MineralAmount> minerals;

    public NutritionalInformation() {
        this.protein = 0L;
        this.fat = 0L;
        this.carbohydrates = 0L;
        this.sugar = 0L;
        this.fibre = 0L;
        this.calories = 0L;
        this.minerals = new ArrayList<>();
        this.vitamins = new ArrayList<>();
    }

    public NutritionalInformation(Long protein, Long fat, Long carbohydrates, Long sugar, Long fibre, Long calories) {
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.sugar = sugar;
        this.fibre = fibre;
        this.calories = calories;
        this.minerals = new ArrayList<>();
        this.vitamins = new ArrayList<>();
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

    public void addNutritionalInformation(NutritionalInformation other) {
        setCalories(getCalories() + other.getCalories());
        setProtein(getProtein() + other.getProtein());
        setCarbohydrates(getCarbohydrates() + other.getCarbohydrates());
        setFat(getFat() + other.getFat());
        setFibre(getFibre() + other.getFibre());
        setSugar(getSugar() + other.getSugar());
        for (VitaminAmount vitaminAmount : other.getVitamins()) {
            addVitaminAmount(getVitamins(), vitaminAmount);
        }
        for (MineralAmount mineralAmount : other.getMinerals()) {
            addMineralAmount(getMinerals(), mineralAmount);
        }
    }

    public void divide(double divider) {
        setCalories(Math.round(getCalories() / divider));
        setProtein(Math.round(getProtein() / divider));
        setCarbohydrates(Math.round(getCarbohydrates() / divider));
        setFat(Math.round(getFat() / divider));
        setFibre(Math.round(getFibre() / divider));
        setSugar(Math.round(getSugar() / divider));
        for (VitaminAmount vitaminAmount : getVitamins()) {
            vitaminAmount.setAmount(Math.round(vitaminAmount.getAmount() / divider));
        }
        for (MineralAmount mineralAmount : getMinerals()) {
            mineralAmount.setAmount(Math.round(mineralAmount.getAmount() / divider));
        }

    }

    private void addVitaminAmount(List<VitaminAmount> vitaminAmountList, VitaminAmount vitaminToAdd) {
        boolean isFound = false;
        for (VitaminAmount vitamin : vitaminAmountList) {
            if (vitamin.getVitamin().getName().equals(vitaminToAdd.getVitamin().getName())) {
                vitamin.setAmount(vitamin.getAmount() + vitaminToAdd.getAmount());
                isFound = true;
            }
        }
        if (!isFound) {
            VitaminAmount vitaminAmount = new VitaminAmount();
            vitaminAmount.setAmount(vitaminToAdd.getAmount());
            vitaminAmount.setVitamin(vitaminToAdd.getVitamin());
            vitaminAmountList.add(vitaminAmount);
        }
    }


    private void addMineralAmount(List<MineralAmount> mineralList, MineralAmount mineralToAdd) {
        boolean isFound = false;
        for (MineralAmount mineral : mineralList) {
            if (mineral.getMineral().getName().equals(mineralToAdd.getMineral().getName())) {
                mineral.setAmount(mineral.getAmount() + mineralToAdd.getAmount());
                isFound = true;
            }
        }
        if (!isFound) {
            MineralAmount mineralAmount = new MineralAmount();
            mineralAmount.setAmount(mineralToAdd.getAmount());
            mineralAmount.setMineral(mineralToAdd.getMineral());
            mineralList.add(mineralAmount);
        }
    }
}
