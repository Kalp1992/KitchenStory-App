package com.kitchenStory.controllers.customer;


import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.kitchenStory.models.Customer;

import com.kitchenStory.services.CustomerAuthService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/customer")
public class CustomerAuthController {
	@Autowired
	private CustomerAuthService customerAuthService;
	 // private CustomerRepository customerRepository;
	
	    @PostMapping("/signIn") 
	    public ResponseEntity<Customer> SignIn( String customerName, String password) {
			  try {
			        Customer customer = customerAuthService.SignInCustomer(customerName, password);
			        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
			    } catch (NoSuchElementException e) {
			        return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
			    }      
	}
//	    public Status loginCustomer( @RequestBody Customer customer) {
//	        List<Customer> customers;
//			try {
//				customers = customerRepository.findAllCustomer();
//				 for (Customer other : customers) {
//			            if (other.equals(customer)) {
//			               // customer.setLoggedIn(true);
//			               // userRepository.save(user);
//			                return Status.SUCCESS;
//			            }
//			        }
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//
//	        return Status.FAILURE;
//	    }
//		public Map <String, String> signIn(@RequestBody MultiValueMap<String, String> credentials) {
//	    	Map <String, String> signInResponse=new HashMap<>();
//	    	Customer customerAuthenticated= customerauthService.SignInCustomer(credentials.get("customerName").get(0), credentials.get("password").get(0));
//	      if(customerAuthenticated != null) {
//	    	  signInResponse.put("status", "true");
//	    	  signInResponse.put("massege", "The customer has been authenticated successfully");
//	      }else {
//	    	  signInResponse.put("status", "false");
//	    	  signInResponse.put("massege", "Invalid credential!");
//	      }
//	      return  signInResponse;
//  	  
//	    
//	    }
}
