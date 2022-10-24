package com.kitchenStory.daos;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kitchenStory.models.Admin;




public interface AdminDao {
	Integer createAdmin(Admin admin) throws SQLException ;
	
	// Read/Retrieve Operations
	Admin findAdminByAdminNameandPassword(String adminName, String password) throws SQLException ;
	
	Integer updateAdminName(Admin admin) throws SQLException;
	
	Integer updateAdminPassword(Admin admin) throws SQLException;
	
	Admin findByAdminId(Integer adminId) throws SQLException ;
	
	ArrayList<Admin> findAllAdmin() throws SQLException ;

}
