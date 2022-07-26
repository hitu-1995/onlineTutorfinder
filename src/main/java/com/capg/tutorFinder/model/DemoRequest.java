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
//@XmlRootElement
public class DemoRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="R_ID")
	private Integer rid;  // 101,102
	
	@Column(name = "P_ID")
	private Integer pid;

	@Column(name = "R_STATUS")
	private String rstatus;
	
	
}
