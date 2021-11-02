package com.ab.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ab.authorization.Authorization;
import com.ab.entities.Exchange;

@RestController
@CrossOrigin(origins = "http://localhost:6030")
public class ExchangeController {
	
	@Autowired
	private Authorization auth;

	@PostMapping("/exchanges")
	public List<Exchange> getAllExchanges(@RequestBody Map<String, String> details) {
		if(!(auth.authorizeSession(details))) {
			return null;
		}
		
		
		return null;
	}
}
