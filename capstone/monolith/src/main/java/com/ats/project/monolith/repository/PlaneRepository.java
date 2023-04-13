package com.ats.project.monolith.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.project.monolith.entity.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, String> {

}
