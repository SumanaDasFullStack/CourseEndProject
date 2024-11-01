package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CabType;
import com.entity.Location;
import com.service.BookCabService;
import com.service.CabService;
import com.service.CabTypeService;
import com.service.DistanceService;
import com.service.FareService;
import com.service.LocationService;

@Controller

public class FareController {
	
	@Autowired
	LocationService locService;
	
	@Autowired
	CabTypeService cabtypeService;
	
	@Autowired
	DistanceService distanceService;
	@Autowired
	FareService fareService;
	
	 @RequestMapping(value = "farecalculate",method=RequestMethod.GET) 
	  public String openFareCalculation(Model mm) { 
			
			  List<Location> categories = locService.getallLocation(); 
			  List<CabType> cabtypes = cabtypeService.getallcabType();
			  
		 // ResponseEntity<List<Location>>  categories = (ResponseEntity<List<Location>>) restTemplate.getForObject("http://localhost:9191/location/getlocation", List.class);
		//  ResponseEntity<List<CabType>> cabtypes = (ResponseEntity<List<CabType>>) restTemplate.getForObject("http://localhost:9191/cabtype/getallcabtype", List.class);
	        mm.addAttribute("categories", categories);
	        mm.addAttribute("cabtypes", cabtypes);
	        
		  return "fare"; 
		  }			 
	 		
	  
	  @RequestMapping(value = "farecalculate",method=RequestMethod.POST) 
	  public String openFareCalculation(Model mm,@RequestParam String source,
	            @RequestParam String destination,
	            @RequestParam Long cabtype_id) { 
			
			  List<Location> categories = locService.getallLocation(); 
			  List<CabType> cabtypes = cabtypeService.getallcabType();
			  double fare = fareService.calculateFare(source,destination, cabtype_id);
		 // ResponseEntity<List<Location>>  categories = (ResponseEntity<List<Location>>) restTemplate.getForObject("http://localhost:9191/location/getlocation", List.class);
		//  ResponseEntity<List<CabType>> cabtypes = (ResponseEntity<List<CabType>>) restTemplate.getForObject("http://localhost:9191/cabtype/getallcabtype", List.class);
	        mm.addAttribute("categories", categories);
	        mm.addAttribute("cabtypes", cabtypes);
	        mm.addAttribute("result", fare);
	       
		  return "fare"; 
		  }			 
	 		
}