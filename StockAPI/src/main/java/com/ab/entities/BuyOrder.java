package com.ab.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ab.enums.OrderStatus;
import com.ab.enums.OrderType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BuyOrder extends Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int buyOrderId;

	public BuyOrder(double price, int shares, LocalDateTime timeOfPurchase, OrderStatus orderStatus,
			OrderType orderType, double limitPrice, User user, OrderBook orderBook, int buyOrderId) {
		super(price, shares, timeOfPurchase, orderStatus, orderType, limitPrice, user, orderBook);
		this.buyOrderId = buyOrderId;
	}
	
	public BuyOrder() {} 
	
	public int getBuyOrderId() {
		return buyOrderId;
	}
	
}
