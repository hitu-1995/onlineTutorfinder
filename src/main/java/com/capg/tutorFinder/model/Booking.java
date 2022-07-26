package com.capg.tutorFinder.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

	@Id
	@Column(name = "BOOKING_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bid;
	
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "booking")
	private List<Tutor> tutor;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Parent parent;
	
	

	
}
