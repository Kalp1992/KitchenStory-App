package com.kitchenStory.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kitchenStory.models.Customer;
import com.kitchenStory.repositories.CustomerRepository;


@Service
public class UpdateCustomerNameService {
	@Autowired
    private CustomerRepository customerRepository;
	public Boolean UpdateCustomerName(String customerName,Integer customerId) throws SQLException {
		Customer customer = this.customerRepository.findByCustomerId(customerId);
		customer.setCustomerName(customerName);
		Integer recordsUpdated = this.customerRepository.updateCustomerName(customer);
		
		return recordsUpdated > 0;
	}
}
