package com.kitchenStory.controllers.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitchenStory.models.Item;
import com.kitchenStory.services.FindFoodItemByNameService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/fooditem")
public class FindFoodItemByNameController {
	@Autowired
	private FindFoodItemByNameService findFoodItemByNameService;
    @GetMapping("/GetbyName") 
//    public List FoodDetail(String itemName) {
//		 List<Food> allFood= findFoodByNameService.FindFoodByName(itemName);
//		return allFood;
//	 }}
    public ResponseEntity<List<Item>> findByItemName(String itemName) {
        try {
           List<Item> items = findFoodItemByNameService.FindFoodByName(itemName);
          if (items.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
          return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
}}

