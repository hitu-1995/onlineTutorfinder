package com.capg.tutorFinder.dto;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;
import lombok.val;

@Data
public class EmailDTO {

	@Value("${emaildto.from}")
	private String from;
	
	@Value("${emaildto.subject}")
	private String subject;

	private  String to;
	private String msg;
	
	@Override
	public String toString() {
		return "EmailDTO [from=" + from + ", subject=" + subject + ", to=" + to + ", msg=" + msg + "]";
	}
	
	
}
