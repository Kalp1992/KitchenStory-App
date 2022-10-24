package com.kitchenStory.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kitchenStory.daos.CustomerDao;

import com.kitchenStory.models.Customer;

import com.kitchenStory.utils.DatabaseConnection;


@Repository
public class CustomerRepository implements CustomerDao {
	 @Autowired
     private DatabaseConnection connection;

	@Override
	public 	Integer createCustomer(Customer customer) throws SQLException {
		
		String insertCustomerFormat = "INSERT INTO customers (CUSTOMER_ID, NAME, CUSTOMER_NAME, PASSWORD) VALUES ( ?, ?, ?, ? )";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(insertCustomerFormat);) {
			preparedStatement.setInt(1, customer.getCustomerId());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setString(3, customer.getCustomerName());
			preparedStatement.setString(4, customer.getPassword());
			
			return preparedStatement.executeUpdate();
		}
	}
	
	
	
	

	@Override
	public Integer updateCustomerPassword(Customer customer) throws SQLException {
		String updateCustomerPasswodFormat = "UPDATE customers SET  PASSWORD = ? WHERE  CUSTOMER_ID = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateCustomerPasswodFormat);) {
			preparedStatement.setString(1, customer.getPassword());
			preparedStatement.setInt(2, customer.getCustomerId());
		
			
			return preparedStatement.executeUpdate();
		}

}


	@Override
	public Customer findCustomerByCustomerNameandPassword(String customerName, String password) throws SQLException {
		String getCustomerFormat = "SELECT *FROM customers WHERE  CUSTOMER_NAME = ? and PASSWORD=?";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getCustomerFormat);) {
			preparedStatement.setString(1, customerName);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			Customer customer = new Customer();
			while (rs.next()) {
				customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
				customer.setName(rs.getString("NAME"));
				customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
				customer.setPassword(rs.getString("PASSWORD"));
				
			}
			return customer;
		}

	}



	@Override
	public Integer updateCustomerName(Customer customer) throws SQLException {
		String updateCustomerNameFormat = "UPDATE customers SET CUSTOMER_NAME = ? WHERE  CUSTOMER_ID = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateCustomerNameFormat);) {
			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setInt(2, customer.getCustomerId());
			
			
			return preparedStatement.executeUpdate();
		}

	}





	@Override
	public ArrayList<Customer> findAllCustomer() throws SQLException {
		String getCustomersFormat = "SELECT *FROM customers";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getCustomersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			ArrayList<Customer> customers = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return customers;
			}

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
				customer.setName(rs.getString("NAME"));
				customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
				customer.setPassword(rs.getString("PASSWORD"));
				
				
				customers.add(customer);
			}

			return customers;
			}

	}





	@Override
	public Customer findByCustomerId(Integer customerId) throws SQLException {
		String getCustomerFormat = "SELECT *FROM customers WHERE  CUSTOMER_ID = ? ";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getCustomerFormat);) {
			preparedStatement.setInt(1, customerId);
		    ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			Customer customer = new Customer();
			while (rs.next()) {
				customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
				customer.setName(rs.getString("NAME"));
				customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
				customer.setPassword(rs.getString("PASSWORD"));
				
				
			}
			return customer;
		}
	}

	}
		





	