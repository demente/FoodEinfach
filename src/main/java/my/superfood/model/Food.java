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
                query = "SELECT f FROM Food f"),
        @NamedQuery(name = "foodByName",
                query = "SELECT f FROM Food f where lower(name) like concat(lower(:name),'%')")})
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

}

