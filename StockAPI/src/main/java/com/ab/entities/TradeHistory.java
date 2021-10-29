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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="TradeHistory")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TradeHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tradeID;
	
	@OneToOne
	@JoinColumn(name = "sell_order_id")
	private SellOrder sellOrder;
	
	@OneToOne
	@JoinColumn(name = "buy_order_id")
	private BuyOrder buyOrder;

	
}
