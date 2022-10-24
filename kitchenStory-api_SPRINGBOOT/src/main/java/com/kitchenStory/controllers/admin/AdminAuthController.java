package com.kitchenStory.controllers.admin;


import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitchenStory.models.Admin;
import com.kitchenStory.services.AdminAuthService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class AdminAuthController {
	@Autowired
	  private AdminAuthService adminAuthService;
	
	    @GetMapping("/signIn") 
	    public ResponseEntity<Admin> SignIn( String adminName, String password) {
			  try {
			        Admin admin = adminAuthService.SignInAdmin(adminName, password);
			        return new ResponseEntity<Admin>(admin, HttpStatus.OK);
			    } catch (NoSuchElementException e) {
			        return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
			    }      
	}
}
