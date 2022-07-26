package com.capg.tutorFinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.tutorFinder.model.DemoRequest;
import com.capg.tutorFinder.model.Tutor;
import com.capg.tutorFinder.service.TutorService;

@RestController
@RequestMapping("/tutorApi")
public class TutorController {

	@Autowired
	private TutorService tutorService;

	@GetMapping("/tutorLogin/{uname}/{pass}")
	public ResponseEntity<String> tutorLogin(@PathVariable String uname,
			@PathVariable String pass) {

		String msg = tutorService.tutorLogin(uname, pass);

		if (msg != null)
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		else {
			msg = "Invalid Tutor Credentials";
			return new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/acceptRequest/{tid}/{rid}")
	public ResponseEntity<String> acceptRequest(@PathVariable Integer tid,
			   @PathVariable Integer rid) {
		
		String msg = tutorService.acceptRequest(tid,rid);
 
		 return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@PutMapping("/updateTutorProfile")
	public ResponseEntity<String> updateTutor(@RequestBody Tutor tutor) {
		
		  tutorService.updateTutor(tutor);
		
		return new ResponseEntity<String>("Tutor Updated",HttpStatus.OK);
	}
	
	@GetMapping("/viewDemoRequest/{id}")
	public ResponseEntity<Object> getDemoRequest(@PathVariable Integer id) {
		
		
		System.out.println("----------------------"+id+"--------------");
		List<DemoRequest> list = tutorService.getDemoRequest(id);
		
		if(list.isEmpty())
			return new ResponseEntity<Object>("No Request Found",HttpStatus.NOT_FOUND);
		else if(list==null)
			return new ResponseEntity<Object>("Tutor Not Found",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Object>(list,HttpStatus.OK);	
		
	}
}
