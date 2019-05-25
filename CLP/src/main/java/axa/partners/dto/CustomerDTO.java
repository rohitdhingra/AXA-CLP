package axa.partners.dto;

public class CustomerDTO {
	private String firstName;
	
	private AddressDTO addressDTO;
	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	private PolicyDTO policyDTO;
	

	@Override
	public String toString() {
		return "CustomerDTO [firstName=" + firstName + ", addressDTO=" + addressDTO + ", policyDTO=" + policyDTO + "]";
	}

	public PolicyDTO getPolicyDTO() {
		return policyDTO;
	}

	public void setPolicyDTO(PolicyDTO policyDTO) {
		this.policyDTO = policyDTO;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
