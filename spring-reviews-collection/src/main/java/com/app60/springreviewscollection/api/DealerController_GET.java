package com.app60.springreviewscollection.api;

import com.app60.springreviewscollection.model.Response;
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
public class DealerController_GET {

    @Autowired
    private DealerService dealerService;

    @GetMapping(path = "/get-all")
    @RolesAllowed("admin")
    public ResponseEntity<Response> getAllDealersWithLocationAndReviews(){
        log.info("Inside getDealersWithLocationAndReviews() method of DealerController_GET");
        return ResponseEntity.ok(Response.builder()
                        .status(HttpStatus.FOUND)
                        .statusCode(HttpStatus.FOUND.value())
                        .message("Dealers list with Location and Reviews found!")
                        .data(Map.of("dealers", dealerService.getDealersWithLocationAndReviewsListOf(10)))
                        .timeStamp(ZonedDateTime.now(ZoneId.of("Z")))
                        .build());
    }

    @GetMapping(path = "/get-dealer-by-name/{dealerName}")
    @RolesAllowed("user")
    public ResponseEntity<Response> getDealersByDealerName(
            @PathVariable(name = "dealerName") String dealerName){
        log.info("Inside getDealersByDealerName() method of DealerController_GET");
        return ResponseEntity.ok(
                Response.builder()
                        .status(HttpStatus.FOUND)
                        .statusCode(HttpStatus.FOUND.value())
                        .message("Dealer found!")
                        .data(Map.of("dealer", dealerService.getDealerByName(dealerName)))
                        .timeStamp(ZonedDateTime.now(ZoneId.of("Z")))
                        .build()
        );
    }
}