package com.kitchenStory.services;

import java.sql.SQLException;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitchenStory.models.Item;
import com.kitchenStory.repositories.ItemRepository;


@Service
public class FindFoodItemByNameService {
	@Autowired
    private ItemRepository itemRepository;
    public ArrayList<Item> FindFoodByName(String itemName) {
	  
   	 Item item= new Item(itemName);
			try {
				return itemRepository.findItemByName(itemName);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;             
			 
}
}
