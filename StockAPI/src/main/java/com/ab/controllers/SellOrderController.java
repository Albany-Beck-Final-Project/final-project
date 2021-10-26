package com.ab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ab.entities.SellOrder;
import com.ab.enums.OrderStatus;
import com.ab.services.SellOrderService;

@Controller
public class SellOrderController {

	@Autowired
	private SellOrderService sellOrderService;
	
	public List<SellOrder> getAllOrders() {
		
		return sellOrderService.findAllOrders();
	}
	/**
	public OrderStatus updateStatus(OrderStatus status, int id) {
		
		return sellOrderService.updateBuyOrderStatus(status, id);
	}
	**/
	public SellOrder deleteOrder(int id) { 
		
		return sellOrderService.deleteSellOrder(id);
	}	
}
