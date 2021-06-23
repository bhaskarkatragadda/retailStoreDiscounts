package com.example.retailstore.billing.dto;

import java.util.List;

import com.example.retailstore.billing.model.Bill;
import com.example.retailstore.billing.model.CartItem;
import com.example.retailstore.billing.model.User;
import com.example.retailstore.billing.model.UserType;

public class UserCartInfo {
	private User user;
	private List<CartItem> cartItemList;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<CartItem> getCartItemList() {
		return cartItemList;
	}
	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}
	
}
