package com.capg.tutorFinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.tutorFinder.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
