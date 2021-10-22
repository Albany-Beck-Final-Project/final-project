package com.ab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.dtos.UserDto;
import com.ab.entities.User;
import com.ab.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
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
	
	/***
	 * 
	 * 
	 */
	public void register(String firstName, String lastName, String email, String password, double balance) { 
		
		User user = new User(firstName, lastName, email, password, 0);
		
		userRepo.save(user);
	}
	
	/**
	public void login(String email, String password) { 
		
		userRepo.findLoginDetails(email, password);
		
	}
	**/
}
