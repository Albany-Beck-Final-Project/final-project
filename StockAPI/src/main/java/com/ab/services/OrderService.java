package com.ab.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ab.entities.Order;

@Service 
public interface OrderService {
	
	public List<Order> findAllOrders();
	
	
}
