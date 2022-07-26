package com.capg.tutorFinder.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // 301,302
	@Column(name = "PARENT_ID")
	private Integer pid;
	
	@Column(name = "PARENT_NAME")
	private String pname;
	
	@Column(name = "PARENT_MOBILE",unique = true)
	private Long mobileno;
	

	@Column(name = "PARENT_USERNAME",unique = true)
	private String username;
	

	@Column(name = "PARENT_PASSWORD")
	private String password;
	

	@OneToMany(cascade = CascadeType.ALL)
	private List<Tutor> tutors;
	
}
