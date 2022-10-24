package com.kitchenStory.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

 @ApiModel(description="Details about the customer")
 public class Customer {
   @ApiModelProperty(notes="The unique customerId of the customer")
   Integer customerId;
   @ApiModelProperty(notes="The name of the customer")
   String name;
   @ApiModelProperty(notes="The customer name of customer")
   String customerName;
   @ApiModelProperty(notes="The password of the customer")
   String password;
   
   public Customer() {
	super();
   }
   
public Customer(Integer customerId) {
	super();
	this.customerId = customerId;
}

public Customer(String customerName, String password) {
	super();
	this.customerName = customerName;
	this.password = password;
}

public Customer(Integer customerId, String name, String customerName, String password) {
	super();
	this.customerId = customerId;
	this.name = name;
	this.customerName = customerName;
	this.password = password;
}

public Integer getCustomerId() {
	return customerId;
}

public void setCustomerId(Integer customerId) {
	this.customerId = customerId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", name=" + name + ", customerName=" + customerName + ", password="
			+ password + "]";
}
   
   
}
