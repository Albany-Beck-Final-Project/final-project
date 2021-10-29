package com.ab.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.entities.BuyOrder;
import com.ab.services.BuyOrderService;

@RestController
public class BuyOrderRestController {

	@Autowired
	private BuyOrderService buyOrderService;
	
	
}
