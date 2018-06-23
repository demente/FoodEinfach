package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import my.superfood.model.enums.Vitamin;

public class VitaminDto {

    @JsonProperty
    private Long id;
    @JsonProperty
    private Vitamin name;
    @JsonProperty
    private WeightDto amount;
    @JsonProperty
    private WeightDto dailyNorm;

    public Vitamin getName() {
        return name;
    }

    public void setName(Vitamin name) {
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
