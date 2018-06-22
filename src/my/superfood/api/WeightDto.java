package my.superfood.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeightDto {

    @JsonProperty
    private Long weight;
    @JsonProperty
    private String unit;

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
