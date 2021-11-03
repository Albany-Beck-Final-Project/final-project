package com.ab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.entities.OrderBook;
import com.ab.services.OrderBookService;

@RestController
@CrossOrigin(origins = "http://localhost:6030")
public class OrderBookController {
		
	@Autowired
	private OrderBookService orderBookService; 
	
	@PostMapping("/orderbooks")
	public List<OrderBook> getAllOrderBook() { 
		return orderBookService.getOrderBook(); 
	}
}
