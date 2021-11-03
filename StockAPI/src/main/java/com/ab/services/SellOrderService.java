package com.ab.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.dtos.UserOrderDto;
import com.ab.entities.BuyOrder;
import com.ab.entities.SellOrder;
import com.ab.entities.SellOrder;
import com.ab.entities.User;
import com.ab.enums.OrderStatus;
import com.ab.enums.OrderType;
import com.ab.helpers.OrderHelper;
import com.ab.repositories.OrderBookRepository;
import com.ab.repositories.SellOrderRepository;
import com.ab.repositories.SessionRepository;
import com.ab.repositories.UserRepository;

@Service
public class SellOrderService  {

	@Autowired
	private SellOrderRepository sellOrderRepository;
	
	@Autowired
	private OrderHelper<SellOrder> sellHelper;
	
	@Autowired
	private SessionRepository sessionRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private OrderBookRepository orderBookRepo;
	
	@Autowired
	private SmartOrderRouting smartOrderRouting;
	
	/**
	public OrderStatus updateSellOrderStatus(OrderStatus status, int id) { 
		return sellOrderRepository.updateOrderStatusSell(status, id);
	}
	 * @param details 
**/
	
	public List<SellOrder> getAllSellOrders(Map<String, String> details) {
		// TODO Auto-generated method stub
		return sellOrderRepository.findAllByStockName(details.get("stock"));
	}
	
	public SellOrder deleteSellOrder(int id) { 
		SellOrder orderToDelete = sellOrderRepository.getById(id);
		sellOrderRepository.deleteById(id);
		return orderToDelete;
	}
	
	public List<UserOrderDto> getUserSellOrders(String session) {
		User user = sessionRepo.getBySessionId(session).getUser();
		List<SellOrder> orders = sellOrderRepository.findAllByUserId(user.getUserId());
		return orders.size() > 0 ? sellHelper.convertOrderToDto(orders) : new ArrayList<UserOrderDto>();

	}
	
	
	public SellOrder createSellOrder(Map<String, String> details) { 
		String orderType = new String();
		switch(orderType) { 
		case "Market":
//			SellOrder marketOrder = new SellOrder(buy.getPrice(), buy.getShares(), LocalDateTime.now(), buy.getOrderStatus(), "Market");
			SellOrder marketOrder = new SellOrder(
					Double.parseDouble(details.get("price")),
					Integer.parseInt(details.get("quantity")),
					LocalDateTime.now(),
					"NEW",
					"MARKET",
					userRepo.getByEmail(details.get("userEmail")).get(),
					orderBookRepo.getByCompanyName(details.get("companyName"))
				);
			sellOrderRepository.save(marketOrder);
			smartOrderRouting.match();
			return marketOrder;
		case "Limit": 
//			SellOrder limitOrder = new SellOrder(buy.getPrice(), buy.getShares(), LocalDateTime.now(), buy.getOrderStatus(), "Limit", buy.getLimitPrice());
			SellOrder limitOrder = new SellOrder(
					Double.parseDouble(details.get("price")),
					Integer.parseInt(details.get("quantity")),
					LocalDateTime.now(),
					"NEW",
					"LIMIT",
					0.0,
					userRepo.getByEmail(details.get("userEmail")).get(),
					orderBookRepo.getByCompanyName(details.get("companyName"))
				);
			sellOrderRepository.save(limitOrder);
			smartOrderRouting.match();
			return limitOrder;
		default: 
//			SellOrder newOrder = new SellOrder(buy.getPrice(), buy.getShares(), LocalDateTime.now(), buy.getOrderStatus(), buy.getOrderType(), buy.getLimitPrice());
			SellOrder newOrder = new SellOrder(
					Double.parseDouble(details.get("price")),
					Integer.parseInt(details.get("quantity")),
					LocalDateTime.now(),
					"NEW",
					"NONE",
					0.0,
					userRepo.getByEmail(details.get("userEmail")).get(),
					orderBookRepo.getByCompanyName(details.get("companyName"))
				);
			sellOrderRepository.save(newOrder);
			smartOrderRouting.match();
			return newOrder;
		}
	}

    
//	public int updateOrderStatus(Map<String, String> details, int orderId) { 
//		return sellOrderRepository.updateOrderStatusByOrderId(details.get("status"), orderId);

//	}

	public List<SellOrder> getAllToMatch() {
		return sellOrderRepository.getAllToMatch();
	}
	
	public boolean updateStatus(SellOrder sell, String status) {
		// TODO Auto-generated method stub
		return sellOrderRepository.updateOrderStatusByOrderId(status, sell.getSellOrderId()) == 1;
	}
	
	public boolean updateAvailable(SellOrder sell, int available) {
		return sellOrderRepository.updateAvailableByOrderId(available, sell.getSellOrderId()) == 1;
	}
		
}
