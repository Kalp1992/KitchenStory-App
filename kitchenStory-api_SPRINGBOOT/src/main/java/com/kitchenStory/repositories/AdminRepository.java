package com.kitchenStory.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kitchenStory.daos.AdminDao;
import com.kitchenStory.models.Admin;

import com.kitchenStory.utils.DatabaseConnection;

@Repository
public class AdminRepository implements AdminDao {
	@Autowired
    private DatabaseConnection connection;
	
	@Override
	public Integer createAdmin(Admin admin) throws SQLException {
		String insertAdminFormat = "INSERT INTO admins (ADMIN_ID, NAME, ADMIN_NAME, PASSWORD) VALUES ( ?, ?, ?, ? )";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(insertAdminFormat);) {
			preparedStatement.setInt(1, admin.getAdminId());
			preparedStatement.setString(2, admin.getName());
			preparedStatement.setString(3, admin.getAdminName());
			preparedStatement.setString(4, admin.getPassword());
			
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Admin findAdminByAdminNameandPassword(String adminName, String password) throws SQLException {
		String getAdminFormat = "SELECT *FROM admins WHERE  ADMIN_NAME = ? and PASSWORD=?";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getAdminFormat);) {
			preparedStatement.setString(1, adminName);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			Admin admin = new Admin();
			while (rs.next()) {
				admin.setAdminId(rs.getInt("ADMIN_ID"));
				admin.setName(rs.getString("NAME"));
				admin.setAdminName(rs.getString("ADMIN_NAME"));
				admin.setPassword(rs.getString("PASSWORD"));
				
			}
			return admin;
		}
	
	}

	@Override
	public Integer updateAdminName(Admin admin) throws SQLException {
		String updateAdminNameFormat = "UPDATE admins SET ADMIN_NAME = ? WHERE  ADMIN_ID = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateAdminNameFormat);) {
			preparedStatement.setString(1, admin.getAdminName());
			preparedStatement.setInt(2, admin.getAdminId());
			
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Integer updateAdminPassword(Admin admin) throws SQLException {
		String updateAdminPasswodFormat = "UPDATE admins SET  PASSWORD = ? WHERE  ADMIN_ID = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateAdminPasswodFormat);) {
			preparedStatement.setString(1, admin.getPassword());
			preparedStatement.setInt(2, admin.getAdminId());
		
			
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Admin findByAdminId(Integer adminId) throws SQLException {
		String getAdminFormat = "SELECT *FROM admins WHERE  ADMIN_ID = ? ";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getAdminFormat);) {
			preparedStatement.setInt(1, adminId);
		    ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			Admin admin = new Admin();
			while (rs.next()) {
				admin.setAdminId(rs.getInt("ADMIN_ID"));
				admin.setName(rs.getString("NAME"));
				admin.setAdminName(rs.getString("ADMIN_NAME"));
				admin.setPassword(rs.getString("PASSWORD"));
				
				
			}
			return admin;
		}
	}

	@Override
	public ArrayList<Admin> findAllAdmin() throws SQLException {
		String getAdminFormat = "SELECT *FROM admins";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getAdminFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			ArrayList<Admin> admins = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return admins;
			}

			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("ADMIN_ID"));
				admin.setName(rs.getString("NAME"));
				admin.setAdminName(rs.getString("ADMIN_NAME"));
				admin.setPassword(rs.getString("PASSWORD"));
				
				admins.add(admin);
			}

			return admins;
			}
	}

}
