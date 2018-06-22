package my.superfood.model;

import my.superfood.model.enums.FoodType;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "food")
@NamedQueries({@NamedQuery(name = "foodByRecipeId",
        query = "SELECT f FROM Food f join Ingredient i on f.id=i.food.id where i.recipe.id=:recipeId"),
        @NamedQuery(name = "foodByName",
                query = "SELECT f FROM Food f where lowercase(name) like concat(lowercase(:name),'%')")})
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Column(nullable = false)
    private String name;
    @Embedded
    private NutritionalInformation nutritionPerHundredGrams;
    private Weight weightPerServing;

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

    public Weight getWeightPerServing() {
        return weightPerServing;
    }

    public void setWeightPerServing(Weight weightPerServing) {
        this.weightPerServing = weightPerServing;
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
