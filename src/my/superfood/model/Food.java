package my.superfood.model;

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

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import my.superfood.model.enums.FoodCategory;

@Entity
@Table(name = "food")
@NamedQueries({ @NamedQuery(name = "foodByRecipeId",
                            query = "SELECT f FROM Food f join Ingredient i on f.id=i.food.id where i.recipe.id=:recipeId"),
                @NamedQuery(name = "foodByName",
                            query = "SELECT f FROM Food f where name like concat(:name,'%')") })
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@NotNull
	@Column(nullable = false)
	String name;

	Integer weightPerServing;
	@Embedded
	NutritionalInformation nutritionPerHundredGrams;

    @Enumerated(EnumType.STRING)
    FoodCategory category;

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

	public Integer getWeightPerServing() {
		return weightPerServing;
	}

	public void setWeightPerServing(Integer weightPerServing) {
		this.weightPerServing = weightPerServing;
	}

	public NutritionalInformation getNutritionPerHundredGrams() {
		return nutritionPerHundredGrams;
	}

	public void setNutritionPerHundredGrams(NutritionalInformation nutritionPerHundredGrams) {
		this.nutritionPerHundredGrams = nutritionPerHundredGrams;
	}

    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
        this.category = category;
    }

}
