package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import my.superfood.model.enums.VitaminName;

public class VitaminAmountDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private VitaminName name;
    @JsonProperty
    private WeightDto amount;
    @JsonProperty
    private WeightDto dailyNorm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VitaminName getName() {
        return name;
    }

    public void setName(VitaminName name) {
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

