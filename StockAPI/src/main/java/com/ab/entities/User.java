package com.ab.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="User")
@AllArgsConstructor
@NoArgsConstructor
public class User {	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
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

//	public User(int userID, String firstName, String lastName, String email, String password, double balance) {
//		super();
//		this.userID = userID;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.password = password;
//		this.balance = balance;
//	}
	
	public User(String firstName, String lastName, String email, String password, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}
	
	public User() {}

}
