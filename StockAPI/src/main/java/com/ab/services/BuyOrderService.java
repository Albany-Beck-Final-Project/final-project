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
	
	
	public int updateOrderStatus(String status, int id) { 
		return buyOrderRepository.updateOrderStatusByOrderId(status, id);
	}
	
	
	public BuyOrder deleteBuyOrder(int id) {
		BuyOrder orderToDelete = buyOrderRepository.getById(id) ;
		buyOrderRepository.deleteById(id);
		return orderToDelete;
	}
	
	//Saves the new order to the database.
	public BuyOrder saveNewOrder(BuyOrder b) {
		// TODO Auto-generated method stub
		return buyOrderRepository.save(b);
	}
	
	public List<BuyOrder> findBuyOrderById(int id){
		
		return buyOrderRepository.findBuyOrderById(id);
	}
	
}
