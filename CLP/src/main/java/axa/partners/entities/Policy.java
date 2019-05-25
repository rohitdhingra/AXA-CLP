package axa.partners.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Policy {

	@Id
	@Column(name="policy_id")
	private Long policyId;
}
