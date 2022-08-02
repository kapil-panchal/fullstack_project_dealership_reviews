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

@Entity(name = "Dealership")
@Table(name = "dealership",
		schema = "app31sch",
		catalog = "app31cat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Dealership implements Serializable {
	
	private static final long serialVersionUID = 6508709039182339943L;
	
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
	private UUID dealerId;
	
	@Column(name = "dealer_name", columnDefinition = "VARCHAR(100)", nullable = false)
	private String dealerName;
	
	@Column(name = "time_stamp", nullable = false)
	@CreationTimestamp
	private Instant timestamp;
	
	@ManyToMany(cascade = CascadeType.ALL,
				fetch = FetchType.EAGER)
	
	@JoinTable(name = "dealership_dealerstate_reviews",
						joinColumns = @JoinColumn(
								name = "dealer_id",
								referencedColumnName = "dealerId"),
						inverseJoinColumns = @JoinColumn(
								name = "state_id",
								referencedColumnName = "stateId"),
						schema = "app31sch",
						catalog = "app31cat")
	List<DealershipState> dealerState;
	
	public void addDealerAddress(DealershipState dealerStateAddress) {
		if(dealerState == null) {
			dealerState = new ArrayList<>();
		}
		dealerState.add(dealerStateAddress);
	}
}