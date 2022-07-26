package com.capg.tutorFinder.service;

import java.util.List;

import com.capg.tutorFinder.model.Admin;
import com.capg.tutorFinder.model.EBook;
import com.capg.tutorFinder.model.Parent;
import com.capg.tutorFinder.model.Tutor;

public interface AdminService {

	public void createAdmin(Admin admin);
	
	public String adminlogin(String username , String password);
	
	public String addTutor(Tutor tutor);

	public String saveEbooks(List<EBook> books);
	
	public List<Parent> checkParents();
	
	
}
