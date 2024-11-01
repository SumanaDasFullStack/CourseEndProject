package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer>{
	boolean existsByNumber(String number);

	@Query("SELECT c FROM Cab c WHERE c.cab_id = :cab_id")
    Optional<Cab> findById(@Param("cab_id") Long cab_id);
	//Optional<Cab> findByCabId(Long cab_id);

}
