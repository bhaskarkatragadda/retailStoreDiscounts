package com.example.retailstore.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.retailstore.billing.dto.UserCartInfo;
import com.example.retailstore.billing.model.Bill;
import com.example.retailstore.billing.service.GenerateBill;

@RestController
@RequestMapping("/api")
public class Billing {
	@Autowired
	private GenerateBill generateBill;
	@GetMapping
	public String test() {
		return "HELLO";
	}
	@PostMapping("/bill")
	public Bill getBill(@RequestBody UserCartInfo userCartInfo) {
		return generateBill.getBill(userCartInfo);
	}
}
