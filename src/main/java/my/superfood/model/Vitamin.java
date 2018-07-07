package my.superfood.model;

import my.superfood.model.enums.VitaminName;

import javax.persistence.*;

@Entity
public class Vitamin {

    @Id
    @Enumerated(EnumType.STRING)
    private VitaminName name;
    private Long dailyNorm;

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
