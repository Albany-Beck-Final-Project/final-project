package com.ab.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ab.entities.BuyOrder;
import com.ab.entities.SellOrder;
import com.ab.enums.OrderStatus;

@Repository	
public interface SellOrderRepository extends JpaRepository<SellOrder,Integer>{

	@Transactional 
	@Modifying
	@Query("UPDATE SellOrder s SET s.orderStatus =:status WHERE s.sellOrderId =:id")
	public int updateOrderStatusByOrderId(@Param("status")String status, @Param("id")int orderId);

	//Basic methods are already included
	/**
	@Transactional
	@Modifying
	@Query("UPDATE Sell_Order o SET o.order_status =:orderStatus WHERE o.sell_order_id =:id")
	public OrderStatus updateOrderStatusSell(@Param("orderStatus")OrderStatus orderStatus, @Param("id")int id);
	
	**/
	
	@Query("SELECT s FROM SellOrder s WHERE s.user.userId=:userId")
	public List<SellOrder> findAllByUserId(int userId);

	@Query("SELECT s FROM SellOrder s WHERE s.orderBook.companyName=:stock AND s.available > 0")
	public List<SellOrder> findAllByStockName(String stock);
	
//	@Query("SELECT s from SellOrder s WHERE s.status=NEW OR s.status=PARTIALLY_FILLED ORDER BY s.timeOfPurchase DESC")
	@Query("SELECT s from SellOrder s WHERE s.orderStatus='NEW' OR s.orderStatus='PARTIALLY_FILLED' ORDER BY s.timeOfPurchase DESC")
	public List<SellOrder> getAllToMatch();
	
	@Transactional
	@Modifying
	@Query("UPDATE SellOrder s SET s.available=:available WHERE s.sellOrderId=:sellOrderId")
	public int updateAvailableByOrderId(int available, int sellOrderId);
}