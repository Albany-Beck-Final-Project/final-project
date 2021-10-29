package com.ab.helpers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ab.entities.User;
import com.ab.repositories.UserRepository;

@Component
public class UserHelper {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Boolean validateRegistrationPasswords(String password,String confirmPassword) {
		return confirmPassword.equals(password);
	}
	
	public Map<String, String> encryptUserData(Map<String, String> userDetails) {
		userDetails.replace("password", passwordEncoder.encode(userDetails.get("password")));
		return userDetails;
	}

	public boolean emailExists(String email) {
		List<User> usersWithEmail = userRepo.getAllByEmail(email);
//		true: if length of usersWithEmail > 0 -> this means the email exists in the database.
//		false: if length of usersWithEmail == 0 -> No matching email so it is unique
		return usersWithEmail.size() > 0;
	}

}
