package axa.partners.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import axa.partners.dto.CustomerDTO;
import axa.partners.entities.Customer;
import axa.partners.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path="/enrollment",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> createCustomerEnrollment(@RequestBody CustomerDTO customerDTO)
	{
		Map<String,Object> responseMap = new HashMap<String,Object>();
		Map<String,Object> statusMap = new HashMap<String,Object>();
		Customer customer = customerService.createCustomerEnrollment(customerDTO);
		
		responseMap.put("Customer Profile got created successfully with id:", customer.getCustomerId());
		statusMap.put("status", "Success");
		statusMap.put("code", "200");
		responseMap.put("header",statusMap);		
		return responseMap;
	}
	
}
