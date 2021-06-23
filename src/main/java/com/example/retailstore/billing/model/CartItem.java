package com.example.retailstore.billing.model;



public class CartItem {
	private String itemName;
	private Double itemPrice;
	
	private CartItemCategory category;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public CartItemCategory getCategory() {
		return category;
	}
	public void setCategory(CartItemCategory category) {
		this.category = category;
	}
	
}
