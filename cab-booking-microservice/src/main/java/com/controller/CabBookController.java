package com.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.dto.BookingRequest;
import com.entity.BookCab;
import com.entity.Cab;
import com.entity.CabType;
import com.entity.Location;
import com.service.BookCabService;
import com.service.CabService;
import com.service.CabTypeService;
import com.service.DistanceService;
import com.service.LocationService;

@Controller
public class CabBookController {

	
	@Autowired
	BookCabService bookcabService;
	@Autowired
	LocationService locService;
	@Autowired
	CabService cabService;
	@Autowired
	CabTypeService cabtypeService;
	
	@Autowired
	DistanceService distanceService;
	

	
	  @RequestMapping(value = "",method=RequestMethod.GET) 
	  public String openPage() { 
		  return "index"; 
		  }

			
			  @RequestMapping(value = "book",method=RequestMethod.GET) 
			  public String openBookCab(Model mm) { 
				  List<Location> categories = locService.getallLocation(); 
				  List<CabType> cabtypes = cabtypeService.getallcabType();
				  
				 // System.err.println(bookcabService.fetchLocationList());
				 // ResponseEntity<List<Location>>  categories = (ResponseEntity<List<Location>>) restTemplate.getForObject("http://localhost:9191/location/getlocation", List.class);
				 // ResponseEntity<List<CabType>> cabtypes = (ResponseEntity<List<CabType>>) restTemplate.getForObject("http://localhost:9191/cabtype/getallcabtype", List.class);
			        mm.addAttribute("categories", categories);
			        mm.addAttribute("cabtypes", cabtypes);
			       
				 
				  return "book"; 
				  }
			 
					
					 							
							  @RequestMapping(value = "booking",method = RequestMethod.POST) 
							  public String submitcabBooking(Model  mm, BookCab book )
							  { 
								  
								  List<Location> categories = locService.getallLocation();
								  List<CabType> cabtypes = cabtypeService.getallcabType();	
								  
								  
									  BookCab result = bookcabService.createBookings(book.getCabtype_id(), Long.parseLong(book.getSource()),Long.parseLong(book.getDestination())); 
								 // BookCab result = bookcabService.createBookings(book); 
									  mm.addAttribute("categories", categories);
									  mm.addAttribute("cabtypes", cabtypes);
									  mm.addAttribute("bookcab",book);
									  mm.addAttribute("result", "Booking Done Successfully");
									 
									  return "book";
							       
							  
							  }
							 
									 
						
}
