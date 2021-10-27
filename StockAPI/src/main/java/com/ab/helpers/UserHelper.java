package com.ab.helpers;

public class UserHelper {
	
	public Boolean validateRegistrationPasswords(String password,String confirmPassword) {
		return confirmPassword.equals(password);
	}

}
