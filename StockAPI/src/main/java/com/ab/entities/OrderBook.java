package com.ab.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="OrderBook")
@AllArgsConstructor
@NoArgsConstructor
public class OrderBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Getter
	private int orderBookID;
	@Getter
	private String companyName;
	@Getter
	private int totalOrders;
	
	@ManyToOne 
	@JoinColumn(name = "exchange_id")
	private Exchange exchange;

	
	@OneToMany(
				mappedBy = "orderBook",
		cascade = CascadeType.ALL)
	@Getter
	private List<SellOrder> sellOrders;
	

	@OneToMany(
				mappedBy = "orderBook",
		cascade = CascadeType.ALL)
	@Getter
	private List<BuyOrder> buyOrders;
	
	
	
}
