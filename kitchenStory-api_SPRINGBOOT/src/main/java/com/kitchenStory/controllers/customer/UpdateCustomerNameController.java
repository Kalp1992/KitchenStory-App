package com.kitchenStory.controllers.customer;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.kitchenStory.services.UpdateCustomerNameService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/customer")
public class UpdateCustomerNameController {
	@Autowired
	  private UpdateCustomerNameService updateCustomerNameService;
	@PatchMapping("/{customerId}/update/customerName")
	public String update(String customerName, Integer customerId) throws SQLException {
		if (Boolean.TRUE.equals(this.updateCustomerNameService.UpdateCustomerName(customerName, customerId))) {
			return String.format("CustomerName of customer #%d updated successfully", customerId);
		}
		
		return String.format("Failure in updating the customerName of customer #%d!", customerId);
	}
}
