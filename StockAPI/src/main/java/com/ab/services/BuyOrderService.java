package com.ab.services;

import java.util.List;
import java.util.Map;

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
	
	
	public int updateOrderStatus(Map<String, String> details, int orderId) {
		
		return buyOrderRepository.updateOrderStatusByOrderId(details.get("status"), orderId);
	}
	
	
	public BuyOrder deleteBuyOrder(int id) {
		BuyOrder orderToDelete = buyOrderRepository.getById(id) ;
		buyOrderRepository.deleteById(id);
		return orderToDelete;
	}
	
	//Saves the new order to the database.
	public BuyOrder saveNewOrder(Map<String, String> details) {
//		TODO: map data to BuyOrder then save in database
		BuyOrder b = new BuyOrder();
		return buyOrderRepository.save(b);
	}
	
	public List<BuyOrder> findBuyOrderById(int id){
		
		return buyOrderRepository.findBuyOrderById(id);
	}
	
}
