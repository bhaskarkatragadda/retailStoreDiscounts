package com.example.retailstore.billing.model;




public enum UserType {
	EMPLOYEE(1,30),AFFILIATE(2,10), CUSTOMER(3,5);
	
	private final int typeId;
	private final int discountPercentage;
	
	private UserType(Integer typeId,Integer discountPercentage) {
		this.typeId = typeId;
		this.discountPercentage = discountPercentage;
	}
	
	public int getDiscountPercentage() {
		return this.discountPercentage;
	}

	public int getUserTypeId() {
		return this.typeId;
	}

	
}
