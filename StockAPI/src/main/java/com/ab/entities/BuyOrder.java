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
	
	public BuyOrder(double price, int shares, LocalDateTime timeOfPurchase, String orderStatus, String orderType) { 
		super(price, shares, timeOfPurchase, orderStatus, orderType);
	}
	
	public BuyOrder(double price, int shares, LocalDateTime timeOfPurchase, String orderStatus, String orderType, double limitPrice) { 
		super(price, shares, timeOfPurchase, orderStatus, orderType, limitPrice);
	}
	
	public int getBuyOrderId() {
		return buyOrderId;
	}

	public BuyOrder(Double price, int shares, LocalDateTime timeOfPurchase, OrderStatus orderStatus, OrderType orderType, double limit,
			User user, OrderBook orderBook) {
		super(price, shares, timeOfPurchase, orderStatus, orderType, limit, user, orderBook);
	}
	
	
}
