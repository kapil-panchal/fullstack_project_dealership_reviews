package com.app60.springreviewscollection.config;

import com.app60.springreviewscollection.model.Dealer;
import com.app60.springreviewscollection.model.Location;
import com.app60.springreviewscollection.model.Review;
import com.app60.springreviewscollection.repository.DealerRepository;
import com.app60.springreviewscollection.repository.LocationRepository;
import com.app60.springreviewscollection.repository.ReviewRepository;
import com.app60.springreviewscollection.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class AppConfig {

    @Autowired
    private DealerRepository dealerRepo;

    @Autowired
    private LocationRepository locationRepo;

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private DealerService dealerService;

    @Bean
    CommandLineRunner runner(){
        return args -> {
            Dealer dealer1 = Dealer.builder()
                    .name("Dealer1".toLowerCase())
                    .build();

            dealerRepo.saveAll(
                    Stream.of(dealer1).collect(Collectors.toList()));

            Location location1 = Location.builder()
                    .state("State1".toLowerCase())
                    .build();

            locationRepo.saveAll(
                    Stream.of(location1).collect(Collectors.toList())
            );

            Review review1 = Review.builder()
                    .review("Review1".toLowerCase())
                    .build();

            reviewRepo.saveAll(
                    Stream.of(review1).collect(Collectors.toList())
            );

            dealerService.addReviewToLocation(review1.getReview(), location1.getState());
            dealerService.addLocationToDealer(location1.getState(), dealer1.getName());
        };
    }
}