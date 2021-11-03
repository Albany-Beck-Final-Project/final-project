package com.ab.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ab.enums.OrderStatus;
import com.ab.enums.OrderType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BuyOrder extends Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int buyOrderId;
	
	public BuyOrder(double price, int shares, LocalDateTime timeOfPurchase, String orderStatus, String orderType,
			User user, OrderBook orderBook) { 
		super(price, shares, timeOfPurchase, orderStatus, orderType, user, orderBook);
	}
	
	public BuyOrder(double price, int shares, LocalDateTime timeOfPurchase, String orderStatus, String orderType, double limitPrice,
			User user, OrderBook orderBook) { 
		super(price, shares, timeOfPurchase, orderStatus, orderType, limitPrice, user, orderBook);
	}
	
	public int getBuyOrderId() {
		return buyOrderId;
	}

	public BuyOrder(Double price, int shares, LocalDateTime timeOfPurchase, String orderStatus, String orderType, double limit,
			User user, OrderBook orderBook) {
		super(price, shares, timeOfPurchase, orderStatus, orderType, limit, user, orderBook);
	}
	
	
}
