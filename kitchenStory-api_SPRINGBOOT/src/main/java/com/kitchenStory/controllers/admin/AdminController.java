package com.kitchenStory.controllers.admin;

import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitchenStory.models.Admin;
import com.kitchenStory.services.AdminService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	  private AdminService adminService;
	
	    @PostMapping("/signUp") 
	    public String create(Integer adminId, String Name,String adminName, String password) {
			Admin admin = new Admin(adminId, Name, adminName, password);
			try {
				if (Boolean.TRUE.equals(this.adminService.AddAdmin(admin))) {
					return "New Admin record added successfully";
				} 
			} catch (SQLException ex) {
				System.out.println("Exception occurred while inserting a new admin  record!\n" + ex);
			}
			
			return "Sign up Failed";
		}
}