package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Cab;
import com.entity.CabType;
import com.repository.CabTypeRepository;

@Service
public class CabTypeService {
	
	@Autowired
	CabTypeRepository cabtypeRepository;
	
	public List<CabType> getallcabType(){
		return cabtypeRepository.findAll();
	}
	
	public String addCabType(CabType type) {
		
		  cabtypeRepository.save(type); 
		  return "Cab Type added Successfully";
		 
		
		/*
		 * if(cabtypeRepository.existsByName(type.getCabtype_name())) return
		 * "Your cab_type is already added! Enter another type"; else {
		 * cabtypeRepository.save(type); return "Cab Type added Successfully"; }
		 */
		 
	}
	
	public CabType getCabTypeById(Long cabtype_id) {
		CabType cabtype=cabtypeRepository.findById(cabtype_id).orElseThrow(() -> new RuntimeException("Cab not found"));
        return cabtype;
	}

}
