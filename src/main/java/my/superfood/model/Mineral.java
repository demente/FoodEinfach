package my.superfood.model;

import my.superfood.model.enums.MineralName;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "allMinerals",
                query = "SELECT m FROM Mineral m"),
        @NamedQuery(name = "mineralByName", query = "SELECT m FROM Mineral m where name=:name")})
public class Mineral {

    @Id
    @Enumerated(EnumType.STRING)
    private MineralName name;
    private Long dailyNorm;

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
