package com.kitchenStory.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitchenStory.models.Item;
import com.kitchenStory.repositories.ItemRepository;


@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	
	public Boolean AddItem(Item item ) throws SQLException {
		 Integer recordsInserted = this.itemRepository.createItem(item);
			
			return recordsInserted > 0;
			 
		 }
}
