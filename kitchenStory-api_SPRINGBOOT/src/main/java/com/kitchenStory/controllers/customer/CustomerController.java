package com.kitchenStory.controllers.customer;

import java.sql.SQLException;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.kitchenStory.models.Customer;

import com.kitchenStory.services.CustomerService;

import io.swagger.v3.oas.models.parameters.RequestBody;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	    @PostMapping("/signUp") 
	    public String create(Integer customerId, String Name,String customerName, String password) {
			Customer customer = new Customer(customerId, Name, customerName, password);
			try {
				if (Boolean.TRUE.equals(this.customerService.AddCustomer(customer))) {
					return "New Customer record added successfully";
				} 
			} catch (SQLException ex) {
				System.out.println("Exception occurred while inserting a new customer  record!\n" + ex);
			}
			
			return "Sign up Failed";
		}
}
//	    public Status signUp(@RequestBody Customer newCustomer) {
//	        List<Customer> customers1;
//			try {
//				customers1 = customerRepository.findAllCustomer();
//				 System.out.println("New Customer: " + customerRepository.toString());
//			        for (Customer customer : customers1) {
//			            System.out.println("Registered user: " + newCustomer.toString());
//			            if (customer.equals(newCustomer)) {
//			                System.out.println("User Already exists!");
//			                return Status.USER_ALREADY_EXISTS;
//			            }
//			        }
//			        customerRepository.createCustomer(newCustomer);
//			       
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			 return Status.SUCCESS;
//	    }
//	    }
//	    	Map <String, String> signUpResponse=new HashMap<>();
//	    	Boolean customerRegistered= customerService.AddCustomer(Integer.parseInt(newAdminDetails.get("customerId").get(0)),newAdminDetails.get("name").get(0),newAdminDetails.get("customerName").get(0), newAdminDetails.get("password").get(0));
//	      if(customerRegistered) {
//	    	  signUpResponse.put("status", "true");
//	    	  signUpResponse.put("massege", "The customer has been registered successfully");
//	      }else {
//	    	  signUpResponse.put("status", "false");
//	    	  signUpResponse.put("massege", "Invalid Info!");
//	      }
//	      return  signUpResponse;
//	  
//	    
//	    }
//}
