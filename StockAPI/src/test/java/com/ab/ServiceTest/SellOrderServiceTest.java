package com.ab.ServiceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

	//@Test
	//public void updateOrderStatus(String email, int id) { 
	//		
	//}
}
