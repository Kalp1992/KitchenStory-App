package com.kitchenStory.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Details about the admin")
public class Admin {
	@ApiModelProperty(notes="The unique adminId of the admin")
    Integer adminId;
	@ApiModelProperty(notes="The name of the admin")
    String name;
	@ApiModelProperty(notes="The admin name of the admin")
    String adminName;
	@ApiModelProperty(notes="The password of admin")
    String password;
	public Admin() {
		super();
	}
	
	public Admin(Integer adminId) {
		super();
		this.adminId = adminId;
	}

	public Admin(String adminName, String password) {
		super();
		this.adminName = adminName;
		this.password = password;
	}

	public Admin(Integer adminId, String name, String adminName, String password) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.adminName = adminName;
		this.password = password;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", adminName=" + adminName + ", password=" + password
				+ "]";
	}
    
	
    
}
