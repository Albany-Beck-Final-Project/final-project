package com.ab.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ab.dtos.UserOrderDto;
import com.ab.entities.BuyOrder;
import com.ab.entities.Order;
import com.ab.entities.SellOrder;

@Component
public class OrderHelper<T extends Order> {
//public class OrderHelper {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
	
	public static String formatDate(LocalDateTime dateToFormat) {
		return dateToFormat.format(formatter);
	}
	
	public List<UserOrderDto> convertOrderToDto(List<T> orders) {
		List<UserOrderDto> orderDto = new ArrayList<>();
		orders.forEach(order -> {
			orderDto.add(
					new UserOrderDto(
								order instanceof BuyOrder ? ((BuyOrder) order).getBuyOrderId() : ((SellOrder) order).getSellOrderId(),
								formatDate(order.getTimeOfPurchase()),
								order.getOrderBook().getCompanyName(),
								order.getShares(),
								order.getPrice(),
								order.getOrderStatus(),
								order instanceof BuyOrder ? "BUY" : "SELL"	
							)
					);
		});
		return orderDto;
	}

}
