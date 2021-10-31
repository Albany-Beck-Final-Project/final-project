package com.ab.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.ab.authorization.Authorization;
import com.ab.dtos.UserDto;
import com.ab.services.UserService;

@CrossOrigin(origins = { "http://localhost:6030" })
@RestController
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Authorization auth;
		
//	@GetMapping("/user/registration")
//	public String showRegistrationForm(WebRequest request, Model model) { 
//		UserDto userDto = new UserDto();
//		model.addAttribute("user", userDto);
//		return "registration";
//		
//	}
	
	@PostMapping("/users/new")
	public Map<String, String> register(@RequestBody Map<String, String> newUserDetails) {
		newUserDetails = auth.decodeValues(newUserDetails);
		System.out.println(newUserDetails);
		Map<String, String> returnJson = new HashMap<>();
		returnJson.put("status", userService.register(newUserDetails));
		return returnJson;
	}
	
}
