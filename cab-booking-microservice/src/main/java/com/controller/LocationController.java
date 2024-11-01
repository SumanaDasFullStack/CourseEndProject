package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Location;
import com.service.LocationService;

@RestController
@RequestMapping("location")
public class LocationController {
	
	@Autowired
	LocationService locationService;
	//http://localhost:9191/location/getlocation
	@GetMapping(value = "getlocation",consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Location> getallLocation(){
		return locationService.getallLocation();
	}
	//http://localhost:9191/location/add_location
	@PostMapping(value = "add_location",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addLocation(@RequestBody Location location) {
		locationService.addLocation(location);
		return "Location added successfully";
	}

}
