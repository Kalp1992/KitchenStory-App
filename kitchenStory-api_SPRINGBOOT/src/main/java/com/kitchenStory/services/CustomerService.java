package com.kitchenStory.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kitchenStory.models.Customer;

import com.kitchenStory.repositories.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public Boolean AddCustomer(Customer customer) throws SQLException {
		 Integer recordsInserted = this.customerRepository.createCustomer(customer);
			
			return recordsInserted > 0;
			 
		 }
	 }

	

