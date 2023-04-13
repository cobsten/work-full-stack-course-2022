package com.example.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, String> {
	
    Registration findByEmail(String email);
    Registration findByEmailAndPassword(String email, String password);

}
