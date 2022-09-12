package com.app60.springreviewscollection.service;

import com.app60.springreviewscollection.exceptions.UserParameterRuntimeException;
import com.app60.springreviewscollection.model.Dealer;
import com.app60.springreviewscollection.model.Location;
import com.app60.springreviewscollection.model.Review;
import com.app60.springreviewscollection.repository.DealerRepository;
import com.app60.springreviewscollection.repository.LocationRepository;
import com.app60.springreviewscollection.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class DealerServiceImpl implements DealerService{

    @Autowired
    private DealerRepository dealerRepo;

    @Autowired
    private LocationRepository locationRepo;

    @Autowired
    private ReviewRepository reviewRepo;

    @Override
    @Transactional
    public void addReviewToLocation(String review, String state) {
        log.info("Inside addReviewToLocation() method of DealerServiceImpl");
        boolean reviewExists = reviewRepo.getByReview(review).isPresent();
        boolean stateExists = locationRepo.getByState(state).isPresent();

        Review reviewFromDb = reviewRepo.getByReview(review).get();
        Location stateFromDb = locationRepo.getByState(state).get();

        if((reviewExists == true) && (stateExists == true)){
            stateFromDb.getReviews().add(reviewFromDb);
        } else {
            throw new UserParameterRuntimeException("Either review/location does not exist");
        }
    }

    @Override
    @Transactional
    public void addLocationToDealer(String state, String name) {
        log.info("Inside addLocationToDealer() method of DealerServiceImpl");
        boolean stateExists = locationRepo.getByState(state).isPresent();
        boolean dealerExists = dealerRepo.getByName(name).isPresent();

        Location stateFromDb = locationRepo.getByState(state).get();
        Dealer dealerFromDb = dealerRepo.getByName(name).get();

        if((stateExists == true) && (dealerExists == true)){
            dealerFromDb.getLocations().add(stateFromDb);
        } else {
            throw new UserParameterRuntimeException("Either location/dealer does not exists");
        }
    }

    @Override
    public Collection<Dealer> getDealersWithLocationAndReviewsListOf(int pageLimit) {
        log.info("Inside getDealersWithLocationAndReviewsListOf() method of DealerServiceImpl");
        return dealerRepo.findAll(PageRequest.of(0, pageLimit)).toList();
    }

    @Override
    public Optional<Dealer> getDealerByName(String dealerName) {
        log.info("Inside getDealerByName() method of DealerServiceImpl");
        return dealerRepo.getByName(dealerName);
    }

    @Override
    public String saveDealer(Dealer dealer) {
        log.info("Inside saveDealer() method of DealerServiceImpl");
        dealer.setName(dealer.getName().toLowerCase());
        try {
            dealerRepo.saveAndFlush(dealer);
        } catch (Exception e){
            throw new UserParameterRuntimeException(e.getMessage());
        }
        return "Create Dealer Successful";
    }

    @Override
    public String saveLocation(Location state) {
        log.info("Inside saveLocation() method of DealerServiceImpl");
        state.setState(state.getState().toLowerCase());
        try{
            locationRepo.saveAndFlush(state);
        } catch (Exception e){
            throw new UserParameterRuntimeException(e.getMessage());
        }
        return "Location Created Successfully!";
    }

    @Override
    public Optional<Location> getLocationByStateName(String state) {
        log.info("Inside getLocationByStateName() method of DealerServiceImpl");
        return locationRepo.getByState(state);
    }

    @Override
    public String saveReview(Review review) {
        log.info("Inside saveReview() method of DealerServiceImpl");
        review.setReview(review.getReview().toLowerCase());
        try {
            reviewRepo.saveAndFlush(review);
        } catch (Exception e) {
            throw new UserParameterRuntimeException(e.getMessage());
        }
        return "Review Created Successfully!";
    }

    @Override
    public Optional<Review> getReview(String review) {
        log.info("Inside getReview() method of DealerServiceImpl");
        return reviewRepo.getByReview(review);
    }
}