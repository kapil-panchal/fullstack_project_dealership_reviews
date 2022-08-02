package com.app31.reviewcollection1.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "DealerState")
@Table(name = "dealerstate",
		schema = "app31sch",
		catalog = "app31cat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DealershipState implements Serializable {
	
	private static final long serialVersionUID = 3703024468880805608L;

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
	private UUID stateId;
	
	@Column(name = "state_name", columnDefinition = "VARCHAR(100)", nullable = false)
	private String stateName;
	
	@Column(name = "time_stamp", nullable = false)
	@CreationTimestamp
	private Instant timestamp;
	
	@ManyToMany(cascade = CascadeType.ALL,
				fetch = FetchType.EAGER)

	@JoinTable(name = "dealerstate_reviews",
						joinColumns = @JoinColumn(
								name = "state_id",
								referencedColumnName = "stateId"),
						inverseJoinColumns = @JoinColumn(
								name = "review_id",
								referencedColumnName = "reviewId"),
						schema = "app31sch",
						catalog = "app31cat")
	private List<Reviews> reviewsList;
	
	public void addReview(Reviews review) {
		if(reviewsList == null) {
			reviewsList = new ArrayList<>();
		}
		reviewsList.add(review);		
	}
}