package com.app60.springreviewscollection.service;

import com.app60.springreviewscollection.model.Dealer;
import com.app60.springreviewscollection.model.Location;
import com.app60.springreviewscollection.model.Review;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;


public interface DealerService {

    void addReviewToLocation(String review, String state);

    void addLocationToDealer(String state, String name);

    Collection<Dealer> getDealersWithLocationAndReviewsListOf(int i);

    Optional<Dealer> getDealerByName(String dealerName);

    String saveDealer(Dealer dealer);

    String saveLocation(Location state);

    Optional<Location> getLocationByStateName(String state);

    String saveReview(Review review);

    Optional<Review> getReview(String review);

    String deleteDealer(UUID id);
}