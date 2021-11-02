package com.ab.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ab.authorization.Authorization;
import com.ab.dtos.UserOrderDto;
import com.ab.entities.BuyOrder;
import com.ab.entities.SellOrder;
import com.ab.enums.OrderStatus;
import com.ab.services.SellOrderService;

@RestController
@CrossOrigin(origins = "http://localhost:6030")
public class SellOrderController {

	@Autowired
	private SellOrderService sellOrderService;
	
	@Autowired
	private Authorization auth;

	@PostMapping("/sellorders/new")
	public SellOrder storeNewOrder(@RequestBody Map<String, String> details) {
		System.out.println("Arrived");
		if(!(auth.authorizeSession(details))) {
			return null;
		}
		details.put("userEmail", auth.getEmailFromSession(details.get("session")));
		System.out.println("added userEmail");
		return sellOrderService.saveNewOrder(details);
	}

	/**
	public OrderStatus updateStatus(OrderStatus status, int id) {
		
		return sellOrderService.updateBuyOrderStatus(status, id);
	}
	**/
	public SellOrder deleteOrder(int id) { 
		
		return sellOrderService.deleteSellOrder(id);
	}	
	
	@PostMapping("/users/sellorders")
	public List<UserOrderDto> getUserSellOrders(@RequestBody Map<String, String> userDetails) {
		if(!(auth.authorizeSession(userDetails))) {
			return null;
		}
		return sellOrderService.getUserSellOrders(auth.getSession(userDetails));
		
	}
	
	@PostMapping("/sellorders")
	public List<SellOrder> getAllSellOrders(@RequestBody Map<String, String> details) {
		if(!(auth.authorizeSession(details))) {
			return null;
		}
		return sellOrderService.getAllSellOrders(details);
	}
}
