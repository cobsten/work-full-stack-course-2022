package com.ats.project.monolith.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.project.monolith.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findFirstByEmail(String email);
	
	List<User> findByEmail(String email);

	
}
