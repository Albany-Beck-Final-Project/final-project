package com.ab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ab.entities.TradeHistory;

public interface TradeHistoryRepository extends JpaRepository<TradeHistory, Integer> {

}
