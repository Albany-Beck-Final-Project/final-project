package com.ab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ab.entities.BuyOrder;
import com.ab.enums.OrderStatus;
import com.ab.services.BuyOrderService;

@Controller
public class BuyOrderControllers {
	
	@Autowired
	private BuyOrderService buyOrderService;
	
	public List<BuyOrder> getAllBuyOrders() { 
		
		return buyOrderService.getAllBuyOrders();
	}
	/**
	public OrderStatus updateStatus(OrderStatus status, int id) { 
		return buyOrderService.updateBuyOrderStatus(status, id);
	}
	**/
	public BuyOrder deleteBuyOrder(int id) { 
		return buyOrderService.deleteBuyOrder(id);
	}
}
