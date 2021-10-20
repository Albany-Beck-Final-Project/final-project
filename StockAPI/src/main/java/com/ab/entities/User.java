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
	
	

}
