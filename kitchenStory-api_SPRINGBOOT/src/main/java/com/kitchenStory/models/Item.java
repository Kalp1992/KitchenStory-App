package com.kitchenStory.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Details about the customer")
public class Item {
	@ApiModelProperty(notes="The unique itemId of the food item")
     Integer itemId;
	@ApiModelProperty(notes="The name of the food item")
     String itemName;
	@ApiModelProperty(notes="The category of the food item")
     String category;
	@ApiModelProperty(notes="The price of the food item")
     Double price;
	@ApiModelProperty(notes="The vendor of the food item")
     String itemVendor;
	public Item() {
		super();
	}
	
	public Item(Integer itemId) {
		super();
		this.itemId = itemId;
	}
	

	public Item(String itemName) {
		super();
		this.itemName = itemName;
	}

	public Item(Integer itemId, String itemName, String category, Double price, String itemVendor) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.price = price;
		this.itemVendor = itemVendor;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getItemVendor() {
		return itemVendor;
	}
	public void setItemVendor(String itemVendor) {
		this.itemVendor = itemVendor;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", category=" + category + ", price=" + price
				+ ", itemVendor=" + itemVendor + "]";
	}
     
     
}
