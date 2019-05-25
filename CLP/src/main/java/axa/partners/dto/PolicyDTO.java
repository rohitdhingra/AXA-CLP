package axa.partners.dto;

import java.sql.Date;

public class PolicyDTO {

	private String policyTypeCode;

	private String startDate;
	
	private String endDate;
	

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

	public String getPolicyTypeCode() {
		return policyTypeCode;
	}

	public void setPolicyTypeCode(String policyTypeCode) {
		this.policyTypeCode = policyTypeCode;
	}

	@Override
	public String toString() {
		return "PolicyDTO [policyTypeCode=" + policyTypeCode + "]";
	}
}
