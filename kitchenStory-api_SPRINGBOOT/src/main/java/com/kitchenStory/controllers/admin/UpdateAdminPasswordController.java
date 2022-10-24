package com.kitchenStory.controllers.admin;

import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitchenStory.services.UpdateAdminPasswordService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class UpdateAdminPasswordController {
	@Autowired
	private UpdateAdminPasswordService  updatePasswordService ;
	@PatchMapping("{adminid}/update/password")
	public String update(Integer adminId,String password) throws SQLException {
		if (Boolean.TRUE.equals(this.updatePasswordService.UpdateAdminPassword(password, adminId))) {
			return String.format("Password of admin #%d updated successfully", adminId);
		}
		
		return String.format("Failure in updating the password of admin #%d!", adminId);
	}
}
