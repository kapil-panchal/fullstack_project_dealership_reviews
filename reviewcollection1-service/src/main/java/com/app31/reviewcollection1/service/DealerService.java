package com.app31.reviewcollection1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.app31.reviewcollection1.model.Dealership;
import com.app31.reviewcollection1.model.DealershipState;
import com.app31.reviewcollection1.model.Reviews;
import com.app31.reviewcollection1.repository.DealershipRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DealerService {

	@Autowired
	private DealershipRepository repository;
	private DealershipState dealershipStateObject;

	public List<Dealership> getDealerDataFromDatabase() {
		log.info("Inside getDealerDataFromDatabase method of DealerService");
		return repository.findAll();
	}

	
	public Dealership saveDealershipWithAddressAndReview(Dealership dealership) throws Exception {

		boolean dealerNameExists = repository.getDealerNameIfExistsInDatabase(dealership.getDealerName());
		String dealerStateString = dealership.getDealerState().get(0).getStateName();
		boolean dealerStateExists = repository.getDealerStateIfExistsInDatabase(dealerStateString);		
		
		//Case1: When dealer = false, address = false
		if(dealerNameExists == false && dealerStateExists == false) {
			Reviews reviewObject = Reviews.builder()
					.review(dealership.getDealerState().get(0).getReviewsList().get(0).getReview())
					.build();
			
			//state = false
			DealershipState dealershipStateObject = DealershipState.builder()
					.stateName(dealership.getDealerState().get(0).getStateName())
					.build();
			
			//dealer = false
			Dealership dealershipObject = Dealership.builder()
					.dealerName(dealership.getDealerName())
					.build();

			dealershipStateObject.addReview(reviewObject);
			dealershipObject.addDealerAddress(dealershipStateObject);
			log.info("Inside saveDealershipWithAddressAndReview method of DealerService");
			log.info("Inside Case1: When dealer = false, address = false");
			return repository.save(dealershipObject);
		}
		
		/////////////////////////////////////////////////
		//Case2: When dealer = false, address = true	
		if(dealerNameExists == false && dealerStateExists == true) {
			//get address object from db and then the procedure like above
			Reviews reviewObject = Reviews.builder()
					.review(dealership.getDealerState().get(0).getReviewsList().get(0).getReview())
					.build();
			
			//state = true
			//search in the dealershipState list for value and load the value to the variable
			List<Dealership> dealershipListDealerState = repository.findAll();
			System.err.println(dealershipStateObject);
			
			//CONSTRUCTOR
			//define a no args constructor, not defining it
			//makes the assigned value to be stored in a null object.
			dealershipStateObject = DealershipState.builder()
					.build();
			
			// SEARCH FOR VALUES IN DATABASE
			dealershipListDealerState.forEach(
					temp -> {
						if((temp.getDealerState().get(0).getStateName())
								.compareTo(dealership.getDealerState()
										.get(0).getStateName()) == 0) {
							dealershipStateObject = temp.getDealerState().get(0);
							System.err.println(dealershipStateObject);
						}
					});
			
			//dealer = false			
			Dealership dealershipObject = Dealership.builder()
					.dealerName(dealership.getDealerName())
					.build();
			
			dealershipStateObject.addReview(reviewObject);
			dealershipObject.addDealerAddress(dealershipStateObject);
			log.info("Inside saveDealershipWithAddressAndReview method of DealerService");
			log.info("Inside Case2: When dealer = false, address = true");
			System.err.println(dealershipObject);
			return repository.save(dealershipObject);
		}
		/////////////////////////////////////////////////
		
		//Case3: When dealer = true, address = false
		if(dealerNameExists == true && dealerStateExists == false) {
			//get dealer object from db and then the procedure like above
			Reviews reviewObject = Reviews.builder()
					.review(dealership.getDealerState().get(0).getReviewsList().get(0).getReview())
					.build();
			
			//state = false
			DealershipState dealershipStateObject = DealershipState.builder()
					.stateName(dealership.getDealerState().get(0).getStateName())
					.build();
			
			//dealer = true
			Dealership dealershipObject = 
					repository.getDealershipObject(dealership.getDealerName());
			
			dealershipStateObject.addReview(reviewObject);
			dealershipObject.addDealerAddress(dealershipStateObject);
			log.info("Inside saveDealershipWithAddressAndReview method of DealerService");
			log.info("Inside Case3: When dealer = true, address = false");
			return repository.save(dealershipObject);
		}		
		
		//Case4: When dealer = true, address = true
		if(dealerNameExists == true && dealerStateExists == true) {
			//get both dealer and address object from db and then the procedure like above
			Reviews reviewObject = Reviews.builder()
					.review(dealership.getDealerState().get(0).getReviewsList().get(0).getReview())
					.build();
			
			//state = true
			List<Dealership> dealershipListDealerState = repository.findAll();
			dealershipListDealerState.forEach(
					temp -> {
						if((temp.getDealerState().get(0).getStateName())
								.compareTo(dealership.getDealerState()
										.get(0).getStateName()) == 0) {
							dealershipStateObject = temp.getDealerState().get(0);
						}
					});
			
			//dealer = true
			Dealership dealershipObject = 
					repository.getDealershipObject(dealership.getDealerName());			
			dealershipStateObject.addReview(reviewObject);
			log.info("Inside saveDealershipWithAddressAndReview method of DealerService");
			log.info("Inside Case4: When dealer = true, address = true");
			return repository.save(dealershipObject);
		}
		else {
			throw new IllegalAccessException("Illegal Arguments passed");			
		}
	}
}