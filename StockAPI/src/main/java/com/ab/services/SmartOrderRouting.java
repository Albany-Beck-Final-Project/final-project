package com.ab.services;

import java.util.List;

import org.hibernate.dialect.lock.AbstractSelectLockingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.BuyOrder;
import com.ab.entities.SellOrder;

@Service
public class SmartOrderRouting {
	
	private static final float THRESHOLD = 0.03f;
	
	@Autowired
	private BuyOrderService buyOrderService;
	
	@Autowired
	private SellOrderService sellOrderService;
	
	@Autowired
	private TradeHistoryService tradeHistoryService;
	
	public void match() {
//		get buy orders WHERE status = NEW or PARTIAL -> ORDER earliest date
//		get sell orders WHERE status = NEW or PARTIAL -> ORDER earliest date
		
//		iterate buy orders
//		FOR EACH:
//			iterate sell orders
//				FOR EACH:
//					if price matches within + or - threshold, generate match
//					(if quantity matches)
//						check availability of each
//						if BUY is 20 and SELL is 50:
//							BUY status = FULLY_FILLED and SELL available = 50 - 20(buy)
		
//						if SELL is 20 and BUY is 50:
//							SELL status = FULLY_FILLED and BUY available = 50 - 20(sell)
//						Create new trade and add to trade history
		
		
		
		List<BuyOrder> buyOrders = buyOrderService.getAllToMatch();
		List<SellOrder> sellOrders = sellOrderService.getAllToMatch();
		
		for(BuyOrder buy : buyOrders) {
			System.out.println("\n "+buy);
			for(SellOrder sell : sellOrders) {
				if (sell.getAvailable() == 0) {
					continue;
				}
				if (buy.getOrderBook().getOrderBookID() != sell.getOrderBook().getOrderBookID()) {
					continue;
				}
				System.out.println(sell);
//				1000 - 700 > threshold, 700 - 1000 < -threshold
				
				if ((buy.getPrice() - sell.getPrice()) <= THRESHOLD & (sell.getPrice() - buy.getPrice()) >= -(THRESHOLD)) {
					
					if (buy.getAvailable() == sell.getAvailable()) {
//						FULLLY_FILLED BuyOrder and SellOrder
						System.out.println("buy == sell");
						
//						TODO: set status to FULLY_FILLED on both 						-> YES
//						TODO: set available to 0 on both								-> YES
//						TODO: add to TradeHistory where quantity = available of either 	-> YES
						
						_setOrderStatus(buy, sell);
						_setAvailable(buy, sell);
						tradeHistoryService.createNewTrade(buy, sell, 0);
						
					} else if (buy.getAvailable() > sell.getAvailable()) {
//						FULLY_FILLED SellOrder
						System.out.println("buy > sell");
						
//						TODO: set status to FULLY_FILLED on SellOrder
//						TODO: set status to PARTIALLY_FILLED on BuyOrder
//						TODO: set available to available - quantity on BuyOrder 
//						TODO: add to TradeHistory where quantity = available of SellOrder
						_setOrderStatus(sell, "FULLY_FILLED");
						_setOrderStatus(buy, "PARTIALLY_FILLED");
						_setAvailable(buy, (buy.getAvailable() - sell.getAvailable()));
						_setAvailable(sell, 0);
						tradeHistoryService.createNewTrade(buy, sell, sell.getAvailable());
					} else {
//						FULLY_FILLED BuyOrder
						System.out.println("WORKING!");
						
//						TODO: set status to FULLY_FILLED on SellOrder
//						TODO: set status to PARTIALLY_FILLED on BuyOrder
//						TODO: set available to available - quantity on BuyOrder 
//						TODO: add to TradeHistory where quantity = available of SellOrder	
						
						_setOrderStatus(buy, "FULLY_FILLED");
						_setOrderStatus(sell, "PARTIALLY_FILLED");
						int newAvailable = (sell.getAvailable() - buy.getAvailable());
						System.out.println(newAvailable);
						_setAvailable(sell, newAvailable);
						_setAvailable(buy, 0);
						tradeHistoryService.createNewTrade(buy, sell, buy.getAvailable());
					}
				}
				
			}
			
		}
		
		
		
		
	}
	
	
	private boolean _setOrderStatus(BuyOrder buy, SellOrder sell) {
		
		return (buyOrderService.updateStatus(buy, "FULLY_FILLED") & sellOrderService.updateStatus(sell, "FULLY_FILLED"));
	}
	
	private boolean _setOrderStatus(BuyOrder buy, String status) {
		
		return (buyOrderService.updateStatus(buy, status));
	}
	
private boolean _setOrderStatus(SellOrder sell, String status) {
		
		return (sellOrderService.updateStatus(sell, status));
	}
	
	private boolean _setAvailable(BuyOrder buy, SellOrder sell) {
		return (buyOrderService.updateAvailable(buy, 0) & sellOrderService.updateAvailable(sell, 0));
	}
	
	private boolean _setAvailable(BuyOrder buy, int newAvailable) {
		return buyOrderService.updateAvailable(buy, newAvailable);
	}
	
	private boolean _setAvailable(SellOrder sell, int newAvailable) {
		return sellOrderService.updateAvailable(sell, newAvailable);
	}


}
