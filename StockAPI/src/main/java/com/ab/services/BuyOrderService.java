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
import com.ab.repositories.BuyOrderRepository;
import com.ab.repositories.OrderBookRepository;
import com.ab.repositories.SessionRepository;
import com.ab.repositories.UserRepository;

@Service
public class BuyOrderService {
	
	@Autowired
	private BuyOrderRepository buyOrderRepository;
	
	@Autowired
	private SessionRepository sessionRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private OrderBookRepository orderBookRepo;
	
	@Autowired
	private OrderHelper<BuyOrder> buyHelper;
	
	
	public List<BuyOrder> getAllBuyOrders(Map<String, String> details) { 
		
		return buyOrderRepository.findAllByStockName(details.get("stock"));
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
		System.out.println(orderBookRepo.getByCompanyName(details.get("companyName")));
		BuyOrder b = new BuyOrder(
					Double.parseDouble(details.get("price")),
					Integer.parseInt(details.get("quantity")),
					LocalDateTime.now(),
					OrderStatus.NEW,
					OrderType.MARKET,
					0.0,
					userRepo.getByEmail(details.get("userEmail")).get(),
					orderBookRepo.getByCompanyName(details.get("companyName"))
				);
		return buyOrderRepository.save(b);
	}
	
	public List<BuyOrder> findBuyOrderById(int id){
		
		return buyOrderRepository.findBuyOrderById(id);
	}


	public List<UserOrderDto> getUserBuyOrders(String session) {
		User user = sessionRepo.getBySessionId(session).getUser();
		List<BuyOrder> orders = buyOrderRepository.findAllByUserId(user.getUserId());
		return orders.size() > 0 ? buyHelper.convertOrderToDto(orders) : new ArrayList<UserOrderDto>();

	}
	
}
