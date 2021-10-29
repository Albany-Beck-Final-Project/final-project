package com.ab.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ab.authorization.Authorization;
import com.ab.entities.BuyOrder;
import com.ab.services.BuyOrderService;

@RestController
public class BuyOrderRestController {

	@Autowired
	private BuyOrderService buyOrderService;
	
	@Autowired
	private Authorization auth;
	
	@PostMapping("/buyorders")
	public List<BuyOrder> getOrders(@RequestBody Map<String, String> userDetails) {
		if(!(auth.authorizeSession(userDetails))) {
			return null;
		}
		return buyOrderService.getAllBuyOrders();
	}
}
