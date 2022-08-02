package com.app31.reviewcollection1.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app31.reviewcollection1.model.Reviews;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, UUID>{

}