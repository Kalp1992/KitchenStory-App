package com.kitchenStory.controllers.admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitchenStory.models.Item;
import com.kitchenStory.services.GetAllItemService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class GetAllItemController {
	 @Autowired
	 private GetAllItemService getAllItemService;
	 @GetMapping("/item/all") 
	 public List ItemDetail() {
		 List<Item> allItem=getAllItemService.GetallProduct();
		return allItem;
	 }
}
