package com.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class CabType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cabtype_id;
	@Column(unique = true)
	private String cabtype_name;
	private double base_fare;
	private double kmhr_fare;
	@OneToMany
	@JoinColumn(name = "cabtype_id")
	List<Cab> typescabs;

}
