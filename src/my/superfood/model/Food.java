package my.superfood.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "food")
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

}
