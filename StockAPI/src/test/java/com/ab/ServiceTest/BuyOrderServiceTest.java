package com.ab.ServiceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

	//@Test
	//public void deleteOrder() { 
	
	//}
}