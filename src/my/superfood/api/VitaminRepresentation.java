package my.superfood.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import my.superfood.model.enums.Vitamin;

public class VitaminRepresentation {

    @JsonProperty
    private Vitamin name;
    @JsonProperty
    private Long amount;

    public Vitamin getName() {
        return name;
    }

    public void setName(Vitamin name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
