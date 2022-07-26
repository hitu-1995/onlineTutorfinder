package com.capg.tutorFinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.tutorFinder.model.DemoRequest;

@Repository
public interface DemoRequestRepository extends JpaRepository<DemoRequest, Integer> {

	
}
