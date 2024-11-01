package com.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.Location;

@SpringBootTest
class LocationServiceTest {

	
	@Autowired
	LocationService locationService;
	
	//@Test
	void testGetallLocation() {
		List<Location> locationList = locationService.getallLocation();
		assertNotNull(locationList);
		assertEquals(4, locationList.size());
		Location loc = locationList.get(2); 
		assertEquals("Panskura",loc.getLoc_name());
		 
	}

	@Test
	void testAddLocation() {
		
		List<Location> loc = locationService.getallLocation();
		Location location = new Location();
		location.setId(8L);
		location.setLoc_name("Sodepur");
		assertEquals("Location added Successfully", locationService.addLocation(location));
		
	}

	

}