package com.capg.tutorFinder.serviceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.tutorFinder.model.DemoRequest;
import com.capg.tutorFinder.model.Tutor;
import com.capg.tutorFinder.repository.DemoRequestRepository;
import com.capg.tutorFinder.repository.TutorRepository;
import com.capg.tutorFinder.service.TutorService;

@Service
public class TutorServiceIMPL implements TutorService{

	@Autowired
	private TutorRepository tutorRepo;

	@Autowired
	private DemoRequestRepository demoRequestRepo;
	
	@Override
	public String tutorLogin(String uname, String pass) {
		
		Tutor tutor = tutorRepo.findByTusernameAndPassword(uname, pass);
		
		 if(tutor!=null)
		return "Tutor Login Successfull !!";
		 else
		  return null;
	}

	@Override
	public String acceptRequest(Integer tid,Integer rid) {
		Optional<DemoRequest> id = demoRequestRepo.findById(rid);
		if(id.isPresent()) {
		   DemoRequest request = id.get();
		     request.setRstatus("Accepted");
		       Optional<Tutor> tuid = tutorRepo.findById(tid);
		       if(tuid.isPresent()) {
		    	   Tutor tutor = tuid.get();
		    	   tutor.getDemorequest().add(request);
		    	 //  demoRequestRepo.save(request);
		    	   tutorRepo.save(tutor);
		       }
		       else {
		    	   return "Tutor Id not Present";
		       }
		       return "Request Accepted";
		}
		else
		return "Request Id Not Present";
	}

	@Override
	public List<DemoRequest> getDemoRequest(Integer id) {
		System.out.println("----------------------"+id+"--------------");
		Optional<Tutor> flag = tutorRepo.findById(id);
		if(flag.isPresent()) {
			
			List<DemoRequest> list = flag.get().getDemorequest();
			 
			System.out.println("************"+ list);
			if(list.isEmpty())
			return new ArrayList<DemoRequest>();
			 else {
				 
				 return list;
			 }
			 
		}
		return null;
	}

	@Override
	public void updateTutor(Tutor tutor) {
		tutorRepo.save(tutor);
		
	}
	 
	
     	
}
