package axa.partners.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import axa.partners.dto.CustomerDTO;

@RestController
@RequestMapping("/customer")
public class CustomerEnrollmentController {

	@RequestMapping(path="/enrollment",method=RequestMethod.GET)
	@ResponseBody
	public String createCustomerEnrollment(@RequestBody CustomerDTO customerDTO)
	{
		return "Customer Enrollment Done";
	}
	
}
