package com.app31.reviewcollection1.model;

import java.io.Serializable;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "Reviews")
@Table(name = "reviews",
		schema = "app31sch",
		catalog = "app31cat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Reviews implements Serializable {
	
	private static final long serialVersionUID = 9165127307920413448L;
	
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
	private UUID reviewId;
	
	@Column(nullable = false)
	@Size(max = 1024, min = 10)
	private String review;
	
	@Column(name = "time_stamp", nullable = false)
	@CreationTimestamp
	private Instant timestamp;
}