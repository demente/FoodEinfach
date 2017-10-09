package my.superfood.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import my.superfood.model.enums.Vitamin;

//all amounts here and elsewhere in micrograms (10^-6)
@Entity
public class VitaminAmount implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Enumerated(EnumType.STRING)
	Vitamin name;
	Long amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vitamin getName() {
		return name;
	}

	public void setName(Vitamin name) {
		this.name = name;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
