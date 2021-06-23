package com.example.retailstore.billing;

import java.util.ArrayList;
import java.util.List;

import com.example.retailstore.billing.dto.UserCartInfo;
import com.example.retailstore.billing.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.retailstore.billing.service.GenerateBill;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BillingApplicationTests {


	
	@Mock
	List<CartItem> cartItemList;
	
	@InjectMocks
	GenerateBill generateBill;

	@BeforeEach
	public void before() {

		cartItemList =  new ArrayList<CartItem>();
		CartItem item = new CartItem();
		item.setItemName("Soap");
		item.setItemPrice(20.0);
		item.setCategory(CartItemCategory.GROCERY);
		cartItemList.add(item);


		item = new CartItem();
		item.setItemName("Shirt");
		item.setItemPrice(500.0);
		item.setCategory(CartItemCategory.FASHION);
		cartItemList.add(item);

		item = new CartItem();
		item.setItemName("Laptop Battery");
		item.setItemPrice(1000.0);
		item.setCategory(CartItemCategory.ELECTRONICS);
		cartItemList.add(item);

	}
	
	@Test
	void test() {
		System.out.println("Test Application Started");
	}
	@Test
	public void testEmployeeDiscount(){
		User user = new User("bhaskar","1234567890",UserType.EMPLOYEE);
		UserCartInfo userCartInfo = new UserCartInfo();
		userCartInfo.setUser(user);
		userCartInfo.setCartItemList(cartItemList);
		Bill resultUserBill = generateBill.getBill(userCartInfo);
		assertEquals(1020.0,
				resultUserBill.getFinalBill());
	}

	@Test
	public void testAffiliateDiscount(){
		User user = new User("bhaskar","1234567890",UserType.AFFILIATE);
		UserCartInfo userCartInfo = new UserCartInfo();
		userCartInfo.setUser(user);
		userCartInfo.setCartItemList(cartItemList);
		Bill resultUserBill = generateBill.getBill(userCartInfo);
		assertEquals(1305.0,
				resultUserBill.getFinalBill());
	}

	@Test void testCustomerDiscount(){
		User user = new User("bhaskar","1234567890",UserType.CUSTOMER);
		UserCartInfo userCartInfo = new UserCartInfo();
		userCartInfo.setUser(user);
		userCartInfo.setCartItemList(cartItemList);
		Bill resultUserBill = generateBill.getBill(userCartInfo);
		assertEquals(1375.0,
				resultUserBill.getFinalBill());
	}

}
