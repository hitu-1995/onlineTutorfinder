package com.capg.tutorFinder.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.capg.tutorFinder.dto.EmailDTO;
import com.capg.tutorFinder.exceptions.AdminAlreadyPresentException;
import com.capg.tutorFinder.exceptions.TutorAlreadyPresentException;
import com.capg.tutorFinder.model.Admin;
import com.capg.tutorFinder.model.EBook;
import com.capg.tutorFinder.model.Parent;
import com.capg.tutorFinder.model.Tutor;
import com.capg.tutorFinder.repository.AdminRepository;
import com.capg.tutorFinder.repository.EbookRepository;
import com.capg.tutorFinder.repository.ParentRepository;
import com.capg.tutorFinder.repository.TutorRepository;
import com.capg.tutorFinder.service.AdminService;

@Service
public class AdminServiceIMPL implements AdminService{

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private TutorRepository tutorRepo;
	
	@Autowired
	private EbookRepository ebooksRepo;
	
	@Autowired
	private ParentRepository parentRepo;
	
	@Autowired
	private JavaMailSender sender;
	
	@Override
	public void createAdmin(Admin admin) {
		
		try {
			adminRepo.save(admin);
				
		} catch (DataIntegrityViolationException e) {
		
		  throw new AdminAlreadyPresentException();	
		
		}
		
	}

	@Override
	public String adminlogin(String username, String password) {

		Admin admin = adminRepo.findByUsernameAndPassword(username, password);
		
		if(admin!=null)
		return "Admin Login Successfull!!";
		else
		return null;
	}

	@Override
	public String addTutor(Tutor tutor) {
		
		try {
		
			tutorRepo.save(tutor);
			
			EmailDTO dto = new EmailDTO();
			
			dto.setTo(tutor.getEmailid());
			dto.setMsg("Dear Tutor "+tutor.getTname()+"/n"+
			             "Your Username Is "+tutor.getTusername()+"\n"+
			             "Your Password Is "+tutor.getPassword());
		
			// add your proper credentials in application.properties file then uncomment this
			
		    //sendCredentialsToTutor(dto);
			
			return "Tutor Added "+"  Mail Sent to "+tutor.getEmailid();

		} catch (DataIntegrityViolationException e) {
			throw new TutorAlreadyPresentException();
			
		}
		
	}


	@Override
	public String saveEbooks(List<EBook> books) {
	
		ebooksRepo.saveAll(books);
		  
		
		return "Books Addedd To List";
	}
	
	@Override
	public List<Parent> checkParents() {
		// TODO Auto-generated method stub
		List<Parent> plist= parentRepo.findAll();
		return plist;
				
	}
	

	private void sendCredentialsToTutor(EmailDTO mail) {
		
		SimpleMailMessage sm= new SimpleMailMessage();
		
		sm.setFrom(mail.getFrom());
		sm.setTo(mail.getTo());
		sm.setSubject(mail.getSubject());
		sm.setText(mail.getMsg());
	
		sender.send(sm);
		
	}

	

}
