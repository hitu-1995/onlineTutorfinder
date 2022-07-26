package com.capg.tutorFinder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Entity
@Data
@XmlRootElement
public class EBook {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EBook_ID")
	private Integer ebid;
	
	@Column(name = "EBook_Name")
	private String ename;

	@Column(name = "E_PRICE")
	private String price;
	
	
}
