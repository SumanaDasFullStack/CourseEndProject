package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Distance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dist_id;
	@ManyToOne
    @JoinColumn(name = "from_location_id")
    private Location fromLocation;

    @ManyToOne
    @JoinColumn(name = "to_location_id")
    private Location toLocation;

    private double distance; // Distance in kilometers
    
 // Constructors, Getters, and Setters
    public Distance() {}

    public Distance(Location fromLocation, Location toLocation, double distance) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.distance = distance;
    }

}
