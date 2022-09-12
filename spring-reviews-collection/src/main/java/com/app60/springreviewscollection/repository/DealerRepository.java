package com.app60.springreviewscollection.repository;

import com.app60.springreviewscollection.model.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, UUID> {
    @Query(value = "SELECT * FROM app60sch.dealer WHERE name = ?1",
            nativeQuery = true)
    Optional<Dealer> getByName(String name);
}