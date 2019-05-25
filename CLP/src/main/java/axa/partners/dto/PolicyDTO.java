package axa.partners.dto;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PolicyDTO {

	private String policyTypeCode;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date startDate;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date endDate;
	

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

	public String getPolicyTypeCode() {
		return policyTypeCode;
	}

	public void setPolicyTypeCode(String policyTypeCode) {
		this.policyTypeCode = policyTypeCode;
	}

	@Override
	public String toString() {
		return "PolicyDTO [policyTypeCode=" + policyTypeCode + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}

	
}
