package com.app31.reviewcollection1.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app31.reviewcollection1.model.Dealership;
import com.app31.reviewcollection1.model.DealershipState;
import com.app31.reviewcollection1.model.Reviews;

@SpringBootTest
class DealershipRepositoryTest {

	@Autowired
	private DealershipRepository repository;
	
	@Autowired
	private DealershipStateRepository stateRepository;
	
	Dealership dealer1 = 
			Dealership.builder()
			.dealerName("DealerTest1")
			.build();
	
	DealershipState stateAddress1 = 
			DealershipState.builder()
			.stateName("StateTest1")
			.build();
	
	Reviews review1 = 
			Reviews.builder()
			.review("TEST--Dealership-DealerState-Review-1--Lorem ipsum dolor sit amet, "
					+ "consectetur adipiscing elit, "
					+ "sed do eiusmod tempor incididunt "
					+ "ut labore et dolore magna aliqua. "
					+ "Ut enim ad minim veniam, quis "
					+ "nostrud exercitation ullamco laboris "
					+ "nisi ut aliquip ex ea commodo consequat.")
			.build();
	
	Reviews review2 = 
			Reviews.builder()
			.review("TEST--Dealership-DealerState-Review-2--Lorem ipsum dolor sit amet, "
					+ "consectetur adipiscing elit, "
					+ "sed do eiusmod tempor incididunt "
					+ "ut labore et dolore magna aliqua. "
					+ "Ut enim ad minim veniam, quis "
					+ "nostrud exercitation ullamco laboris "
					+ "nisi ut aliquip ex ea commodo consequat.")
			.build();
	
	String stateNameString = "DealerTest2";
	
//	@Test
//	void testDealershipRepositorySave() {
//		stateAddress1.addReview(review1);
//		dealer1.addDealerAddress(stateAddress1);
//		repository.save(dealer1);
//	}
	
//	@Test
//	void getDealershipObjectFromDatabaseTest() {
//		List<Dealership> dealership1 = 
//				repository.findAll();
//		
//		System.err.println(dealership1);
//	}
	
//	@Test
//	void getDealerCheckIfExistsInDatabaseTest() {
//		boolean dealerExists = repository.getDealerNameIfExistsInDatabase(stateNameString);
//		System.err.println(dealerExists);
//		
//		stateAddress1.addReview(review1);
//		dealer1.addDealerAddress(stateAddress1);
//		
////		List<DealershipState> dealershipState = dealer1.getDealerState();
//		
//		String stateName = dealer1.getDealerState().get(0).getStateName();
//		
//		System.err.println(stateName);
//		
//		
//		
////		List<Dealership> dealershipList1 = repository.findAll();
//////		System.err.println(dealership1);
////		
////		Dealership dealershipIndividual = dealershipList1.get(0);
//////		System.err.println(dealershipIndividual);
////		
////		DealershipState dealershipState = dealershipIndividual.getDealerState().get(0);
////		System.err.println(dealershipState.getStateName());
////		
////		
////		//OR
////		String dealershipState1 = dealershipList1.get(0).getDealerState().get(0).getStateName();
////		System.err.println(dealershipState1);
//		
//		
//	}
	
	@Test
	
	void getDealershipStateObjectTest() {
//		String stateNameString = "State5";
//		
//		DealershipState dealershipStateObject = 
//				stateRepository.getDealershipStateByStateName(stateNameString);
//		
//		System.err.println(dealershipStateObject);
		DealershipState stateFound = repository.getDealershipState(stateNameString);
		System.err.println(stateFound);
		
//		Dealership dealershipFound = repository.getDealershipObject("Dealer5");
//		System.err.println(dealershipFound);
	}
}