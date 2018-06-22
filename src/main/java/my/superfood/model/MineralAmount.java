package my.superfood.model;

import my.superfood.model.enums.Mineral;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class MineralAmount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Mineral name;
    private Weight amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mineral getName() {
        return name;
    }

    public void setName(Mineral name) {
        this.name = name;
    }

    public Weight getAmount() {
        return amount;
    }

    public void setAmount(Weight amount) {
        this.amount = amount;
    }

}
