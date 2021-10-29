package com.ab.authorization;

import java.util.Map;


public interface IAuthorization {

	public boolean authorizeLogin(Map<String, String> userDetails);
	
	public boolean authorizeSession(Map<String, String> userDetails);
	
}
