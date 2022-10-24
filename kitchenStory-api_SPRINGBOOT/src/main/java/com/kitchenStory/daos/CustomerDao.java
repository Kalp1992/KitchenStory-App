package com.kitchenStory.daos;

import java.sql.SQLException;
import java.util.ArrayList;


import com.kitchenStory.models.Customer;





public interface CustomerDao {
	Integer createCustomer(Customer customer) throws SQLException ;
	
	// Read/Retrieve Operations
    Customer findCustomerByCustomerNameandPassword(String customerName, String password) throws SQLException ;
	
    Integer updateCustomerName(Customer customer) throws SQLException;

	Integer updateCustomerPassword(Customer customer) throws SQLException;
	
    ArrayList<Customer> findAllCustomer() throws SQLException ;
    
    Customer findByCustomerId(Integer customerId) throws SQLException ;
	
}
