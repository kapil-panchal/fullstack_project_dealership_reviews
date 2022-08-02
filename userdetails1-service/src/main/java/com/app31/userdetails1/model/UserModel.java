package com.app31.userdetails1.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "UserModel")
@Table(name = "user_model",
		schema = "app31sch",
		catalog = "app32cat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserModel implements Serializable {

	private static final long serialVersionUID = 8881141146469241463L;
	
	@Id
	@GeneratedValue(generator = "person-uuid")
	@GenericGenerator(name = "person-uuid",
						strategy = "org.hibernate.id.UUIDGenerator",
						parameters = {
								@Parameter(
										name = "uuid_gen_strategy_class",
										value = "org.hibernate.id.uuid.CustomVersionFourStrategy"
								)
						})
	private UUID userId;
	
	@Column(name = "first_name", columnDefinition = "VARCHAR(100)", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", columnDefinition = "VARCHAR(100)", nullable = false)
	private String lastName;
	
	@Column(name = "email", columnDefinition = "VARCHAR(150)", nullable = false)
	@Email
	private String email;
	
	@Column(name = "time_stamp", nullable = false)
	@CreationTimestamp
	private Instant timestamp;
}