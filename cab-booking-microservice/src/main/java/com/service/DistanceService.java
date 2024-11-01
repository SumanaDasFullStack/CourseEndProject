package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Distance;
import com.entity.Location;
import com.exception.CabNotAvailableException;
import com.exception.DistanceNotAvailableException;
import com.repository.DistanceRepository;

@Service
public class DistanceService {
	
	@Autowired
	DistanceRepository distanceRepository;
	
	public List<Distance> getDistancesFromLocation(Location location) {
        return distanceRepository.findByFromLocation(location);
    }

    public Distance saveDistance(Distance distance) {
        return distanceRepository.save(distance);
    }
    
	
	  public List<Distance> getAllDistances() {
	  
	  return distanceRepository.findAll();
	  
	  }
	  
	  public double getDistance(Long fromId, Long toId) {
			/*
			 * Double distance =
			 * distanceRepository.findByFromLocationIdAndToLocationId(fromId,toId); Double
			 * rev_distance = distanceRepository.findByToLocationIdAndFromLocationId(toId,
			 * fromId);
			 */
	       
	       // Distance rev_distance = distanceRepository.findByToLocationIdAndFromLocationId(toId, fromId);
		  
		  Double distance= distanceRepository.findDistance(fromId, toId);
	        
	        if(fromId != toId) {
	        	if (distance != null) {
		            return distance;
		        } 
	        	else {
		        	throw new CabNotAvailableException("Unable to Calculate Distance");
		        	
		        }
	        }
	        else {
	        	throw new CabNotAvailableException("Source and Destination should be different");
	        }
	        
	  }

		public double getDistanceFare(Long fromId, Long toId) {
			
			  Double distance = distanceRepository.findDistance(fromId,toId);
			  
			  if(fromId != toId) {
				  if (distance != null) 
			  { 
				  return distance; 
			  }
			  else  { 
				  throw new DistanceNotAvailableException("Unable to Calculate Distance");
			   } 
			  } 
			  else { 
				  throw new DistanceNotAvailableException("Source and Destination should be different");
			  }
			 
			
		}
	 
}