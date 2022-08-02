package com.app31.reviewcollection1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app31.reviewcollection1.model.Dealership;
import com.app31.reviewcollection1.model.DealershipState;
import com.app31.reviewcollection1.model.Reviews;
import com.app31.reviewcollection1.repository.DealershipRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DealerService {

	@Autowired
	private DealershipRepository repository;

	public List<Dealership> getDealerDataFromDatabase() {
		log.info("Inside getDealerDataFromDatabase method of DealerService");
		return repository.findAll();
	}

	public Dealership saveDealershipWithAddressAndReview(Dealership dealership) {

		boolean dealerNameExists = repository.getDealerNameIfExistsInDatabase(dealership.getDealerName());
		String dealerStateString = dealership.getDealerState().get(0).getStateName();
		boolean dealerStateExists = repository.getDealerStateIfExistsInDatabase(dealerStateString);

//		//Case1: When dealer false, address = false
//		if(dealerNameExists == false && dealerStateExists == false) {			
//			Reviews reviewObject = Reviews.builder()
//					.review(dealership.getDealerState().get(0).getReviewsList().get(0).getReview())
//					.build();
//			//state = false
//			DealershipState dealershipStateObject = DealershipState.builder()
//					.stateName(dealership.getDealerState().get(0).getStateName())
//					.build();
//			//state = false
//			Dealership dealershipObject = Dealership.builder()
//					.dealerName(dealership.getDealerName())
//					.build();
//
//			dealershipStateObject.addReview(reviewObject);
//			dealershipObject.addDealerAddress(dealershipStateObject);
//			log.info("Inside saveDealershipWithAddressAndReview method of DealerService");
//			log.info("Inside Case1: When dealer = false, address = false");
//			return repository.save(dealershipObject);
//		}
	
		//Case2: When dealer false, address = true
		if(dealerNameExists == false && dealerStateExists == true) {
			//get address object from db and then the procedure like above
			Reviews reviewObject = Reviews.builder()
					.review(dealership.getDealerState().get(0).getReviewsList().get(0).getReview())
					.build();
			System.err.println(reviewObject);
			
			//state = true
			DealershipState dealershipStateObject = 
					repository.getDealershipState(
							dealership.getDealerState().get(0).getStateName());
			
			//state = false
			Dealership dealershipObject = Dealership.builder()
					.dealerName(dealership.getDealerName())
					.build();
			
			dealershipStateObject.addReview(reviewObject);
			dealershipObject.addDealerAddress(dealershipStateObject);
			log.info("Inside saveDealershipWithAddressAndReview method of DealerService");
			log.info("Inside Case2: When dealer = false, address = true");
			return repository.save(dealershipObject);
		}
//		//Case3: When dealer true, address = false
//		if(dealerNameExists == true && dealerStateExists == false) {
//			//get dealer object from db and then the procedure like above
//			Reviews reviewObject = Reviews.builder()
//					.review(dealership.getDealerState().get(0).getReviewsList().get(0).getReview())
//					.build();
//			//state = false
//			DealershipState dealershipStateObject = DealershipState.builder()
//					.stateName(dealership.getDealerState().get(0).getStateName())
//					.build();
//			
//			//state = true
//			Dealership dealershipObject = 
//					repository.getDealershipObject(dealership.getDealerName());
//			
//			dealershipStateObject.addReview(reviewObject);
//			dealershipObject.addDealerAddress(dealershipStateObject);
//			log.info("Inside saveDealershipWithAddressAndReview method of DealerService");
//			log.info("Inside Case3: When dealer = true, address = false");
//			return repository.save(dealershipObject);
//		}
//		//Case4: When dealer true, address = true
//		if(dealerNameExists == true && dealerStateExists == true) {
//			//get both dealer and address object from db and then the procedure like above
//			Reviews reviewObject = Reviews.builder()
//					.review(dealership.getDealerState().get(0).getReviewsList().get(0).getReview())
//					.build();
//			
//			//state = true
//			DealershipState dealershipStateObject = 
//					repository.getDealershipStateObject(
//							dealership.getDealerState().get(0).getStateName());
//			System.err.println(dealershipStateObject);
//			//state = true
//			Dealership dealershipObject = 
//					repository.getDealershipObject(dealership.getDealerName());
//			
//			dealershipStateObject.addReview(reviewObject);
//			dealershipObject.addDealerAddress(dealershipStateObject);
//			log.info("Inside saveDealershipWithAddressAndReview method of DealerService");
//			log.info("Inside Case4: When dealer = true, address = true");
//			return repository.save(dealershipObject);
//		}
//		return dealership;
		else {
			return null;
		}
	}
}