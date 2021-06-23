package com.example.retailstore.billing.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

public class Bill {
	private Long Id;
	private String creationDate;
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	private List<CartItem> cartItemList;
	private Double totalBill;
	private Double totalBillAfterDiscount;
	private Double finalBill;
	public List<CartItem> getCartItemList() {
		return cartItemList;
	}
	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}
	public Double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(Double totalBill) {
		this.totalBill = totalBill;
	}
	public Double getTotalBillAfterDiscount() {
		return totalBillAfterDiscount;
	}
	public void setTotalBillAfterDiscount(Double totalBillAfterDiscount) {
		this.totalBillAfterDiscount = totalBillAfterDiscount;
	}
	public Double getFinalBill() {
		return finalBill;
	}
	public void setFinalBill(Double finalBill) {
		this.finalBill = finalBill;
	}
}
