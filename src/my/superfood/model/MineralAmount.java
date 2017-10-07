package my.superfood.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import my.superfood.model.enums.Mineral;

@Entity
public class MineralAmount implements Serializable {
	@Enumerated(EnumType.STRING)
	@Id
	Mineral name;
	@Id
	Long amount;

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
