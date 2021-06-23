package com.example.retailstore.billing.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.retailstore.billing.dto.UserCartInfo;
import com.example.retailstore.billing.interfaces.GenerateBillInterface;
import  com.example.retailstore.billing.model.Bill;
import com.example.retailstore.billing.model.CartItem;
import com.example.retailstore.billing.model.CartItemCategory;
import com.example.retailstore.billing.model.User;


@Service
public class GenerateBill implements GenerateBillInterface{
	private Bill userBill;
	private User user;
	

	public Bill getBill(UserCartInfo userCartInfo) {
		userBill = new Bill();
		this.user = userCartInfo.getUser();
		userBill.setCartItemList(userCartInfo.getCartItemList());
		userBill.setTotalBill(this.getTotalItemCost(userCartInfo.getCartItemList()));
		this.userDiscount(userBill.getTotalBill());
		this.finalDiscount(userBill.getTotalBillAfterDiscount());
		this.setIdAndCreationDate(userBill);
		return userBill;
	}

	public void setIdAndCreationDate(Bill userBill) { 
		long leftLimit = 1L;
	    long rightLimit = 10L;
	    long id = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
		userBill.setId(id);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		userBill.setCreationDate(timeStamp);
	}
	public Double getTotalItemCost(List<CartItem> cartItemList) {
		Double totalCost = 0.0;
		for (CartItem cartItem : userBill.getCartItemList()) {
			totalCost+= cartItem.getItemPrice();
		}
		return totalCost;
		
	}
	
	public Double getGroceriesCost(List<CartItem> cartItemList) {
		Double cost = 0.0;
		for (CartItem cartItem : userBill.getCartItemList()) {
			if (cartItem.getCategory().equals(CartItemCategory.GROCERY)) {
				cost += cartItem.getItemPrice();
			}
		}
		return cost;
	}

	public void userDiscount(Double cost) {
		Double discountValue = 0.0;
		int discountPercentage = user.getUserType().getDiscountPercentage();
		Double groceriesValue = getGroceriesCost(userBill.getCartItemList());
		discountValue = (cost - groceriesValue);
		discountValue = ((discountValue * discountPercentage) / 100);
		userBill.setTotalBillAfterDiscount(cost - discountValue);
	}
	
	
	public void finalDiscount(Double billCost) {
		userBill.setFinalBill(billCost - (Math.floor(Math.floor(billCost) / 100) * 5));
	}

	
}
