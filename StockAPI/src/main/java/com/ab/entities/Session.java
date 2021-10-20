package com.ab.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="Session")
@AllArgsConstructor
@NoArgsConstructor
public class Session {
	
	@Id
	@Getter
	private String sessionID;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	@Getter
	private User user;

	public Session(String sessionID, User user) {
		super();
		this.sessionID = sessionID;
		this.user = user;
	}
	
	
	public Session() {}


	public String getSessionID() {
		return sessionID;
	}


	public User getUser() {
		return user;
	}
	
	
	
	
}
