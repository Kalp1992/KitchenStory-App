package com.kitchenStory.daos;

import java.sql.SQLException;
import java.util.ArrayList;



import com.kitchenStory.models.Item;



public interface ItemDao {
	Integer createItem(Item item) throws SQLException ;
	
	
	
	//Item findProductByItemId(Integer itemId) throws SQLException ;
	
	
	ArrayList<Item> findAllItem() throws SQLException;
	
	Integer deleteItemByItemId(Integer itemId) throws SQLException;
	
	Item findByItemId(Integer itemId) throws SQLException ;
	
	 ArrayList<Item> findItemByName(String itemName) throws SQLException ;

}
