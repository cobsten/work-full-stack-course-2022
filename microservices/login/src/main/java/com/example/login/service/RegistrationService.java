package com.example.login.service;

import com.example.login.entity.Registration;

public interface RegistrationService {
    Registration save(Registration registration);
    Registration findByEmail(String email);
    Registration findByEmailAndPassword(String email, String password);
    Boolean isValidUser(String email, String password);
}
