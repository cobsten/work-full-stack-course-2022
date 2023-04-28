package com.ats.project.monolith.web.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.project.monolith.service.ScheduleService;
import com.ats.project.monolith.service.UserAuthenticationService;
import com.ats.project.monolith.service.UserService;
import com.ats.project.monolith.service.dto.ScheduleDTO;
import com.ats.project.monolith.service.dto.UserDTO;
import com.ats.project.monolith.web.rest.dto.UserEmailRequest;

@RestController
@Validated
@RequestMapping("/api/users")
public class UserController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private UserService userService;
	
	private UserAuthenticationService userAuthenticationService;
	
	public UserController(UserService userService,UserAuthenticationService userAuthenticationService) {
		this.userService = userService;
		this.userAuthenticationService = userAuthenticationService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> loginUser(@RequestBody UserDTO dto){
		return ResponseEntity.ok(userAuthenticationService.performLogin(dto));
	}
	
	@PostMapping("/logout")
	public ResponseEntity<?> logoutUser(@RequestBody UserDTO dto){
		return ResponseEntity.ok(userAuthenticationService.performLogout(dto));
	}
	
	@PostMapping("")
	public ResponseEntity<?> createUser(@RequestBody @Valid UserDTO dto){
		return ResponseEntity.ok(userService.createUser(dto));
	}
	
	@PostMapping("/emails/exist")
	public ResponseEntity<Boolean> checkEmailExists(@RequestBody UserEmailRequest dto){
		return ResponseEntity.ok(userService.checkEmailExists(dto.getEmail()));
	}

}
