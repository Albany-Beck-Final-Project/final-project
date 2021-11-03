package com.ab.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.BuyOrder;
import com.ab.entities.User;
import com.ab.enums.OrderStatus;
import com.ab.repositories.BuyOrderRepository;
import com.ab.repositories.SessionRepository;

@Service
public class BuyOrderService {
	
	@Autowired
	private BuyOrderRepository buyOrderRepository;
	
	@Autowired
	private SessionRepository sessionRepo;
	
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
	
	//Developed create method 
	public BuyOrder createBuyOrder(Map<String, String> details,BuyOrder buy) { 
		String orderType = new String();
		switch(orderType) { 
		case "Market":
			BuyOrder marketOrder = new BuyOrder(buy.getPrice(), buy.getShares(), LocalDateTime.now(), buy.getOrderStatus(), "Market");
			buyOrderRepository.save(marketOrder);
			return marketOrder;
		case "Limit": 
			BuyOrder limitOrder = new BuyOrder(buy.getPrice(), buy.getShares(), LocalDateTime.now(), buy.getOrderStatus(), "Limit", buy.getLimitPrice());
			buyOrderRepository.save(limitOrder);
			return limitOrder;
		default: 
			BuyOrder newOrder = new BuyOrder(buy.getPrice(), buy.getShares(), LocalDateTime.now(), buy.getOrderStatus(), buy.getOrderType(), buy.getLimitPrice());
			buyOrderRepository.save(newOrder);
			return newOrder;
		}
	}
	
	
	//Saves the new order to the database.
	public BuyOrder saveNewOrder(Map<String, String> details) {
//		TODO: map data to BuyOrder then save in database
		BuyOrder b = new BuyOrder();
		return buyOrderRepository.save(b);
	}
	
	public BuyOrder findBuyOrderById(int id){
		
		return buyOrderRepository.findBuyOrderById(id);
	}


	public List<BuyOrder> getUserBuyOrders(String session) {
		// TODO Auto-generated method stub
		User user = sessionRepo.getBySessionId(session).getUser();
//		List<BuyOrder> orders = 
		return buyOrderRepository.findAllByUserId(user.getUserId());
//		return orders.size() == 0 ? new ArrayList<BuyOrder>() : orders;
//		return new ArrayList<BuyOrder>();
	}
	
}
