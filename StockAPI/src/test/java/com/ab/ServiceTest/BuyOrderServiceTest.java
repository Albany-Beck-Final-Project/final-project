package com.ab.ServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ab.entities.BuyOrder;
import com.ab.services.BuyOrderService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class BuyOrderServiceTest {
	
	@Autowired
	private BuyOrderService buyOrderService;
	
	@Test
	public void getOrders() { 
		buyOrderService.getAllBuyOrders(); 
		assertEquals("[]",buyOrderService.getAllBuyOrders().toString());
	}
	
	@Order(1)
	@Test
	public void deleteOrder() { 
		BuyOrder orderDelete = buyOrderService.findBuyOrderById(2);
		buyOrderService.deleteBuyOrder(orderDelete.getBuyOrderId());
		assertEquals(orderDelete.toString(), buyOrderService.deleteBuyOrder(orderDelete.getBuyOrderId()));
	}
}
