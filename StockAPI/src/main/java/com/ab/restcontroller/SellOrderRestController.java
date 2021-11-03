package com.ab.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.entities.SellOrder;
import com.ab.services.SellOrderService;

@RestController
public class SellOrderRestController {

	@Autowired
	private SellOrderService sellOrderService;
	
//	@GetMapping("/sellorders")
//	public List<SellOrder> getOrders() { 
//		return sellOrderService.getAllSellOrders();
//	}
}
