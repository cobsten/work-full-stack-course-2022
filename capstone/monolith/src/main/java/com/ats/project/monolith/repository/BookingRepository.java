package com.ats.project.monolith.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.project.monolith.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, String> {

}
