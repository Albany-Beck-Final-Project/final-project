package com.ab.restcontroller;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
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
//@CrossOrigin(origins= { "localhost:6030" })
public class SessionController {

	@Autowired
	@Qualifier("databaseSession")
	private ISessionService sessionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired Authorization auth;
	
	@PostMapping("/users")
	public String login(@RequestBody Map<String, String> userDetails) throws IOException {
		if(!(auth.authorizeLogin(userDetails))) {
			return "Error";
		}
		User user = userService.login(auth.getEmail(userDetails));
		return sessionService.generateSession(user);
//		System.out.println(userDetails);
	}
	
//	@GetMapping("/login")
//	public RedirectView testLogin(Principal p) throws IOException {
//		
//	}
	
	
	
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
