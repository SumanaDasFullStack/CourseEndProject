package com.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.CabType;
import com.entity.Location;

@SpringBootTest
class FareServiceTest {

	@Autowired
	CabTypeService cabTypeService;
	@Autowired
	LocationService locationService;
	@Autowired
	FareService fareService;
	
	
	@Test
	void testCalculateFare() {
		List<CabType> cab = cabTypeService.getallcabType();
		List<Location> location = locationService.getallLocation();
		String source = location.get(1).getId().toString();
		String destination = location.get(2).getId().toString();
		assertEquals(1320.0, fareService.calculateFare(source, destination, cab.get(1).getCabtype_id()));
	}

}