package com.ab.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
		System.out.println("triggered register");
		if(!(userHelper.validateRegistrationPasswords(newUserDetails.get("password"), newUserDetails.get("confirmPassword")))) {
			System.out.println("passwords don't match");
			return "Passwords are not matching!";
		}
		newUserDetails = userHelper.encryptUserData(newUserDetails);
		System.out.println("encrypted details");
		
		if(userHelper.emailExists(newUserDetails.get("email"))) {
			System.out.println("email exists");
			return "Email already exists!";
		}
		
		User user = new User(
				            newUserDetails.get("firstName"), 
				            newUserDetails.get("lastName"), 
				            newUserDetails.get("email"), 
				            newUserDetails.get("password"), 
							0);
		System.out.println("new user object");
		
		if (userRepo.save(user) != null) {
//			TODO: Encrypted email & password for authentication
//			TODO: JWT token for authentication
			
//			TODO: Generate Cookie
//			TODO: Save cookie in Session table 
//			TODO: Return cookie to front end to store in sessions
			return "Successfully Registered!";
		} else {
			return "Error Registering User!";
		}
	}



	public User login(String email) {
//		1. Encrypt User Data (Email and Password)
		
//		2. Check to see if user exists by looking for matching email (email is unique)
		return userRepo.getUserByEmail(email);
	
	}



	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.getUserByEmail(email);

	}
	
	/**
	public void login(String email, String password) { 
		
		userRepo.findLoginDetails(email, password);
		
	}
	**/
	
}
	
	
