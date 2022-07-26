package com.capg.tutorFinder.service;

import java.util.List;

import com.capg.tutorFinder.model.DemoRequest;
import com.capg.tutorFinder.model.Tutor;

public interface TutorService {

	String tutorLogin(String uname, String pass);

	String acceptRequest(Integer tid,Integer rid);

	List<DemoRequest> getDemoRequest(Integer id);

	void updateTutor(Tutor tutor);

}
