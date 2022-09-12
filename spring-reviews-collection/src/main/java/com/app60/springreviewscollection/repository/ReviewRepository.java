package com.app60.springreviewscollection.repository;

import com.app60.springreviewscollection.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {
    @Query(value = "SELECT * FROM app60sch.review WHERE review = ?1",
            nativeQuery = true)
    Optional<Review> getByReview(String review);

}