package com.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.BookCab;
import com.entity.Cab;
import com.entity.CabType;
import com.entity.Location;

@SpringBootTest
class BookCabServiceTest {

	@Autowired
	BookCabService bookcabService;
	@Autowired
	CabTypeService cabTypeService;
	@Autowired
	LocationService locationService;
	
	//@Test
	void testFindAllBooking() {
		List<BookCab> bookingList = bookcabService.findAllBooking();
		assertNotNull(bookingList);
		assertEquals(12, bookingList.size());
		BookCab bookingDetails = bookingList.get(2);
		assertEquals(1920, bookingDetails.getFare());
		
	}

	@Test
	void testCreateBookings() {
		
		List<CabType> cab = cabTypeService.getallcabType();
		List<Location> location = locationService.getallLocation();
		assertEquals("Booking Done Successfully", bookcabService.createBookings(cab.get(1).getCabtype_id(), location.get(1).getId(), location.get(1).getId()));
		
	}

}