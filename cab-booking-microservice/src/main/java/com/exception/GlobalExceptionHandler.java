package com.exception;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.entity.CabType;
import com.entity.Location;
import com.service.CabTypeService;
import com.service.LocationService;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	  @Autowired LocationService locationService;
	  
	  @Autowired CabTypeService cabtypeService;
	 
    @ExceptionHandler(CabNotAvailableException.class)
    public String handleCabNotAvailableException(CabNotAvailableException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
		
		  List<Location> categories = locationService.getallLocation(); 
		  List<CabType> cabtypes = cabtypeService.getallcabType(); 
		  model.addAttribute("categories",categories); 
		  model.addAttribute("cabtypes", cabtypes);
		  return "book"; // Return to the booking page
    }
    
    @ExceptionHandler(DistanceNotAvailableException.class)
    public String handleDistanceNotAvailableException(DistanceNotAvailableException ex, Model model) {
        	model.addAttribute("errorMessage", ex.getMessage());
		
		  List<Location> categories = locationService.getallLocation(); 
		  List<CabType> cabtypes = cabtypeService.getallcabType(); 
		  model.addAttribute("categories",categories); 
		  model.addAttribute("cabtypes", cabtypes);
		  return "fare"; // Return to the booking page
    }
    
   
}