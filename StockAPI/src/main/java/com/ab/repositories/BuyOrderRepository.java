package com.ab.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ab.entities.BuyOrder;
import com.ab.enums.OrderStatus;

@Repository	
public interface BuyOrderRepository extends JpaRepository<BuyOrder,Integer>{

	//Basic methods are already included
	/**
	@Transactional
	@Modifying
	@Query("UPDATE buy_order")
	public OrderStatus updateOrderStatusBuy(@Param("orderStatus")OrderStatus orderStatus, @Param("id")int id);
	**/
	/**
	@Transactional
	@Modifying
    @Query("UPDATE Employee e SET e.employeeEmail =:email WHERE e.employeeId =:id")
    public int updateEmployeeEmailByEmployeeId(@Param("email")String email, @Param("id")int id);
	
	**/
	
	
}