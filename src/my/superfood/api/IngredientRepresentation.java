package my.superfood.api;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class IngredientRepresentation {

	@JsonProperty
	FoodShortRepresentation food;
	@JsonProperty
	Long amount;
	@JsonProperty
	String metric;

	public FoodShortRepresentation getFood() {
		return food;
	}

	public void setFood(FoodShortRepresentation food) {
		this.food = food;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

}
