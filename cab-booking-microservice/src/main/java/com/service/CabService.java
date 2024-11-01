package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Cab;
import com.repository.CabRepository;

@Service
public class CabService {
	@Autowired
	CabRepository cabRepository;
	
	@Autowired 
	CabTypeService cabtypeService;
	
	public List<Cab> getAllCab() {
		return cabRepository.findAll();		
	}
	//need to change
	public List<Cab> getAllCabType() {
		return cabRepository.findAll();		
	}
	
	public String addCab(Cab cab) {
		if(cabRepository.existsByNumber(cab.getNumber()))
			return "Cab number must be unique";
		else {
		cabRepository.save(cab);
		return "Cab added successfully";
		}
	}
	
	public Cab getCabById(Long cab_id) {
		Cab cab=cabRepository.findById(cab_id).orElseThrow(() -> new RuntimeException("Cab not found"));
        return cab;
    }
	
	

}