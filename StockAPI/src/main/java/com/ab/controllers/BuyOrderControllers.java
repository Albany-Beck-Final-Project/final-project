package com.ab.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ab.authorization.Authorization;
import com.ab.entities.BuyOrder;
import com.ab.enums.OrderStatus;
import com.ab.services.BuyOrderService;

@RestController
public class BuyOrderControllers {
	
	@Autowired
	private BuyOrderService buyOrderService;
	
	@Autowired
	private Authorization auth;
	

	public BuyOrder deleteBuyOrder(int id) { 
		return buyOrderService.deleteBuyOrder(id);
	}
	
	@PostMapping("/buyorders/new")
	public BuyOrder storeNewOrder(@RequestBody Map<String, String> details) {
		if(!(auth.authorizeSession(details))) {
			return null;
		}
		return buyOrderService.saveNewOrder(details);
	}
	
	@PostMapping("/buyorders/update/{id}")
	public Integer updateOrderStatus(@RequestBody Map<String, String> details, @PathVariable int orderId) { 
//		TODO: status and id from details
		if(!(auth.authorizeSession(details))) {
			return null;
		}
		return buyOrderService.updateOrderStatus(details, orderId);
	}
	
	@PostMapping("/buyorders")
	public List<BuyOrder> getAllBuyOrders(@RequestBody Map<String, String> userDetails) {
		if(!(auth.authorizeSession(userDetails))) {
			return null;
		}
		return buyOrderService.getAllBuyOrders();
	}
	
	
	@PostMapping("/buyorders/{id}")
	public List<BuyOrder> getBuyOrderById(@RequestBody Map<String, String> userDetails, @PathVariable int orderId) { 
		if(!(auth.authorizeSession(userDetails))) {
			return null;
		}
		return buyOrderService.findBuyOrderById(orderId);
	}
}
