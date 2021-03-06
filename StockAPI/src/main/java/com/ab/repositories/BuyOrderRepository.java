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
public interface BuyOrderRepository extends JpaRepository<BuyOrder,Integer> {

	//Basic methods are already included
	
	@Query("SELECT b from BuyOrder b WHERE b.buyOrderId=:id")
	public BuyOrder findBuyOrderById(@Param("id") int id);
	
	@Transactional 
	@Modifying
	@Query("UPDATE BuyOrder b SET b.orderStatus =:status WHERE b.buyOrderId =:id")
	public int updateOrderStatusByOrderId(@Param("status")String status,@Param("id") int id);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE BuyOrder b SET b.orderType =:type WHERE b.buyOrderId =:id")
	public int updateOrderTypeByOrderId(@Param("type")String type, @Param("id") int id);

	@Query("SELECT b FROM BuyOrder b WHERE b.user.userId=:userId")
	public List<BuyOrder> findAllByUserId(int userId);

	@Query("SELECT b from BuyOrder b WHERE b.orderBook.companyName=:stock AND b.available > 0")
	public List<BuyOrder> findAllByStockName(String stock);

	@Query("SELECT b from BuyOrder b WHERE b.orderStatus='NEW' OR b.orderStatus='PARTIALLY_FILLED' ORDER BY b.timeOfPurchase DESC")
	public List<BuyOrder> getAllToMatch();

	
	@Transactional
	@Modifying
	@Query("UPDATE BuyOrder b SET b.available=:available WHERE b.buyOrderId=:buyOrderId")
	public int updateAvailableByOrderId(int available, int buyOrderId);

	
	
	
}