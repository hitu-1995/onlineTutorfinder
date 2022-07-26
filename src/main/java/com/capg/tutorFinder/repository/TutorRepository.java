package com.capg.tutorFinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.tutorFinder.model.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Integer>{

	Tutor findByTusernameAndPassword(String uname, String pass);
}
