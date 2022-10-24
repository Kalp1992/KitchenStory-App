package com.kitchenStory.services;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitchenStory.models.Item;
import com.kitchenStory.repositories.ItemRepository;


@Service
public class GetAllItemService {
	@Autowired
    private ItemRepository itemRepository;
	 public  ArrayList<Item> GetallProduct() {
			Item item= new Item();
			try {
				return itemRepository.findAllItem();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
			 
		 }
}
