package com.ab.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="Session")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Session {
	
	@Id
	@Getter
	private String sessionId;

	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
}
