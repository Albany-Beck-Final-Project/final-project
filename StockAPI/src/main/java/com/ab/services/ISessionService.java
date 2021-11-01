package com.ab.services;

import com.ab.entities.User;

public interface ISessionService {

	public String generateSession(User user);

	public String removeSession(String sessionId);

}
