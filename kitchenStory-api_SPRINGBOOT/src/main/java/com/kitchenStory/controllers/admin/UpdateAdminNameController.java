package com.kitchenStory.controllers.admin;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitchenStory.services.UpdateAdminNameService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class UpdateAdminNameController {
	@Autowired
	  private UpdateAdminNameService updateAdminNameService;
	@PatchMapping("/{adminId}/update/adminName")
	public String update(String adminName, Integer adminId) throws SQLException {
		if (Boolean.TRUE.equals(this.updateAdminNameService.UpdateAdminName(adminName, adminId))) {
			return String.format("AdminName of admin #%d updated successfully", adminId);
		}
		
		return String.format("Failure in updating the adminName of admin #%d!", adminId);
	}
}
