package com.ab.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BuyOrder extends Order{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int buyOrderId;
	
	
	
}
