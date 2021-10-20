package com.ab.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.ab.enums.OrderDirection;
import com.ab.enums.OrderStatus;
import com.ab.enums.OrderType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Order {
	
	@Getter
	private double price;
	
	@Getter
	private int shares;
	
	@Getter
	private LocalDateTime timeOfPurchase;
	
	@Getter
	private OrderStatus orderStatus;
	
	@Getter
	private OrderType orderType;
	
	@Getter
	private double limitPrice;
	
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	@Getter
	private User user;
	
	@ManyToOne 
	@JoinColumn(name = "order_book_id")
	@Getter
	private OrderBook orderBook;

	public Order(double price, int shares, LocalDateTime timeOfPurchase, OrderStatus orderStatus, OrderType orderType,
			double limitPrice, User user, OrderBook orderBook) {
		super();
		this.price = price;
		this.shares = shares;
		this.timeOfPurchase = timeOfPurchase;
		this.orderStatus = orderStatus;
		this.orderType = orderType;
		this.limitPrice = limitPrice;
		this.user = user;
		this.orderBook = orderBook;
	} 
	
	
	public Order() {}


	public double getPrice() {
		return price;
	}


	public int getShares() {
		return shares;
	}


	public LocalDateTime getTimeOfPurchase() {
		return timeOfPurchase;
	}


	public OrderStatus getOrderStatus() {
		return orderStatus;
	}


	public OrderType getOrderType() {
		return orderType;
	}


	public double getLimitPrice() {
		return limitPrice;
	}


	public User getUser() {
		return user;
	}


	public OrderBook getOrderBook() {
		return orderBook;
	}
	
	
	
	

}
