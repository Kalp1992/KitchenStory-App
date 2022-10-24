package com.kitchenStory.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitchenStory.models.Admin;

import com.kitchenStory.services.GetAllAdminService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class GetAllAdminController {
	 @Autowired
	 private GetAllAdminService getAllAdminService;
	 @GetMapping("/all") 
	 public List AdminDetail() {
		 List<Admin> allAdmin=getAllAdminService.GetallAdmin();
		return allAdmin;
	 }
}
