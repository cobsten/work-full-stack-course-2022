package com.example.login.controller;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.entity.Registration;
import com.example.login.service.RegistrationService;

@Validated
@RestController
@RequestMapping("/registrations")
public class RegistrationController {

	private RegistrationService registrationService;
	
	public RegistrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}
	
	@PostMapping("")
	public Registration register(@Valid @RequestBody Registration registration){
		Registration result = registrationService.save(registration);
		return result;
	}
	
    @GetMapping("/{email}/{password}")
    public Boolean authenticate(@Valid @PathVariable(value="email") String email,@Valid @PathVariable(value="password") String password) {
    	Boolean authenticatedBoolean = registrationService.isValidUser(email, password);
    	System.out.println("REgistration Controller - authenticate : " + authenticatedBoolean);
    	return authenticatedBoolean;
    }
}
