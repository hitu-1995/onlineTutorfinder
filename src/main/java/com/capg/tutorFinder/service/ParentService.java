package com.capg.tutorFinder.service;

import java.util.List;

import com.capg.tutorFinder.dto.TutorDTO;
import com.capg.tutorFinder.model.DemoRequest;
import com.capg.tutorFinder.model.EBook;
import com.capg.tutorFinder.model.Parent;
import com.capg.tutorFinder.model.Tutor;

public interface ParentService {

	String registerParent(Parent parent);

	String parentLogin(String uname, String pass);

	List<TutorDTO> viewTutors();

	String requestForDemo(DemoRequest request, Integer tid);

	String bookTutor(Integer pid, Integer tid);

	String rateTutor(Integer tid, Integer rating);

	List<EBook> viewBooks();

	List<TutorDTO> viewBookedTutors();

}
