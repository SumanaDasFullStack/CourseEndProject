package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CabType;

@Service
public class FareService {
	
	@Autowired
	CabTypeService cabtypeService;
	
	@Autowired 
	DistanceService distanceService;
	
	
	
	public double calculateFare(String sourceId, String destId,Long cabtypeId) {
		double totalfare=0.0;
		Long source_id = Long.parseLong(sourceId);
		Long dest = Long.parseLong(destId);
	
		CabType cabtype =cabtypeService.getCabTypeById(cabtypeId);
       
     // Calculate distance
        Double distanceInKm = distanceService.getDistanceFare(source_id, dest);
               
        	 // Calculate total fare (basefare+ distance * fare per km of the cab type)
            Double basefare= cabtype.getBase_fare();
            Double farePerKm = cabtype.getKmhr_fare();
            totalfare = basefare+(farePerKm * distanceInKm) ;
		
		return totalfare;
		
	}

}
