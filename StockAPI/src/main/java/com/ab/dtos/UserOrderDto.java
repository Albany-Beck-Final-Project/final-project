package com.ab.dtos;

import java.time.LocalDateTime;

import com.ab.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserOrderDto {

	private int orderId;
	private String timeOfPurchase;
	private String stockName;
	private int shares;
	private double price;
	private OrderStatus orderStatus;
	private String orderDirection;
}
