package com.kitchenStory.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitchenStory.models.Admin;
import com.kitchenStory.repositories.AdminRepository;


@Service
public class UpdateAdminPasswordService {
	@Autowired
    private AdminRepository adminRepository;
	public Boolean UpdateAdminPassword(String password, Integer adminId) throws SQLException {
		Admin admin = this.adminRepository.findByAdminId(adminId);
		admin.setPassword(password);
		Integer recordsUpdated = this.adminRepository.updateAdminPassword(admin);
		
		return recordsUpdated > 0;
	}
}
