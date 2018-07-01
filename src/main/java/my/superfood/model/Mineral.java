package my.superfood.model;

import my.superfood.model.enums.MineralName;

import javax.persistence.*;

@Entity
public class Mineral {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private MineralName name;
    private Long dailyNorm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MineralName getName() {
        return name;
    }

    public void setName(MineralName name) {
        this.name = name;
    }

    public Long getDailyNorm() {
        return dailyNorm;
    }

    public void setDailyNorm(Long dailyNorm) {
        this.dailyNorm = dailyNorm;
    }
}
