package axa.partners.dto;

public class JWTResponseDTO {
	private final String jwttoken;

	public JWTResponseDTO(String jwttoken) {
		super();
		this.jwttoken = jwttoken;
	}

	public String getJwttoken() {
		return jwttoken;
	}

}
