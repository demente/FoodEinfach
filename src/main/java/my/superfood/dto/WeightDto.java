package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeightDto {

    @JsonProperty
    private Double weight;
    @JsonProperty
    private String unit;

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
