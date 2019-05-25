package axa.partners.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import axa.partners.dto.PolicyDTO;

@Entity
public class Policy {

	@Id
	@Column(name="policy_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;
	
	@Column(name="policy_type_code")
	private String policyTypeCode;
	
	public Policy(PolicyDTO policyDTO) {
		this.setPolicyTypeCode(policyDTO.getPolicyTypeCode());
	}

	public String getPolicyTypeCode() {
		return policyTypeCode;
	}

	public void setPolicyTypeCode(String policyTypeCode) {
		this.policyTypeCode = policyTypeCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne
	private Customer customer;
}
