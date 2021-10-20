package com.ab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.BuyOrder;
import com.ab.enums.OrderStatus;
import com.ab.repositories.BuyOrderRepository;

@Service
public class BuyOrderService {
	
	@Autowired
	private BuyOrderRepository buyOrderRepository;
	
	public List<BuyOrder> getAllBuyOrders() { 
		
		return buyOrderRepository.findAll();
	}
	
	
	public OrderStatus updateBuyOrderStatus(OrderStatus status, int id) { 
		return buyOrderRepository.updateOrderStatusBuy(status, id);
	}
	
	public BuyOrder deleteBuyOrder(int id) {
		BuyOrder orderToDelete = buyOrderRepository.getById(id) ;
		buyOrderRepository.deleteById(id);
		return orderToDelete;
	}

}
