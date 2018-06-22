package my.superfood.model;

import my.superfood.dto.WeightDto;
import my.superfood.model.enums.Vitamin;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//all amounts here and elsewhere in micrograms (10^-6)
@Entity
public class VitaminAmount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Vitamin name;
    private WeightDto amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

}
