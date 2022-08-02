package com.app31.reviewcollection1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app31.reviewcollection1.model.Dealership;
import com.app31.reviewcollection1.service.DealerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/get-data")
@Slf4j
public class DealershipController {
	
	@Autowired
	private DealerService dealerService;
	
	@GetMapping(value = "/")
	public ResponseEntity<List<Dealership>> getDealerDataFromDatabase(){
		List<Dealership> dealershipList = dealerService.getDealerDataFromDatabase();
		log.info("Inside getDealerDataFromDatabase method of DealershipController");
		log.info(dealershipList.toString());
		return new ResponseEntity<>(dealershipList,HttpStatus.OK);
	}
	
	@PostMapping(value = "/savedealerhip")
	public ResponseEntity<Dealership> saveDealershipEntity(@RequestBody Dealership dealership){
		log.info("Inside saveDealershipEntity method of DealershipController");
		return new ResponseEntity<>(
				dealerService.saveDealershipWithAddressAndReview(dealership), 
				HttpStatus.OK);
	}
}