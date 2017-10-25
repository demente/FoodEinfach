package my.superfood.api;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class RecipeRepresentation {

	@JsonProperty
	String name;

	@JsonProperty
	List<IngredientRepresentation> ingredients;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<IngredientRepresentation> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientRepresentation> ingredients) {
		this.ingredients = ingredients;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public Long getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(Long preparationTime) {
		this.preparationTime = preparationTime;
	}

	public Long getPortions() {
		return portions;
	}

	public void setPortions(Long portions) {
		this.portions = portions;
	}

	@JsonProperty
	String instructions;

	@JsonProperty
	List<String> type;

	@JsonProperty
	Long preparationTime; // in minutes

	@JsonProperty
	Long portions; // number of portions or servings

}
