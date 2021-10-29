package com.ab.authorization;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ab.entities.User;
import com.ab.repositories.SessionRepository;
import com.ab.repositories.UserRepository;

@Service
public class Authorization implements IAuthorization, IAuthExtraction {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SessionRepository sessionRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean authorizeLogin(Map<String, String> userDetails) {
		
		Optional<User> user = userRepo.getByEmail(getEmail(userDetails));
//		If user does not exists/email invalid -> return false[unauthorized]
		if(user.get() == null) {
			return false;
		}
//		Password matcher
		if(_validatePasswords(user.get(), getPassword(userDetails))) {
			return true;
		} else {
			return false;
		}
	}
	
	
	@Override
	public boolean authorizeSession(Map<String, String> userDetails) {
		Optional<User> user = sessionRepo.getUserBySessionId(getSession(userDetails));
		if(user.get() == null) {
			return false;
		} else {
			return true;
		}
	}
	
	
	@Override
	public String getEmail(Map<String, String> userDetails) {
		return new String(_decodeValues(userDetails.get("email")));
	}
	
	@Override
	public String getPassword(Map<String, String> userDetails) {
		return new String(_decodeValues(userDetails.get("password")));
	}
	
	@Override
	public String getSession(Map<String, String> userDetails) {
		return new String(_decodeValues(userDetails.get("session")));
	}
	
	@Override
	public Map<String, String> decodeValues(Map<String, String> userDetails) {
		Map<String, String> newDetails = new HashMap<>();
		userDetails.forEach((key, value) -> {
			newDetails.put(key, new String(_decodeValues(value)));
		});
		return newDetails;
	}
	
	
	
	private boolean _validatePasswords(User user, String password) {
		return passwordEncoder.matches(password, user.getPassword());
	}
	
	private byte[] _decodeValues(String value) {
		return Base64.getDecoder().decode(value);
	}
}
