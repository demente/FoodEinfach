package my.superfood.model;

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

    @Enumerated(EnumType.STRING)
    Vitamin name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long amount;

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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
