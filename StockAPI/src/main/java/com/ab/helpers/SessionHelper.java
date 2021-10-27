package com.ab.helpers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ab.repositories.SessionRepository;

@Component
public class SessionHelper {
	
	@Autowired
	private SessionRepository sessionRepo;
	
	private final String NUMERICS = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ/?@£#$%&";
	private Random randomGenerator = new Random();

	public String generateSessionId() {
//		Generate Session sessionId
//		Check sessionId does not exist in table
//		If does, repeat:...
		StringBuilder sessionId = new StringBuilder();
		do {
			sessionId = new StringBuilder();
			for(int i = 0; i < 24; i++) {
				sessionId.append(_generateNumeric());
			}
		} while (_sessionIdIsNotUnique(sessionId.toString()));
		
		return sessionId.toString();
	}
	
	
	private boolean _sessionIdIsNotUnique(String sessionId) {
		return (sessionRepo.getBySessionId(sessionId) != null);
	}
	
	private String _generateNumeric() {
//		nextInt(integer) -> chooses between 0 and integer - 1;
		return NUMERICS.split("")[randomGenerator.nextInt(NUMERICS.length())];
	}
}

