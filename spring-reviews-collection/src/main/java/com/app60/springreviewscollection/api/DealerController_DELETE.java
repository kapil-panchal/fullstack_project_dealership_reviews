package com.app60.springreviewscollection.api;

import com.app60.springreviewscollection.model.Dealer;
import com.app60.springreviewscollection.model.Response;
import com.app60.springreviewscollection.service.DealerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
@RequestMapping(path = "/api")
@Slf4j
public class DealerController_DELETE {

    @Autowired
    private DealerService dealerService;

    @DeleteMapping(path = "/delete/{dealerName}")
    @RolesAllowed("admin")
    public ResponseEntity<Response> deleteDealer(@PathVariable("dealerName")
                                                 String dealerName){
        log.info("Inside deleteDealer() method of DealerController_DELETE");
        Dealer dealerFromDatabase = dealerService.getDealerByName(dealerName).get();
        String deleteStatus = dealerService.deleteDealer(dealerFromDatabase.getId());
        return ResponseEntity.ok(
                Response.builder()
                        .message(deleteStatus)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .timeStamp(ZonedDateTime.now(ZoneId.of("Z")))
                        .build()
        );
    }
}