package com.ab.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ab.entities.User;
import com.ab.services.ISessionService;
import com.ab.services.UserService;

@RestController
public class SessionController {

	@Autowired
	@Qualifier("databaseSession")
	private ISessionService sessionService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public String login(@RequestBody Map<String, String> userDetails) {
		User user = userService.login(userDetails);
		return sessionService.generateSession(user);
	}
}
