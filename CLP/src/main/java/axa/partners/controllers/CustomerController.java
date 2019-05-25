package axa.partners.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import axa.partners.dto.CustomerDTO;
import axa.partners.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path="/enrollment",method=RequestMethod.GET)
	@ResponseBody
	public String createCustomerEnrollment(@RequestBody CustomerDTO customerDTO)
	{
		System.out.println(customerDTO);
		customerService.createCustomerEnrollment(customerDTO);
		return "Customer Enrollment Done";
	}
	
}
