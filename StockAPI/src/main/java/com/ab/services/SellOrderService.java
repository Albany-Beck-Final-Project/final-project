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
	
	/**
	public OrderStatus updateBuyOrderStatus(OrderStatus status, int id) { 
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
	
	
	public SellOrder saveNewOrder(Map<String, String> details) {
//		TODO: map data to BuyOrder then save in database
		System.out.println(orderBookRepo.getByCompanyName(details.get("companyName")));
		SellOrder b = new SellOrder(
					Double.parseDouble(details.get("price")),
					Integer.parseInt(details.get("quantity")),
					LocalDateTime.now(),
					OrderStatus.NEW,
					OrderType.MARKET,
					0.0,
					userRepo.getByEmail(details.get("userEmail")).get(),
					orderBookRepo.getByCompanyName(details.get("companyName"))
				);
		return sellOrderRepository.save(b);
	}
	

	
}
