package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Location;
import com.repository.LocationRepository;

@Service
public class LocationService {
	@Autowired
	LocationRepository locationRepository;
	
	public List<Location> getallLocation(){
		return locationRepository.findAll();
		}
	
	public String addLocation(Location location) {
		locationRepository.save(location);
		return "Location added Successfully";
		
	}
	
	public Location getLocationById(Long id) {
        return locationRepository.findById(id).orElseThrow(() -> new RuntimeException("Location not found"));
    }

}
