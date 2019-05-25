package axa.partners.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import axa.partners.dto.CustomerDTO;

@Entity
public class Customer {

	public Customer(CustomerDTO customerDTO) {
		this.setFirstName(customerDTO.getFirstName());
		this.getAddress().add(new Address(customerDTO.getAddressDTO()));
		this.getPolicies().add(new Policy(customerDTO.getPolicyDTO()));
	}

	@Id
	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "first_name")
	private String firstName;

	@OneToMany(mappedBy="customer")
	private List<Address> address;
	
	@OneToMany(mappedBy="customer")
	private List<Policy> policies;
	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
