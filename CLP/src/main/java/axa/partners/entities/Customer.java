package axa.partners.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import axa.partners.dto.CustomerDTO;

@Entity
@Table(name="Customer")
public class Customer {

	public Customer(CustomerDTO customerDTO) {
		this.setFirstName(customerDTO.getFirstName());
		this.setMiddleName(customerDTO.getMiddleName());
		this.setLastName(customerDTO.getLastName());
		this.setDateOfBirth(customerDTO.getDateOfBirth());
		this.setGender(customerDTO.getGender());
		this.getAddress().add(new Address(this,customerDTO.getAddressDTO()));
		this.getPolicies().add(new Policy(this,customerDTO.getPolicyDTO()));
	}

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "gender")
	private String gender;
	
	@Column(name = "date_Of_Birth")
	private String dateOfBirth;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	private List<Address> address = new ArrayList<Address>();
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	private List<Policy> policies= new ArrayList<Policy>();
	
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
