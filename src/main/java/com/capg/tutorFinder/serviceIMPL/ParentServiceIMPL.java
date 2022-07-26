package com.capg.tutorFinder.serviceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.capg.tutorFinder.dto.TutorDTO;
import com.capg.tutorFinder.exceptions.InvalidRatingException;
import com.capg.tutorFinder.exceptions.ParentAlreadyPresentException;
import com.capg.tutorFinder.model.Booking;
import com.capg.tutorFinder.model.DemoRequest;
import com.capg.tutorFinder.model.EBook;
import com.capg.tutorFinder.model.Parent;
import com.capg.tutorFinder.model.Tutor;
import com.capg.tutorFinder.repository.BookingRepository;
import com.capg.tutorFinder.repository.EbookRepository;
import com.capg.tutorFinder.repository.ParentRepository;
import com.capg.tutorFinder.repository.TutorRepository;
import com.capg.tutorFinder.service.ParentService;

@Service
public class ParentServiceIMPL implements ParentService {

	@Autowired
	private ParentRepository parentRepo;

	@Autowired
	private TutorRepository tutorRepo;

	@Autowired
	private BookingRepository bookingRepo;
	

	@Autowired
	private EbookRepository eBookRepo;
	
	
	@Override
	public String registerParent(Parent parent) {
		try {

			List<Tutor> tlist = tutorRepo.findAll();

			parent.setTutors(tlist);
			
			parentRepo.save(parent);
			

		} catch (DataIntegrityViolationException e) {

			throw new ParentAlreadyPresentException();
		}
		return "Parent Added Successfull !!";
	}

	@Override
	public String parentLogin(String uname, String pass) {

		Parent parent = parentRepo.findByUsernameAndPassword(uname, pass);
		if (parent != null)
			return "Parent Login Successfull";
		else
			return null;
	}

	@Override
	public List<TutorDTO> viewTutors() {

		List<Tutor> findAll = tutorRepo.findAll();
		List<TutorDTO> dtoList =new  ArrayList<TutorDTO>();
		for(Tutor tu :findAll) {
			
			TutorDTO dto = new TutorDTO();
			dto.setTid(tu.getTid());
			dto.setTname(tu.getTname());
			dto.setTusername(tu.getTusername());
			dto.setEmailid(tu.getEmailid());
			
			dtoList.add(dto);
		}
		
		return dtoList;
	}

	@Override
	public String requestForDemo(DemoRequest request, Integer tid) {

		if (!parentRepo.existsById(request.getPid()))
			return "Invalid Parent Id";
		else if (!tutorRepo.existsById(tid))
			return "Invalid Tutors ID";
		else {
			Tutor tutor = tutorRepo.findById(tid).get();
			tutor.getDemorequest().add(request);
			tutorRepo.save(tutor);
			
			return "Request Forwarded Successfull!!";
		}

	}

	@Override
	public String bookTutor(Integer pid, Integer tid) {
		
		if(!parentRepo.existsById(pid))
		return "Invalid Parent Id";
		else if(!tutorRepo.existsById(tid))
		return "Invalid Tutors Id";
		else {

			Tutor tutor = tutorRepo.findById(tid).get();
			Booking bk =new Booking();
			bk.setParent(parentRepo.findById(pid).get());
			bk.setTutor(new ArrayList<Tutor>());
			bk.getTutor().add(tutor);
			tutor.getBooking().add(bk);
			
			bookingRepo.save(bk);
            tutorRepo.save(tutor);
            
			return "Booking done successfull";
		}
			
		
	}

	@Override
	public String rateTutor(Integer tid, Integer rating) {
	
		if(rating<1 || rating>10)
		 throw new InvalidRatingException();
		else if(!tutorRepo.existsById(tid))
	    return "Tutor Not found exception";
		else {
			
			Tutor tutor = tutorRepo.findById(tid).get();
			tutor.setRating(rating);
			
			tutorRepo.save(tutor);
			
			return "Thanks for Rating";
		}
		
	}

	@Override
	public List<EBook> viewBooks() {
		
		return eBookRepo.findAll();
	}

	@Override
	public List<TutorDTO> viewBookedTutors() {
	
		 List<Booking> bList = bookingRepo.findAll();
		 
		 List<TutorDTO> tList = new ArrayList<TutorDTO>();
		 
		 
		    for(Booking bk : bList) {
		    
		    	List<Tutor> list = bk.getTutor();
		    	for(Tutor  t : list) {
		    		
		    		TutorDTO dto = new TutorDTO();
		    		dto.setTid(t.getTid());
		    		dto.setTname(t.getTname());
		    		dto.setTusername(t.getTusername());
		    		dto.setEmailid(t.getEmailid());
		    		
		    		tList.add(dto);
		    	}
		    	  
		    }
		 
		
		return tList;
	}

}
