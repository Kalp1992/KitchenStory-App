package com.kitchenStory.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitchenStory.services.DeleteItemService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/item")
public class DeleteItemController {
	@Autowired
	private DeleteItemService  deleteItemService;
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteItem(@PathVariable("id") Integer id) {
	    try {
	    	deleteItemService.DeleteItem(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
}
