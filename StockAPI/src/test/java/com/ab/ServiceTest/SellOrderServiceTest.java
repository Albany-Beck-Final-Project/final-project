package com.ab.ServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ab.entities.BuyOrder;
import com.ab.entities.SellOrder;
import com.ab.services.SellOrderService;



@SpringBootTest
public class SellOrderServiceTest {
	
	@Autowired
	private SellOrderService sellOrderService; 
	
	@Test
	public void getOrders() { 
		sellOrderService.getAllSellOrders();
		assertEquals("[]", sellOrderService.getAllSellOrders().toString());
	}

	@Test
		public void deleteSellOrderTest() { 
			SellOrder sellOrder = new SellOrder();
			sellOrderService.deleteSellOrder(sellOrder.getSellOrderId());
			assertEquals(sellOrder, sellOrderService.deleteSellOrder(sellOrder.getSellOrderId()));
		}
			
}
