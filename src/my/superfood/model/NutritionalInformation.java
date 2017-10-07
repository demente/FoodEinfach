package my.superfood.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Embeddable
public class NutritionalInformation {
	Long protein;
	Long fat;
	Long carbohydrates;
	Long fiber;
	Long calories;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "food_id")
	List<VitaminAmount> vitamins;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "food_id")
	List<MineralAmount> minerals;

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

	public List<VitaminAmount> getVitamins() {
		return vitamins;
	}

	public void setVitamins(List<VitaminAmount> vitamins) {
		this.vitamins = vitamins;
	}

	public List<MineralAmount> getMinerals() {
		return minerals;
	}

	public void setMinerals(List<MineralAmount> minerals) {
		this.minerals = minerals;
	}

	public Long getCalories() {
		return calories;
	}

	public void setCalories(Long calories) {
		this.calories = calories;
	}

}
