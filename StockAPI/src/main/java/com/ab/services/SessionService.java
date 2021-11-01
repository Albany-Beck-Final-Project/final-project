package com.ab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.Session;
import com.ab.entities.User;
import com.ab.helpers.SessionHelper;
import com.ab.repositories.SessionRepository;

@Service(value="databaseSession")
public class SessionService implements ISessionService {
	
	@Autowired
	private SessionRepository sessionRepo;
	
	@Autowired
	private SessionHelper sessionHelper;

	@Override
	public String generateSession(User user) {
		String sessionId = sessionHelper.generateSessionId();
		if (sessionRepo.save(new Session(sessionId, user)) != null) {
			return sessionId;
		}
		return null;
	}
	
	@Override
	public String removeSession(String sessionId) {
		sessionRepo.removeBySessionId(sessionId);
		return "successful";
	}
}
