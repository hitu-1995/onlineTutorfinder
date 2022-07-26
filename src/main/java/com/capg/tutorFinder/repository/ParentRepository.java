package com.capg.tutorFinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.tutorFinder.model.Parent;
@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer>{

	Parent findByUsernameAndPassword(String uname, String pass);

}
