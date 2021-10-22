package com.ab.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ab.entities.SellOrder;
import com.ab.enums.OrderStatus;

@Repository	
public interface SellOrderRepository extends JpaRepository<SellOrder,Integer>{

	//Basic methods are already included
	/**
	@Transactional
	@Modifying
	@Query("UPDATE Sell_Order o SET o.order_status =:orderStatus WHERE o.sell_order_id =:id")
	public OrderStatus updateOrderStatusSell(@Param("orderStatus")OrderStatus orderStatus, @Param("id")int id);
	
	**/
}