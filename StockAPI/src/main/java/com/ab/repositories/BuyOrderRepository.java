package com.ab.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ab.entities.BuyOrder;

@Repository	
public interface BuyOrderRepository extends JpaRepository<BuyOrder,Integer>{

	//Basic methods are already included
	
	@Query(value="SELECT * from BuyOrder b WHERE b.buyOrderId =: id", nativeQuery=true)
	public List<BuyOrder> findBuyOrderById(@Param("id") int id);
	
	@Transactional 
	@Modifying
	@Query("UPDATE BuyOrder b SET b.orderStatus =:status WHERE b.buyOrderId =:id")
	public int updateOrderStatusByOrderId(@Param("status")String status,@Param("id") int id);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE BuyOrder b SET b.orderType =:type WHERE b.buyOrderId =:id")
	public int updateOrderTypeByOrderId(@Param("type")String type, @Param("id") int id);
	
	
	
}