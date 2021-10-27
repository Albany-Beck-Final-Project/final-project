package com.ab.restcontroller;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.ab.dtos.UserDto;

@RestController
public class RegistrationController {
		
//	@GetMapping("/user/registration")
//	public String showRegistrationForm(WebRequest request, Model model) { 
//		UserDto userDto = new UserDto();
//		model.addAttribute("user", userDto);
//		return "registration";
//		
//	}
	
	@PostMapping("/user/new")
	public String register(@RequestBody Map<String, String> newUserDetails) {
		return " ";
		
	}
	
}
