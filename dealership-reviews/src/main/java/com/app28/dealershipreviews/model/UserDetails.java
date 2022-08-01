package com.app28.dealershipreviews.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

@Entity
public class UserDetails {

	private Long id;
	
	@Basic
	private String firstName;
	
	@Column(length = 200)
	@Size(max = 200)
	private String lastName;
	
	@Enumerated(EnumType.ORDINAL) // STRING
	@Column(name = "phone_type")
	private PhoneType type;
	


	// mapped as TIMESTAMP
	private Instant instant;


}