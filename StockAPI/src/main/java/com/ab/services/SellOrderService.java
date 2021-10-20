package com.ab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.SellOrder;
import com.ab.enums.OrderStatus;
import com.ab.repositories.SellOrderRepository;

@Service
public class SellOrderService  {

	@Autowired
	private SellOrderRepository sellOrderRepository;
	
	public OrderStatus updateBuyOrderStatus(OrderStatus status, int id) { 
		return sellOrderRepository.updateOrderStatusSell(status, id);
	}

	
	public List<SellOrder> findAllOrders() {
		// TODO Auto-generated method stub
		return sellOrderRepository.findAll();
	}
	
	
	
	
}
