package com.kitchenStory.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.kitchenStory.models.Customer;

import com.kitchenStory.services.GetAllCustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/customer")
public class GetAllCustomerController {
	 @Autowired
	 private GetAllCustomerService getAllCustomerService;
	 @GetMapping("/all") 
	 public List CustomerDetail() {
		 List<Customer> allCustomer=getAllCustomerService.GetallCustomer();
		return allCustomer;
	 }
}
