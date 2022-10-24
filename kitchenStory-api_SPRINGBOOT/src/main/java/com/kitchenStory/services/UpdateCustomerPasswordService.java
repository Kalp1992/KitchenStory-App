package com.kitchenStory.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitchenStory.models.Customer;
import com.kitchenStory.repositories.CustomerRepository;

@Service
public class UpdateCustomerPasswordService {
	@Autowired
    private CustomerRepository customerRepository;
	public Boolean UpdateCustomerPassword(String password, Integer customerId) throws SQLException {
		Customer customer = this.customerRepository.findByCustomerId(customerId);
		customer.setPassword(password);
		Integer recordsUpdated = this.customerRepository.updateCustomerPassword(customer);
		
		return recordsUpdated > 0;
	}
}
