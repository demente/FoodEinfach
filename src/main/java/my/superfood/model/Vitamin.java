package my.superfood.model;

import my.superfood.model.enums.VitaminName;

import javax.persistence.*;

@Entity
public class Vitamin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private VitaminName name;
    private Long dailyNorm;

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

    public Long getDailyNorm() {
        return dailyNorm;
    }

    public void setDailyNorm(Long dailyNorm) {
        this.dailyNorm = dailyNorm;
    }
}
