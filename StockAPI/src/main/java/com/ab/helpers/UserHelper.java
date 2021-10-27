package com.ab.helpers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ab.entities.User;
import com.ab.repositories.UserRepository;

@Component
public class UserHelper {
	
	@Autowired
	private UserRepository userRepo;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public Boolean validateRegistrationPasswords(String password,String confirmPassword) {
		return confirmPassword.equals(password);
	}
	
	public Map<String, String> encryptUserData(Map<String, String> newUserDetails) {
		newUserDetails.replace("email", passwordEncoder().encode(newUserDetails.get("email")));
		newUserDetails.replace("password", passwordEncoder().encode(newUserDetails.get("password")));
		return newUserDetails;
	}

	public boolean emailExists(String email) {
		List<User> usersWithEmail = userRepo.getByEmail(email);
//		true: if length of usersWithEmail > 0 -> this means the email exists in the database.
//		false: if length of usersWithEmail == 0 -> No matching email so it is unique
		return usersWithEmail.size() > 0;
	}

}
