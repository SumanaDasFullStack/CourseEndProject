package com.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entity.BookCab;
import com.entity.Cab;
import com.entity.CabType;
import com.entity.Location;
import com.exception.CabNotAvailableException;
import com.repository.BookCabRepository;

@Service
public class BookCabService {

	@Autowired
	BookCabRepository bookcabRepository;
	@Autowired
	CabService cabService;
	@Autowired
	CabTypeService cabtypeService;
	@Autowired
	DistanceService distanceService;
	@Autowired
	LocationService locationService;
	private Cab Null;
	/*
	 * @Autowired RestTemplate restTemplate;
	 */
	/*
	 * private final RestTemplate restTemplate;
	 * 
	 * public BookCabService(RestTemplate restTemplate) { this.restTemplate =
	 * restTemplate; }
	 */

	public List<BookCab> findAllBooking() {
		return bookcabRepository.findAll();

	}

	public String createBooking(BookCab book) {
		bookcabRepository.save(book);
		return "booking done successfully";

	}

	/*
	 * public String fetchLocationList() {
	 * 
	 * 
	 * String url = "http://localhost:9191/location/getlocation";
	 * 
	 * 
	 * // Set the headers HttpHeaders headers = new HttpHeaders(); //
	 * headers.set("Custom-Header", "HeaderValue"); // Set any custom headers you
	 * need headers.set("Accept", "application/json"); // Specify the response type
	 * you expect
	 * 
	 * HttpEntity<String> entity = new HttpEntity<>(headers);
	 * 
	 * // Make the GET request and receive a response as String
	 * ResponseEntity<String> response = restTemplate.exchange( url, HttpMethod.GET,
	 * entity, String.class );
	 * 
	 * return response.getBody();
	 * 
	 * 
	 * ResponseEntity<List<Location>> response = restTemplate.exchange( url,
	 * HttpMethod.GET, entity, new ParameterizedTypeReference<List<Location>>() {}
	 * );
	 * 
	 * return response.getBody();
	 * 
	 * }
	 */
	public BookCab createBookings(Long cabtypeId, Long sourceId, Long destId) {

		// Fetch cab, source, and destination
		CabType cabtype = cabtypeService.getCabTypeById(cabtypeId);

		List<Cab> cabs = cabtype.getTypescabs();
		Cab cab = null;
		if (!cabs.isEmpty()) {

			cab = cabs.get(0);

		}

		Location source = locationService.getLocationById(sourceId);
		Location destination = locationService.getLocationById(destId);

		if (cab == null)
			throw new CabNotAvailableException("No cabs available for the selected type.");

		// Create bookingand save booking
		BookCab booking = new BookCab();

		// Calculate distance
		Double distanceInKm = distanceService.getDistance(sourceId, destId);

		// Calculate total fare (basefare+ distance * fare per km of the cab type)
		Double basefare = cabtype.getBase_fare();
		Double farePerKm = cabtype.getKmhr_fare();
		Double totalFare = basefare + (farePerKm * distanceInKm);

		booking.setCab_id(cab.getCab_id());
		booking.setSource(source.getLoc_name());
		booking.setDestination(destination.getLoc_name());
		booking.setFare(totalFare);
		booking.setDistance(distanceInKm);
		booking.setDate(new Date());
		booking.setCabtype_id(cabtypeId);

		return bookcabRepository.save(booking);

	}

}
