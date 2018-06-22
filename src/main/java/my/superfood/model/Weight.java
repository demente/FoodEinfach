package my.superfood.model;

import my.superfood.model.enums.Unit;

public class Weight {

    private Long weight;
    private Unit unit;

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
