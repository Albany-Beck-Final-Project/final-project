package com.ab.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	public UserDto() {}

	public UserDto(int userID, String firstName, String lastName, String email, String password, double balance) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}
	
	public UserDto(String firstName, String lastName, String email, String password, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}

	@Getter
	private int userID;
	@Getter
	private String firstName;
	
	@Getter
	private String lastName;
	
	@Getter
	private String email;
	
	@Getter
	private String password;
	
	@Getter
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

	public double getBalance() {
		return balance;
	}
	
	
	
}
