package com.capg.tutorFinder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.tutorFinder.model.DemoRequest;
import com.capg.tutorFinder.repository.DemoRequestRepository;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private DemoRequestRepository demoRepo;
	
	@Test
	public void regParent() {
		
//		
//		Parent p = new Parent();
//		p.setPid(2);
//		p.setMobileno(987698765l);
//		p.setPname("Yogesh");
//		p.setUsername("yog");
//		p.setPassword("yog123");
//		Tutor t = new Tutor();
//		t.setTname("HH");
//		t.setRating(0);
//		t.setEmailid("hh@gmail.com");
//		t.setTusername("hhh");
//		t.setPassword("hhh");
//		Booking bk = new Booking();
//		bk.setParent(parent);
//		bk.setTutor(new ArrayList<Tutor>());
//		bk.getTutor().add(t);
//		
//		t.setBooking(new ArrayList<Booking>());
//		t.getBooking().add(bk);
//		
//		DemoRequest demoRequest= new DemoRequest();
//		demoRequest.setPid(1);
//		demoRequest.setRstatus("Requested");
//	
//		t.setDemorequest(new ArrayList<DemoRequest>());
//		t.getDemorequest().add(demoRequest);
//		
//		p.setTutors(new ArrayList<Tutor>());
//		p.getTutors().add(t);
//	    parentRepo.save(p);
	    
		DemoRequest dr = new DemoRequest();
		dr.setRid(8);
		dr.setPid(4);
        dr.setRstatus("requested");
		demoRepo.save(dr);
		assertNotNull(demoRepo.findById(4).get());
		
	}

}  