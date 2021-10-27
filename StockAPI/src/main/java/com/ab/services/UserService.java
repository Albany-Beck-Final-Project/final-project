package com.ab.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.dtos.UserDto;
import com.ab.entities.User;
import com.ab.helpers.UserHelper;
import com.ab.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserHelper userHelper;
	
//	TODO: Login
//	TODO: Logout
//	TODO: Register
//	TODO: UpdateDetails
	
	
	/**
	 * 
	 * @param newUser DTO of User's information
	 * @return true if user saved to database. false if user not saved to database
	 */
	
	/**
	 * public boolean register(UserDto newUser) {
		
//		Return true if user saved
		User user = new User(
					newUser.getFirstName(),
					newUser.getLastName(),
					newUser.getEmail(),
					newUser.getPassword(),
					newUser.getBalance()
				);
		return userRepo.save(user) != null;
	}
	**/
	
	/**
	 * @return *
	 * 
	 * 
	 */
	
	
	public String register(Map<String, String> newUserDetails) { 
		
		if(!(userHelper.validateRegistrationPasswords(newUserDetails.get("password"), newUserDetails.get("confirmPassword")))) {
			return "Passwords are not matching!";
		}
		
		User user = new User(
				            newUserDetails.get("firstName"), 
				            newUserDetails.get("lastName"), 
				            newUserDetails.get("email"), 
				            newUserDetails.get("password"), 
							0);
		
		userRepo.save(user);
	}
	
	/**
	public void login(String email, String password) { 
		
		userRepo.findLoginDetails(email, password);
		
	}
	**/
}
