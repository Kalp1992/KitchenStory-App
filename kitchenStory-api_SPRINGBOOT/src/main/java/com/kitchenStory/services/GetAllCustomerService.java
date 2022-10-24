package com.kitchenStory.services;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kitchenStory.models.Customer;

import com.kitchenStory.repositories.CustomerRepository;

@Service
public class GetAllCustomerService {
	@Autowired
    private CustomerRepository customerRepository;
	public  ArrayList<Customer> GetallCustomer() {
		Customer customer= new Customer();
		try {
			return customerRepository.findAllCustomer();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		 
	 }
}
