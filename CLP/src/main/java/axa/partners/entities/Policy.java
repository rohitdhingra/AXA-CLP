package axa.partners.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import axa.partners.dto.PolicyDTO;

@Entity
@Table(name="Policy")
public class Policy {

	@Id
	@Column(name="policy_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;
	
	@Column(name="policy_type_code")
	private String policyTypeCode;
	
	@Column(name="start_date")
	private String startDate;
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Column(name="end_date")
	private String endDate;
	
	public Policy(Customer customer2, PolicyDTO policyDTO) {
		this.customer = customer2;
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
	@JoinColumn(name="customer_id")
	private Customer customer;
}
