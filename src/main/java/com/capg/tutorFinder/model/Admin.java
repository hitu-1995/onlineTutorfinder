package com.capg.tutorFinder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor   
@XmlRootElement
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 201,202
	@Column(name = "ADMIN_ID")
	private Integer id;
	
	@Column(name = "ADMIN_USERNAME",unique = true)
	private String username;
	
	@Column(name = "ADMIN_PASSWORD")
	private String password;
	
	

}
