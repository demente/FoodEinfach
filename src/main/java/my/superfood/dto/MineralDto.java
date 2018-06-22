package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import my.superfood.model.enums.Mineral;

public class MineralDto {

    @JsonProperty
    private Mineral name;

    @JsonProperty
    private WeightDto amount;

    @JsonProperty
    private WeightDto dailyNorm;

    public Mineral getName() {
        return name;
    }

    public void setName(Mineral name) {
        this.name = name;
    }

    public WeightDto getAmount() {
        return amount;
    }

    public void setAmount(WeightDto amount) {
        this.amount = amount;
    }

    public WeightDto getDailyNorm() {
        return dailyNorm;
    }

    public void setDailyNorm(WeightDto dailyNorm) {
        this.dailyNorm = dailyNorm;
    }
}
