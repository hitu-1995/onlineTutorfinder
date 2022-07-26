package com.capg.tutorFinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.tutorFinder.model.EBook;

@Repository
public interface EbookRepository extends JpaRepository<EBook , Integer>{

	
}
