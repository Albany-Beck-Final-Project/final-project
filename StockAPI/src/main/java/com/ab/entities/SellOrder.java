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
public class SellOrder extends Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sellOrderId;

	public SellOrder(Double price, int shares, LocalDateTime timeOfPurchase, OrderStatus orderStatus, OrderType orderType, double limit,
			User user, OrderBook orderBook) {
		super(price, shares, timeOfPurchase, orderStatus, orderType, limit, user, orderBook);
	}

}
