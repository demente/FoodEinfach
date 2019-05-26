package my.superfood.model;

import my.superfood.model.enums.FoodType;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "food")
@NamedQueries({
        @NamedQuery(name = "allFood",
                query = "SELECT f FROM Food f where active is true and type is NOT null"),
        @NamedQuery(name = "foodByName",
                query = "SELECT f FROM Food f where lower(name) like concat(lower(:name),'%') and active is true"),
        @NamedQuery(name = "foodByMineral", query = "SELECT f FROM Food as f " +
                "JOIN f.nutritionPerHundredGrams.minerals as ma " +
                "with ma.mineral.name=:name " +
                "where f.active is true order by ma.amount desc"),
        @NamedQuery(name = "foodByVitamin", query = "SELECT f FROM Food as f " +
                "JOIN f.nutritionPerHundredGrams.vitamins as v " +
                "with v.vitamin.name=:name " +
                "where f.active is true order by v.amount desc")})
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Column(nullable = false)
    private String name;
    @Embedded
    private NutritionalInformation nutritionPerHundredGrams;
    private Long weight;
    @Enumerated(EnumType.STRING)
    private FoodType type;
    private boolean active;
    @Column(name = "piece_name")
    private String pieceName;
    @Column(name = "min_weight")
    private Long minimumWeight;
    @Column(name = "min_weight_price")
    private Long pricePerMinimumWeightInCents;
    private String minimumPackageName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public NutritionalInformation getNutritionPerHundredGrams() {
        return nutritionPerHundredGrams;
    }

    public void setNutritionPerHundredGrams(NutritionalInformation nutritionPerHundredGrams) {
        this.nutritionPerHundredGrams = nutritionPerHundredGrams;
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPieceName() {
        return pieceName;
    }

    public void setPieceName(String pieceName) {
        this.pieceName = pieceName;
    }

    public Long getMinimumWeight() {
        return minimumWeight;
    }

    public void setMinimumWeight(Long minimumWeight) {
        this.minimumWeight = minimumWeight;
    }

    public Long getPricePerMinimumWeightInCents() {
        return pricePerMinimumWeightInCents;
    }

    public void setPricePerMinimumWeightInCents(Long pricePerMinimumWeightInCents) {
        this.pricePerMinimumWeightInCents = pricePerMinimumWeightInCents;
    }

    public String getMinimumPackageName() {
        return minimumPackageName;
    }

    public void setMinimumPackageName(String minimumPackageName) {
        this.minimumPackageName = minimumPackageName;
    }
}

