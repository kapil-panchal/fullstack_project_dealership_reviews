package com.app60.springreviewscollection.api;

import com.app60.springreviewscollection.exception.UserParametersException;
import com.app60.springreviewscollection.model.Dealer;
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
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(path = "/api")
@Slf4j
public class DealerController_GET {

    @Autowired
    private DealerService dealerService;

    @GetMapping(path = "/get-all")
    @RolesAllowed("admin")
    public ResponseEntity<Response> getAllDealersWithLocationAndReviews() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
//        throw new UserParametersException("Exception Occured");
        log.info("Inside getDealersWithLocationAndReviews() method of DealerController_GET");
        String statusMessage = "Dealers list with Location and Reviews found!";

        Collection<Dealer> dealerList = dealerService.getDealersWithLocationAndReviewsListOf(10);

        if(dealerList == null) {
            statusMessage = "Dealer list is Empty";
        }
        return ResponseEntity.ok(Response.builder()
                        .status(HttpStatus.FOUND)
                        .statusCode(HttpStatus.FOUND.value())
                        .message(statusMessage)
                        .data(Map.of("dealers", dealerList ))
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