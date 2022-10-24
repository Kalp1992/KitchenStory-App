package com.kitchenStory.controllers.admin;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.kitchenStory.models.Item;
import com.kitchenStory.services.ItemService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/item")
public class ItemController {
	@Autowired
	  private ItemService itemService;
	
	    @PostMapping("/add") 
	    public String create(Integer itemId, String itemName,String category, Double price,String itemVendor) {
			Item item = new Item(itemId, itemName, category, price, itemVendor);
			try {
				if (Boolean.TRUE.equals(this.itemService.AddItem(item))) {
					return "New Item record added successfully";
				} 
			} catch (SQLException ex) {
				System.out.println("Exception occurred while inserting a new item  record!\n" + ex);
			}
			
			return "Item not added";
		}
}
