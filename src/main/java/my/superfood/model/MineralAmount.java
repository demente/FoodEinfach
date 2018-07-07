package my.superfood.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mineral_amount")
public class MineralAmount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mineralIdGenerator")
    @SequenceGenerator(name = "mineralIdGenerator", sequenceName = "mineral_amount_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mineral_name")
    private Mineral mineral;
    private Long amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mineral getMineral() {
        return mineral;
    }

    public void setMineral(Mineral mineral) {
        this.mineral = mineral;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
