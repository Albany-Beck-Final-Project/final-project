package com.ab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.BuyOrder;
import com.ab.entities.SellOrder;
import com.ab.entities.TradeHistory;
import com.ab.repositories.TradeHistoryRepository;

@Service
public class TradeHistoryService {

	@Autowired
	private TradeHistoryRepository tradeHistoryRepo;
	
	
	public void createNewTrade(BuyOrder buy, SellOrder sell, int quantity) {
		tradeHistoryRepo.save(new TradeHistory(buy, sell, quantity));
	}
}
