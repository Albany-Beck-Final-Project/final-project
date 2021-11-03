package com.ab.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:6030")
public class BuyOrderControllers {
	
	@Autowired
	private BuyOrderService buyOrderService;
	
	@Autowired
	private Authorization auth;
	

	public BuyOrder deleteBuyOrder(int id) { 
		return buyOrderService.deleteBuyOrder(id);
	}
	
	//Specific create buy order method 
	@PostMapping("/buyorders/new")
	public BuyOrder storeOrder(@RequestBody Map<String, String> details, BuyOrder b) { 
		if(!(auth.authorizeSession(details))) { 
			return null;
		}
		return buyOrderService.createBuyOrder(details, b);
	}
	//Old new buy order
	@PostMapping("/old/buyorders/new")
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
	
	@PostMapping("/users/buyorders")
	public List<BuyOrder> getUserBuyOrders(@RequestBody Map<String, String> userDetails) {
		if(!(auth.authorizeSession(userDetails))) {
			return null;
		}
		return buyOrderService.getUserBuyOrders(auth.getSession(userDetails));
	}
	
	
	@PostMapping("/buyorders/{id}")
	public BuyOrder getBuyOrderById(@RequestBody Map<String, String> userDetails, @PathVariable int orderId) { 
		if(!(auth.authorizeSession(userDetails))) {
			return null;
		}
		return buyOrderService.findBuyOrderById(orderId);
	}
}
