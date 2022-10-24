package com.kitchenStory.controllers.customer;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.kitchenStory.services.UpdateCustomerPasswordService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/customer")
public class UpdateCustomerPasswordController {
	@Autowired
	  private UpdateCustomerPasswordService updateCustomerPasswordService;
	@PatchMapping("/{customerId}/update/password")
	public String update(String password, Integer customerId) throws SQLException {
		if (Boolean.TRUE.equals(this.updateCustomerPasswordService.UpdateCustomerPassword(password, customerId))) {
			return String.format("Password of customer #%d updated successfully", customerId);
		}
		
		return String.format("Failure in updating the password of customer #%d!", customerId);
	}
}
