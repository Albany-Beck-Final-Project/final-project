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
	
	
	
	

}
