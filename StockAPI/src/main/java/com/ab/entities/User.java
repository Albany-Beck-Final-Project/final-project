package com.ab.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="User")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {	
	
	public User(String firstName, String lastName, String email, String password, int balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userID;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double balance; 



}
