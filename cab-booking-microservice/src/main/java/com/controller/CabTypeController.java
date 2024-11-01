package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CabType;
import com.entity.Location;
import com.service.CabTypeService;

@RestController
@RequestMapping("cabtype")
public class CabTypeController {
	
	@Autowired
	CabTypeService cabtypeService;
	
	//http://localhost:9191/cabtype/getallcabtype
	@GetMapping(value = "getallcabtype",consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<CabType> getallCabType(){
		return cabtypeService.getallcabType();
		
	}
	//http://localhost:9191/cabtype/add_cabtype
		@PostMapping(value = "add_cabtype",consumes = MediaType.APPLICATION_JSON_VALUE)
		public String addCabType(@RequestBody CabType cabtype) {
			cabtypeService.addCabType(cabtype);
			return "Cab Type added successfully";
		}

}
