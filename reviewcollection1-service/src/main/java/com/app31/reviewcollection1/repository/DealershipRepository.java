package com.app31.reviewcollection1.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app31.reviewcollection1.model.Dealership;

@Repository
public interface DealershipRepository extends JpaRepository<Dealership, UUID>{
	
	@Query(value = "SELECT EXISTS(SELECT dealer_name FROM app31sch.dealership WHERE dealer_name = ?1)",
			nativeQuery = true)
	Boolean getDealerNameIfExistsInDatabase(String dealerName);
	
	@Query(value = "SELECT * FROM app31sch.dealership WHERE dealer_name = ?1",
			nativeQuery = true)
	Dealership getDealershipObject(String dealerName);
}