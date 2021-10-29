package com.ab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ab.entities.BuyOrder;
import com.ab.enums.OrderStatus;
import com.ab.services.BuyOrderService;

@Controller
public class BuyOrderControllers {
	
	@Autowired
	private BuyOrderService buyOrderService;

	public BuyOrder deleteBuyOrder(int id) { 
		return buyOrderService.deleteBuyOrder(id);
	}
	
	public BuyOrder storeNewOrder(BuyOrder b) { 
		return buyOrderService.saveNewOrder(b);
	}
	
	public int updateOrderStatus(String email, int id) { 
		return buyOrderService.updateOrderStatus(email, id);
	}
	
	@GetMapping("/BuyOrders")
	public List<BuyOrder> getAllBuyOrders() { 
		return buyOrderService.getAllBuyOrders();
	}
	
	@GetMapping("/buyorders/{id}")
	public List<BuyOrder> getBuyOrderById(int id) { 
		
		return buyOrderService.findBuyOrderById(id);
	}
}
