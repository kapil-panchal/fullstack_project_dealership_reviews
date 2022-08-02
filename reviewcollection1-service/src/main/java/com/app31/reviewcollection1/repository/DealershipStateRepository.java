package com.app31.reviewcollection1.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app31.reviewcollection1.model.DealershipState;

@Repository
public interface DealershipStateRepository extends JpaRepository<DealershipState, UUID>{

	
	@Query(value = "SELECT EXISTS(SELECT state_name FROM app31sch.dealerstate WHERE state_name = ?1)",
			nativeQuery = true)
	Boolean getStateByNameExists(String stateName);
	
	@Query(value = "SELECT * FROM app31sch.dealerstate WHERE state_name = ?1",
			nativeQuery = true)
	DealershipState getDealershipStateByStateName(String stateName);
}