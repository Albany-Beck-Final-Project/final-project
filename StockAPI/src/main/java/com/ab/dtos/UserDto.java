package com.ab.dtos;
import javax.security.auth.login.*;

public class UserDto {
	
	//@NotEmpty
	//@NotNull
	private int userID;

	private String firstName;
	
	
	private String lastName;
	
	
	private String email;
	
	
	private String password;
	private String matchingPassword;
	
	public UserDto() {}

	public UserDto(int userID, String firstName, String lastName, String email, String password, String matchingPassword, double balance) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.balance = balance;
	}
	
	public UserDto(String firstName, String lastName, String email, String password, String matchingPassword, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.balance = balance;
	}

	private double balance;

	public int getUserID() {
		return userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public String getMatchingPassword() {
		return matchingPassword;
	}
	
	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "UserDto [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", matchingPassword=" + matchingPassword + ", balance=" + balance + "]";
	}
	
	
	
}
