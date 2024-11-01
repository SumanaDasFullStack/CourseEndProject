package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cab {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cab_id;
	@Column(unique = true)
	private String number;
	private String model;
	private int seat_capacity;
	private Long cabtype_id;
	
	

}