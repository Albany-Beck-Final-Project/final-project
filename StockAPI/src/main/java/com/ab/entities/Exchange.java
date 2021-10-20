package com.ab.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="Exchange")
@AllArgsConstructor
@NoArgsConstructor
public class Exchange {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Getter
	private int exchangeID;
	
	@Getter
	private String exchangeName;
	
	@Getter
	private double feeLadder;
	
	@Getter
	private int currentDaysTotalTradedValue;
	
	
	@OneToMany(fetch = FetchType.EAGER,
			mappedBy = "orderBookID",
			cascade = CascadeType.ALL)
	@Getter
	private List<OrderBook> orderBooks;
	
	
	public Exchange() {}


	public Exchange(int exchangeID, String exchangeName, double feeLadder, int currentDaysTotalTradedValue,
			List<OrderBook> orderBooks) {
		super();
		this.exchangeID = exchangeID;
		this.exchangeName = exchangeName;
		this.feeLadder = feeLadder;
		this.currentDaysTotalTradedValue = currentDaysTotalTradedValue;
		this.orderBooks = orderBooks;
	}


	public int getExchangeID() {
		return exchangeID;
	}


	public String getExchangeName() {
		return exchangeName;
	}


	public double getFeeLadder() {
		return feeLadder;
	}


	public int getCurrentDaysTotalTradedValue() {
		return currentDaysTotalTradedValue;
	}


	public List<OrderBook> getOrderBooks() {
		return orderBooks;
	}
	
	
	
	
	
}
