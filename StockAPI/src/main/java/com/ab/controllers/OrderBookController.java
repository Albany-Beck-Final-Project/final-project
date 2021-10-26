package com.ab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ab.entities.OrderBook;
import com.ab.services.OrderBookService;

@Controller
public class OrderBookController {
		
	@Autowired
	private OrderBookService orderBookService; 
	
	public List<OrderBook> getOrderBook() { 
		
		return orderBookService.getOrderBook(); 
	}
}
