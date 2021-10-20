package com.ab.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="TradeHistory")
@AllArgsConstructor
@NoArgsConstructor
public class TradeHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private int tradeID;
	
	@OneToOne
	@JoinColumn(name = "sell_order_id")
	@Getter
	private SellOrder sellOrder;
	
	@OneToOne
	@JoinColumn(name = "buy_order_id")
	@Getter
	private BuyOrder buyOrder;
}
