package com.ab.restcontroller;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.ab.authorization.Authorization;
import com.ab.entities.User;
import com.ab.services.ISessionService;
import com.ab.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:6030")
public class SessionController {

	@Autowired
	@Qualifier("databaseSession")
	private ISessionService sessionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired Authorization auth;
	
	@PostMapping("/users")
	public Map<String, String> login(@RequestBody Map<String, String> userDetails) throws IOException {
		Map<String, String> returnJson = new HashMap<>();
		if(!(auth.authorizeLogin(userDetails))) {
			returnJson.put("status", "Error");
		} else {
			returnJson.put("status", "successful");
	
			User user = userService.login(auth.getEmail(userDetails));
			
			returnJson.put("session",  sessionService.generateSession(user));
		}
		return returnJson;
//		System.out.println(userDetails);
	}
	
	@DeleteMapping("/users")
	public Map<String, String> logout(@RequestBody Map<String, String> sessionDetails) {
		Map<String, String> returnJson = new HashMap<>();
		
		returnJson.put("status", sessionService.removeSession(sessionDetails.get("session")));
			
		return returnJson;
	}
	
	
	
	@GetMapping("/principal")
	public String principalHandler(Principal p, Model m) {
		User user = userService.getByEmail(p.getName());
//		System.out.println(p);
//		m.addAttribute("user", userService.getByEmail(email));
		return sessionService.generateSession(user);
	}
	
	@ModelAttribute("user")
	public User user() {
		return new User();
	}
}
