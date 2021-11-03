package com.ab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ab.entities.OrderBook;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook,Integer> {

	@Query("SELECT o FROM OrderBook o WHERE o.companyName=:companyName")
	public OrderBook getByCompanyName(String companyName);
	
	//Implemented methods for basic commands 
	
	
}
