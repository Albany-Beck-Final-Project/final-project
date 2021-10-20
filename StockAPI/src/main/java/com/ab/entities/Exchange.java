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
	
}
