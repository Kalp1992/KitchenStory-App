package com.kitchenStory.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitchenStory.models.Admin;
import com.kitchenStory.repositories.AdminRepository;


@Service
public class UpdateAdminNameService {
	@Autowired
    private AdminRepository adminRepository;
	public Boolean UpdateAdminName(String adminName, Integer adminId) throws SQLException {
		Admin admin = this.adminRepository.findByAdminId(adminId);
		admin.setAdminName(adminName);
		Integer recordsUpdated = this.adminRepository.updateAdminName(admin);
		
		return recordsUpdated > 0;
	}
}
