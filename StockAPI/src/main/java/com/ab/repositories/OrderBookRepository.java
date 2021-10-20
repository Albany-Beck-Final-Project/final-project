package com.ab.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ab.entities.OrderBook;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook,Integer> {
	
	
	
}
