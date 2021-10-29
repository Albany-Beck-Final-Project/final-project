package com.ab.authorization;

import java.util.Map;

public interface IAuthExtraction {

	public String getEmail(Map<String, String> userDetails);
	
	public String getPassword(Map<String, String> userDetails);
	
	public String getSession(Map<String, String> userDetails);
	
	public Map<String, String> decodeValues(Map<String, String> userDetails);
}
