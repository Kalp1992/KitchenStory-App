package com.kitchenStory.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitchenStory.models.Item;
import com.kitchenStory.repositories.ItemRepository;


@Service
public class DeleteItemService {
	@Autowired
    private ItemRepository itemRepository;
	public Boolean DeleteItem(Integer itemId) {
		Item item= new Item(itemId);
		try {
			return itemRepository.deleteItemByItemId(itemId)>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		 
	 }
}
