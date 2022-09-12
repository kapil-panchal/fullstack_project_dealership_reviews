package com.app60.springreviewscollection.repository;

import com.app60.springreviewscollection.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LocationRepository extends JpaRepository<Location, UUID> {
    @Query(value = "SELECT * FROM app60sch.location WHERE state = ?1",
            nativeQuery = true)
    Optional<Location> getByState(String state);
}