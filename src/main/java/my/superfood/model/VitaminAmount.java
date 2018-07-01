package my.superfood.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class VitaminAmount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vitamin_id")
    private Vitamin vitamin;
    private Long amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vitamin getVitamin() {
        return vitamin;
    }

    public void setVitamin(Vitamin vitamin) {
        this.vitamin = vitamin;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
