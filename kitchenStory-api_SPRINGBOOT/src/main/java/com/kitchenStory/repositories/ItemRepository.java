package com.kitchenStory.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.kitchenStory.daos.ItemDao;

import com.kitchenStory.models.Item;
import com.kitchenStory.utils.DatabaseConnection;



@Repository
public class ItemRepository implements ItemDao {
  
	@Autowired
    private DatabaseConnection connection;
	@Override
	public Integer createItem(Item item) throws SQLException {
		String insertItemFormat = "INSERT INTO items (ITEM_ID, ITEM_NAME,CATEGORY, PRICE, ITEM_VENDOR) VALUES ( ?, ?, ?, ?, ?  )";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(insertItemFormat);) {
			preparedStatement.setInt(1, item.getItemId());
			preparedStatement.setString(2, item.getItemName());
			preparedStatement.setString(3, item.getCategory());
			preparedStatement.setDouble(4, item.getPrice());
			preparedStatement.setString(5, item.getItemVendor());
			
			return preparedStatement.executeUpdate();
		}
	}

	

	@Override
	public ArrayList<Item> findAllItem() throws SQLException {
		String getItemsFormat = "SELECT *FROM items";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getItemsFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			ArrayList<Item> items = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return items;
			}

			while (rs.next()) {
				Item item = new Item();
				item.setItemId(rs.getInt("ITEM_ID"));
				item.setItemName(rs.getString("ITEM_NAME"));
				item.setCategory(rs.getString("CATEGORY"));
				item.setPrice(rs.getDouble("PRICE"));
				item.setItemVendor(rs.getString("ITEM_VENDOR"));
				
				items.add(item);
			}

			return items;
			}
	}

	@Override
	public Integer deleteItemByItemId(Integer itemId) throws SQLException {
		String deleteItemFormat = " DELETE FROM items WHERE ITEM_ID = ?";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(deleteItemFormat);) {
			preparedStatement.setInt(1, itemId);
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Item findByItemId(Integer itemId) throws SQLException {
		String getItemFormat = "SELECT *FROM items WHERE  ADMIN_ID = ? ";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getItemFormat);) {
			preparedStatement.setInt(1, itemId);
		    ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}


			Item item = new Item();
			while (rs.next()) {
				item.setItemId(rs.getInt("ITEM_ID"));
				item.setItemName(rs.getString("ITEM_NAME"));
				item.setCategory(rs.getString("CATEGORY"));
				item.setPrice(rs.getDouble("PRICE"));
				item.setItemVendor(rs.getString("ITEM_VENDOR"));
				
			}
			return item;
		}
	}



	@Override
	public ArrayList<Item> findItemByName(String itemName) throws SQLException {
		String getItemFormat = "SELECT *FROM items WHERE  ITEM_NAME = ? ";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getItemFormat);) {
			preparedStatement.setString(1, itemName);
		    ResultSet rs = preparedStatement.executeQuery();
		    ArrayList<Item> items = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return items;
			}

			Item item = new Item();
			while (rs.next()) {
				item.setItemId(rs.getInt("ITEM_ID"));
				item.setItemName(rs.getString("ITEM_NAME"));
				item.setCategory(rs.getString("CATEGORY"));
				item.setPrice(rs.getDouble("PRICE"));
				item.setItemVendor(rs.getString("ITEM_VENDOR"));
				items.add(item);
			}
			return items;
		}
	}

}
