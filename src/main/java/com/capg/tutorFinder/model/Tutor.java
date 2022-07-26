package com.capg.tutorFinder.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Tutor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TUTOR_ID")
	private Integer tid;

	@Column(name = "TUTOR_NAME")
	private String tname;
	
	@Column(name = "TUTOR_USERNAME",unique = true)
	private String tusername;
	
	@Column(name = "TUTOR_EMAIL_ID")
	private String emailid;
	
	@Column(name = "TUTOR_PASSWORD")
	private String password;
	
	@Column(name = "TUTOR_RATING")
	private Integer rating;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<DemoRequest> demorequest;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Booking> booking;
	
	
	
}
