package axa.partners.entities;

import java.util.Date;

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
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name="start_date")
	private Date startDate;
	

	@Column(name="end_date")
	private Date endDate;
	
	public Policy(Customer customer2, PolicyDTO policyDTO) {
		this.customer = customer2;
		this.setPolicyTypeCode(policyDTO.getPolicyTypeCode());
		this.setStartDate(policyDTO.getStartDate());
		this.setEndDate(policyDTO.getEndDate());
		
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
