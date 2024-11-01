package com.controller;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dto.BookingRequest;
import com.entity.BookCab;
import com.entity.Cab;
import com.entity.CabType;
import com.entity.Location;
import com.repository.CabRepository;
import com.service.BookCabService;
import com.service.CabService;
import com.service.CabTypeService;
import com.service.LocationService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("booking")
public class BookingController {
	
	
	@Autowired
	private BookCabService bookcabService;
	
	//http://localhost:9191/booking/book
	@PostMapping(value = "book",consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookCab> bookCab(@RequestBody BookingRequest bookingRequest) {
		BookCab booking = bookcabService.createBookings(
                bookingRequest.getCabTypeId(),
                bookingRequest.getSourceId(),
                bookingRequest.getDestinationId());
        return ResponseEntity.ok(booking);
    }

	
	
}
