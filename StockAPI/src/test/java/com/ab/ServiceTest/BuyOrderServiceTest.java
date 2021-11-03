package com.ab.ServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ab.entities.BuyOrder;
import com.ab.services.BuyOrderService;

@SpringBootTest
public class BuyOrderServiceTest {
	
	@Autowired
	private BuyOrderService buyOrderService;
	
	@Test
	public void getOrders() { 
		buyOrderService.getAllBuyOrders(); 
		assertEquals("[]",buyOrderService.getAllBuyOrders().toString());
	}

	@Test
	public void deleteOrder() { 
		BuyOrder order = new BuyOrder();
		buyOrderService.deleteBuyOrder(order.getBuyOrderId());
		assertEquals(order, buyOrderService.deleteBuyOrder(order.getBuyOrderId()));
	}
}
