package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import my.superfood.model.enums.MineralName;

public class MineralAmountDto {

    @JsonProperty
    private Long id;

    @JsonProperty
    private MineralName name;

    @JsonProperty
    private WeightDto amount;

    @JsonProperty
    private WeightDto dailyNorm;

    public MineralName getName() {
        return name;
    }

    public void setName(MineralName name) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
