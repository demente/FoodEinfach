package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MineralDto {

    @JsonProperty
    private String name;
    @JsonProperty
    private WeightDto dailyNorm;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeightDto getDailyNorm() {
        return dailyNorm;
    }

    public void setDailyNorm(WeightDto dailyNorm) {
        this.dailyNorm = dailyNorm;
    }
}
