package my.superfood.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import my.superfood.model.enums.Mineral;

public class MineralRepresentation {

	@JsonProperty
	private Mineral name;

	@JsonProperty
	private Long amount;

	public Mineral getName() {
		return name;
	}

	public void setName(Mineral name) {
		this.name = name;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
