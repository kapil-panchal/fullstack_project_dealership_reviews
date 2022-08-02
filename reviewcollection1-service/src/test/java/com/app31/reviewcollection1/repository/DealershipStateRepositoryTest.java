package com.app31.reviewcollection1.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app31.reviewcollection1.model.DealershipState;
import com.app31.reviewcollection1.model.Reviews;

@SpringBootTest
class DealershipStateRepositoryTest {

	@Autowired
	private DealershipStateRepository repository;
	
	DealershipState state1  =
			DealershipState.builder()
			.stateName("State4")
			.build();
	
	Reviews review1 = 
			Reviews.builder()
			.review("1--Lorem ipsum dolor sit amet, "
					+ "consectetur adipiscing elit, "
					+ "sed do eiusmod tempor incididunt "
					+ "ut labore et dolore magna aliqua. "
					+ "Ut enim ad minim veniam, quis "
					+ "nostrud exercitation ullamco laboris "
					+ "nisi ut aliquip ex ea commodo consequat.")
			.build();
	
	Reviews review2 = 
			Reviews.builder()
			.review("3--Lorem ipsum dolor sit amet, "
					+ "consectetur adipiscing elit, "
					+ "sed do eiusmod tempor incididunt "
					+ "ut labore et dolore magna aliqua. "
					+ "Ut enim ad minim veniam, quis "
					+ "nostrud exercitation ullamco laboris "
					+ "nisi ut aliquip ex ea commodo consequat.")
			.build();
	
	String stateNameString = "State1";
	
//	@Test
//	void getStateFromDatabasetest1() {
//
//		boolean stateNameBoolean = repository.getStateByNameExists(stateNameString);
//
//		System.err.println(stateNameBoolean);
//		if(stateNameBoolean == false) {
//			DealershipState stateCreateNew  =
//					DealershipState.builder()
//					.stateName(stateNameString)
//					.build();
//			stateCreateNew.addReview(review2);
//			repository.save(stateCreateNew);			
//		}
//		else {
//			DealershipState stateFound = repository.getDealershipStateByStateName(stateNameString);
//			System.err.println(stateFound);
//			stateFound.addReview(review1);
//			repository.save(stateFound);
//		}

	@Test
	void getStateFromDatabasetest2() {

		DealershipState stateFound = repository.getDealershipStateByStateName(stateNameString);
		System.err.println(stateFound);
	}
}