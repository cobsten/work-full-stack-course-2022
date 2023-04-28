package com.ats.project.monolith.service;

import org.springframework.stereotype.Service;

import com.ats.project.monolith.service.dto.UserDTO;

@Service
public class UserAuthenticationService {

	private UserService userService;
	
	public UserAuthenticationService(UserService userService) {
		this.userService = userService;
	}
	
	public Boolean performLogin(UserDTO dto) {
		return userService.checkUserCredentials(dto);
	}
	public UserDTO performLogout(UserDTO dto) {
		return dto;
	}
}
