package com.kitchenStory.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitchenStory.models.Admin;
import com.kitchenStory.repositories.AdminRepository;



@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	public Boolean AddAdmin(Admin admin) throws SQLException {
        Integer recordsInserted = this.adminRepository.createAdmin(admin);
		
		return recordsInserted > 0;
		 
	 }
}
