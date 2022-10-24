package com.kitchenStory.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitchenStory.models.Customer;
import com.kitchenStory.repositories.CustomerRepository;



@Service
public class CustomerAuthService {
	 @Autowired
     private CustomerRepository customerRepository;
public Customer SignInCustomer(String customerName,String password) {
	  
		Customer customer= new Customer(customerName, password);
			try {
				return customerRepository.findCustomerByCustomerNameandPassword(customerName, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;             
			 
		 
	
	 
}
}
