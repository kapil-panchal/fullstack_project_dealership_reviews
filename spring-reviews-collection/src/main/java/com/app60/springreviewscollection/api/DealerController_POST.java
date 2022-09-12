package com.app60.springreviewscollection.api;

import com.app60.springreviewscollection.model.Dealer;
import com.app60.springreviewscollection.model.Location;
import com.app60.springreviewscollection.model.Response;
import com.app60.springreviewscollection.model.Review;
import com.app60.springreviewscollection.service.DealerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
@Slf4j
public class DealerController_POST {

    @Autowired
    private DealerService dealerService;

    @PostMapping(path = "/register-dealer")
    @RolesAllowed("admin")
    public ResponseEntity<Response> addDealer(@RequestBody Dealer dealer){
        log.info("Inside addDealer() method of DealerController_POST");
        String saveStatus = dealerService.saveDealer(dealer);
        return ResponseEntity.ok(
                Response.builder()
                        .message(saveStatus)
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .timeStamp(ZonedDateTime.now(ZoneId.of("Z")))
                        .data(Map.of("dealer", dealerService.getDealerByName(dealer.getName())))
                        .build()
        );
    }

    @PostMapping(path = "/register-location")
    @RolesAllowed("admin")
    public ResponseEntity<Response> addLocation(@RequestBody Location state,
                                                @RequestParam String dealer){
        log.info("Inside addLocation() method of DealerController_POST");
        String saveStatus = dealerService.saveLocation(state);
        dealerService.addLocationToDealer(state.getState(), dealer);
        return ResponseEntity.ok(
                Response.builder()
                        .message(saveStatus)
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .timeStamp(ZonedDateTime.now(ZoneId.of("Z")))
                        .data(Map.of("dealer", dealerService.getLocationByStateName(state.getState())))
                        .build()
        );
    }

    @PostMapping(path = "/register-review")
    @RolesAllowed("user")
    public ResponseEntity<Response> addReview(@RequestBody Review review,
                                              @RequestParam String location){
        log.info("Inside addReview() method of DealerController_POST");
        String saveStatus = dealerService.saveReview(review);
        dealerService.addReviewToLocation(review.getReview(), location);
        return ResponseEntity.ok(
                Response.builder()
                        .message(saveStatus)
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .timeStamp(ZonedDateTime.now(ZoneId.of("Z")))
                        .data(Map.of("review", dealerService.getReview(review.getReview())))
                        .build()
        );
    }
}