package axa.partners.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import axa.partners.dto.CustomerDTO;

@Entity
public class Customer {

	public Customer(CustomerDTO customerDTO) {
		this.setFirstName(customerDTO.getFirstName());
	}

	@Id
	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "first_name")
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
