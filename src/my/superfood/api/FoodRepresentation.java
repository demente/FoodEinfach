package my.superfood.api;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class FoodRepresentation {

	@JsonProperty
	String name;
	@JsonProperty
	Integer weightPerServing;
	@JsonProperty
	Long protein;
	@JsonProperty
	Long fat;
	@JsonProperty
	Long carbohydrates;
	@JsonProperty
	Long fiber;
	@JsonProperty
	Long calories;
	@JsonProperty
	List<VitaminRepresentation> vitamins;
	@JsonProperty
	List<MineralRepresentation> minerals;

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

	public Long getProtein() {
		return protein;
	}

	public void setProtein(Long protein) {
		this.protein = protein;
	}

	public Long getFat() {
		return fat;
	}

	public void setFat(Long fat) {
		this.fat = fat;
	}

	public Long getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(Long carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public Long getFiber() {
		return fiber;
	}

	public void setFiber(Long fiber) {
		this.fiber = fiber;
	}

	public List<VitaminRepresentation> getVitamins() {
		return vitamins;
	}

	public void setVitamins(List<VitaminRepresentation> vitamins) {
		this.vitamins = vitamins;
	}

	public List<MineralRepresentation> getMinerals() {
		return minerals;
	}

	public void setMinerals(List<MineralRepresentation> minerals) {
		this.minerals = minerals;
	}

	public Long getCalories() {
		return calories;
	}

	public void setCalories(Long calories) {
		this.calories = calories;
	}

}
