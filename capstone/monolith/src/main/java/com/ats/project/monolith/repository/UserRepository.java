package com.ats.project.monolith.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.project.monolith.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findFirstByEmail(String email);
}
