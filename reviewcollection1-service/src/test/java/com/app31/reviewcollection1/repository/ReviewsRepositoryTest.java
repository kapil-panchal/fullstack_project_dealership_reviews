package com.app31.reviewcollection1.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app31.reviewcollection1.model.Reviews;

@SpringBootTest
class ReviewsRepositoryTest {

	@Autowired
	private ReviewsRepository repository;
	
	Reviews review1 = 
			Reviews.builder()
			.review("Lorem ipsum dolor sit amet, "
					+ "consectetur adipiscing elit, "
					+ "sed do eiusmod tempor incididunt "
					+ "ut labore et dolore magna aliqua. "
					+ "Ut enim ad minim veniam, quis "
					+ "nostrud exercitation ullamco laboris "
					+ "nisi ut aliquip ex ea commodo consequat.")
			.build();
	
	Reviews review2 = 
			Reviews.builder()
			.review("Lorem ipsum dolor sit amet, "
					+ "consectetur adipiscing elit, "
					+ "sed do eiusmod tempor incididunt "
					+ "ut labore et dolore magna aliqua. "
					+ "Ut enim ad minim veniam, quis "
					+ "nostrud exercitation ullamco laboris "
					+ "nisi ut aliquip ex ea commodo consequat. "
					+ "Sed ut perspiciatis unde omnis iste "
					+ "natus error sit voluptatem accusantium "
					+ "doloremque laudantium, totam rem aperiam, "
					+ "eaque ipsa quae ab illo inventore "
					+ "veritatis et quasi architecto beatae vitae "
					+ "dicta sunt explicabo. Nemo enim ipsam "
					+ "voluptatem quia voluptas sit aspernatur "
					+ "aut odit aut fugit, sed quia consequuntur "
					+ "magni dolores eos qui ratione voluptatem "
					+ "sequi nesciunt. Neque porro quisquam est, "
					+ "qui dolorem ipsum quia dolor sit amet, "
					+ "consectetur, adipisci velit, sed quia "
					+ "non numquam eius modi tempora incidunt "
					+ "ut labore et dolore magnam aliquam "
					+ "quaerat voluptatem. Ut enim ad minima "
					+ "veniam, quis nostrum exercitationem "
					+ "ullam corporis suscipit laboriosam, "
					+ "nisi ut aliquid ex ea commodi "
					+ "consequatur? Quis autem vel eum iure "
					+ "reprehenderit qui in ea voluptate velit "
					+ "esse quam nihil molestiae consequatur, "
					+ "vel illum qui dolorem eum fugiat quo "
					+ "voluptas nulla pariatur?")
			.build();
	
	@Test
	void testReviewSaves() {
		repository.saveAll(List.of(review1));
	}
}