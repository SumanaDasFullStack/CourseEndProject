package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Cab;
import com.entity.Distance;
import com.entity.Location;

@Repository
public interface DistanceRepository extends JpaRepository<Distance, Integer>{

	List<Distance> findByFromLocation(Location location);
	
	
	@Query("SELECT d.distance FROM Distance d WHERE (d.fromLocation.id = :fromLocationId AND d.toLocation.id = :toLocationId) OR (d.fromLocation.id = :toLocationId AND d.toLocation.id = :fromLocationId)" ) 
	Double findDistance(@Param("fromLocationId") Long fromLocationId, @Param("toLocationId") Long toLocationId);
	
	
	
}
