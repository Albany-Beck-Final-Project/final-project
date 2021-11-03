package com.ab.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ab.authorization.Authorization;
import com.ab.entities.SellOrder;
import com.ab.enums.OrderStatus;
import com.ab.services.SellOrderService;

@Controller
public class SellOrderController {

	@Autowired
	private SellOrderService sellOrderService;
	
	@Autowired
	private Authorization auth;
	

	public List<SellOrder> getAllOrders() {
		
		return sellOrderService.getAllSellOrders();
	}

	public SellOrder deleteOrder(int id) { 
		
		return sellOrderService.deleteSellOrder(id);
	}	
	
	@PostMapping("/sellorders/update/{id}")
	public Integer updateOrderStatus(@RequestBody Map<String, String> details, @PathVariable int orderId) {
		if(!(auth.authorizeSession(details))) { 
			return null;
		}
		return sellOrderService.updateOrderStatus(details, orderId);
	}
}
