package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.CabType;

@Repository
public interface CabTypeRepository extends JpaRepository<CabType, Integer>{

	@Query("SELECT c FROM CabType c WHERE c.cabtype_id = :cabtype_id")
	Optional<CabType> findById(@Param("cabtype_id") Long cabtype_id);
	//boolean existsByName(String cabtype_name);

}