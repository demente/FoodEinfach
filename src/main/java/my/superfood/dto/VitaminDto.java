package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import my.superfood.model.enums.VitaminName;

public class VitaminDto {

    @JsonProperty
    private VitaminName name;

    @JsonProperty
    private WeightDto dailyNorm;

    public VitaminName getName() {
        return name;
    }

    public void setName(VitaminName name) {
        this.name = name;
    }

    public WeightDto getDailyNorm() {
        return dailyNorm;
    }

    public void setDailyNorm(WeightDto dailyNorm) {
        this.dailyNorm = dailyNorm;
    }
}
