package axa.partners.services;

import axa.partners.dto.CustomerDTO;
import axa.partners.entities.Customer;

public interface CustomerServiceInterface {
	public Customer createCustomerEnrollment(CustomerDTO customerDTO);
}
