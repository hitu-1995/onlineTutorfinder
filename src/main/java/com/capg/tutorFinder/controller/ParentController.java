package com.capg.tutorFinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.tutorFinder.dto.TutorDTO;
import com.capg.tutorFinder.model.Booking;
import com.capg.tutorFinder.model.DemoRequest;
import com.capg.tutorFinder.model.EBook;
import com.capg.tutorFinder.model.Parent;
import com.capg.tutorFinder.model.Tutor;
import com.capg.tutorFinder.service.ParentService;

@RestController
@RequestMapping("/parentApi")
public class ParentController {

	@Autowired
	private ParentService parentService;
	
	
	@PostMapping("/regParent")
	public ResponseEntity<String> registerParent(@RequestBody Parent parent) {
		
	
		String msg =  parentService.registerParent(parent);
		
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping("/parentLogin/{uname}/{pass}")
	public ResponseEntity<String> parentLogin(@PathVariable String uname ,
			                                 @PathVariable String pass) {
		
	 String msg = 	parentService.parentLogin(uname,pass);
         if(msg!=null) {
         return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);	
         }
         else {
              msg = "Invalid Parent Credentials !!";
        	 return new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);	 
         
         }
	}
	
	@GetMapping(value = "/viewTutors")
	public ResponseEntity<Object> viewAllTutors() {
	
	List<TutorDTO> tlist =	parentService.viewTutors();
	
	  if(tlist!=null) {
		 return new ResponseEntity<Object>(tlist,HttpStatus.OK);
		  
	  }
	  else
	  {
		return  new ResponseEntity<Object>("Tutors Not Available",HttpStatus.NOT_FOUND);
	  }
	
	}
	
	@PutMapping("/requestForDemo/{tid}")
	public ResponseEntity<String> requestTutorForDemo(@RequestBody DemoRequest request,
			                                          @PathVariable Integer tid) {
		
	String status = parentService.requestForDemo(request,tid);
	
	return new ResponseEntity<String>(status,HttpStatus.OK);
		
	}
	
	@PutMapping("/bookTutor/{pid}/{tid}")
	public ResponseEntity<String> bookTutor(@PathVariable Integer pid,
			                                @PathVariable Integer tid) {
	
	String msg =	parentService.bookTutor(pid,tid);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/rateTutor/{tid}/{rating}")
	public ResponseEntity<String> rateTutor(@PathVariable Integer tid,
			                                @PathVariable Integer rating) {
		
	  String msg =  parentService.rateTutor(tid,rating);
	  
	  return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/viewBooks")
	public ResponseEntity<List<EBook>> bookList() {
		
		return new ResponseEntity<List<EBook>>(parentService.viewBooks(),HttpStatus.OK);
		
	}
	
	@GetMapping("/viewBookedTutors")
	public ResponseEntity<List<TutorDTO>> viewBookedTutor() {
	  List<TutorDTO> tList= parentService.viewBookedTutors();
	  
		return new ResponseEntity<List<TutorDTO>>(tList,HttpStatus.OK);
	}
}
