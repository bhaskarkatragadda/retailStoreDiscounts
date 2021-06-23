package com.example.retailstore.billing.interfaces;

import java.util.List;

import com.example.retailstore.billing.dto.UserCartInfo;
import com.example.retailstore.billing.model.Bill;
import com.example.retailstore.billing.model.CartItem;

public interface GenerateBillInterface {
	public Bill getBill(UserCartInfo userCartInfo);
	
	public Double getTotalItemCost(List<CartItem> cartItemList);
	
	
	public Double getGroceriesCost(List<CartItem> cartItemList);
	
	public void userDiscount(Double cost);
	
	public void finalDiscount(Double billCost);
}
