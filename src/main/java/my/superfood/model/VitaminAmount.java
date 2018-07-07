package my.superfood.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vitamin_amount")
public class VitaminAmount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vitaminIdGenerator")
    @SequenceGenerator(name = "vitaminIdGenerator", sequenceName = "vitamin_amount_id_seq", allocationSize = 1)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vitamin_name")
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
