package com.app31.userdetails1.repository;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.app31.userdetails1.model.UserModel;

@SpringBootTest
//@DataJpaTest // default goes to H2 database

class UserModelRepositoryTest {

	@Autowired
	private UserModelRepository repository;
	
	UserModel userModel =
			UserModel.builder()
			.firstName("User1FirstName")
			.lastName("User1LastName")
			.email("user1@user1.com")
			.build();
	
//	@Test
//	public void testUserModelSavesDataToTheDatabase() {
//		UserModel userModel = 
//				UserModel.builder()
//				.firstName("User1FirstName")
//				.lastName("User1LastName")
//				.email("user1@user1.com")
//				.build();
//		repository.save(userModel);		
//	}
	
	@Test
	public void testUserModelExtractsFromDatabase() {
		List<UserModel> userModelList =
				repository.findAll();
		System.err.println(userModelList.toString());	
	}
}