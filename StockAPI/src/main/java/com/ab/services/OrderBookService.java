package com.ab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.OrderBook;
import com.ab.repositories.OrderBookRepository;

@Service
public class OrderBookService {
	
	@Autowired
	private OrderBookRepository orderBookRepository;
	
	
	public List<OrderBook> getOrderBook() { 
		
		return orderBookRepository.findAll();
	}
	
}
