package axa.partners.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import axa.partners.dto.AddressDTO;

@Entity
@Table(name="Address")
public class Address {

	public Address(Customer customer2, AddressDTO addressDTO) {
		this.customer= customer2;
		this.setAddress1(addressDTO.getAddress1());
		this.setAddress2(addressDTO.getAddress2());
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;
	
	@Column(name="address_1")
	private String address1;
	
	@Column(name="address_2")
	private String address2;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
}
