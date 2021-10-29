package com.ab.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


import com.ab.enums.OrderStatus;
import com.ab.enums.OrderType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	
	private double price;
	
	private int shares;
	
	private LocalDateTime timeOfPurchase;
	
	@Enumerated(EnumType.STRING)
	private String orderStatus;	
	
	@Enumerated(EnumType.STRING)
	private String orderType;

	private double limitPrice;
	
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User user;
	
	@ManyToOne 
	@JoinColumn(name = "order_book_id")
	private OrderBook orderBook;

}
