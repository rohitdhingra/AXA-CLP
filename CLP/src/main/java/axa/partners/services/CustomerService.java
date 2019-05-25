package axa.partners.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axa.partners.dto.CustomerDTO;
import axa.partners.entities.Customer;
import axa.partners.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional
	public Customer createCustomerEnrollment(CustomerDTO customerDTO)
	{
		Customer customer = new Customer(customerDTO);
		customerRepository.save(customer);
		return customer;
	}
}
