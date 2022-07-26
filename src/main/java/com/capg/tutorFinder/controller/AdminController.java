package com.capg.tutorFinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.tutorFinder.model.Admin;
import com.capg.tutorFinder.model.EBook;
import com.capg.tutorFinder.model.Parent;
import com.capg.tutorFinder.model.Tutor;
import com.capg.tutorFinder.repository.EbookRepository;
import com.capg.tutorFinder.service.AdminService;

@RestController
@RequestMapping("/adminApi")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/createAdmin")
	public ResponseEntity<String> createAdmin(@RequestBody Admin admin) {
		
		adminService.createAdmin(admin);
		
		return new ResponseEntity<String>("Admin Created",HttpStatus.CREATED);
	}
	
	@GetMapping("/loginAdmin/{username}/{password}")
	public ResponseEntity<String> adminLoginCheck(@PathVariable String username ,
			                                      @PathVariable String password) {
		

		String msg = adminService.adminlogin(username, password);
		
		
		if(msg!=null) {
			return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
		}
		else {
			
			msg = "Invalid Parent Credentials";
			return new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addTutor")
	public ResponseEntity<String> addTutor(@RequestBody Tutor tutor) {
		
		return new ResponseEntity<String>(adminService.addTutor(tutor), HttpStatus.CREATED);
	}
	
	@PostMapping("/addEbooks")
	public ResponseEntity<String> addEbooks(@RequestBody List<EBook> books) {
		
	String msg =	adminService.saveEbooks(books);
	
	  return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	  
	}
	
	@GetMapping("/checkRegisteredParents")
	public ResponseEntity<List<Parent>> checkRegisteredParents() {
		
		return new ResponseEntity<List<Parent>>(adminService.checkParents(),HttpStatus.OK);
	}
}
