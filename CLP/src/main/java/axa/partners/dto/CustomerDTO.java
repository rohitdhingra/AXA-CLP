package axa.partners.dto;

public class CustomerDTO {
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	
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
