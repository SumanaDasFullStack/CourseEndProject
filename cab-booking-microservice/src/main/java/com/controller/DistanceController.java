package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Distance;
import com.entity.Location;
import com.service.DistanceService;
import com.service.LocationService;

@RestController
@RequestMapping("distance")
public class DistanceController {
	
	@Autowired
	DistanceService distanceService;
	@Autowired
	LocationService locationService;
	
	//http://localhost:9191/distance/distances
	@PostMapping(value = "add_dist",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Distance createDistance(@RequestBody Distance distance) {
        return distanceService.saveDistance(distance);
    }
	
		//http://localhost:9191/distance/from/1
		 @GetMapping("/from/{locationId}")
		    public List<Distance> getDistancesFromLocation(@PathVariable Long locationId) {
		        Location location = locationService.getallLocation().stream()
		                .filter(loc -> loc.getId().equals(locationId))
		                .findFirst()
		                .orElse(null);
		        return distanceService.getDistancesFromLocation(location);
		    }
	
		//http://localhost:9191/distance/from/1/2
		 @GetMapping("/from/{fromId}/{toId}")
		    public double getDistance(@PathVariable Long fromId, @PathVariable Long toId) {
		        return distanceService.getDistance(fromId, toId);
		    }

}
