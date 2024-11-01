package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Cab;
import com.service.CabService;

@RestController
@RequestMapping("cab")
public class CabController {
	@Autowired
	CabService cabService;
	
	//http://localhost:9191/cab/add
	@PostMapping(value = "add",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String addCab(@RequestBody Cab cab) {
		return cabService.addCab(cab);
	}
	//http://localhost:9191/cab/findallcab
	@GetMapping(value = "findallcab",consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Cab> getAllCab() {
		
		return cabService.getAllCab();
	}
	
	//http://localhost:9191/cab/getallcab_types
		@GetMapping(value = "getallcab_types",consumes = MediaType.APPLICATION_JSON_VALUE)
		public List<Cab> getAllCabTypes() {
			
			return cabService.getAllCab();
		}

}