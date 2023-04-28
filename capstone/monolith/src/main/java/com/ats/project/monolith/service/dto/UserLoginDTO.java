package com.ats.project.monolith.service.dto;

import java.time.Instant;

public class UserLoginDTO {

	private Long id;
	
	private UserDTO user;
	
	private Boolean loginSuccess;
	
	private Instant loginDateTime;

	private Instant logoutDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Boolean getLoginSuccess() {
		return loginSuccess;
	}

	public void setLoginSuccess(Boolean loginSuccess) {
		this.loginSuccess = loginSuccess;
	}

	public Instant getLoginDateTime() {
		return loginDateTime;
	}

	public void setLoginDateTime(Instant loginDateTime) {
		this.loginDateTime = loginDateTime;
	}

	public Instant getLogoutDateTime() {
		return logoutDateTime;
	}

	public void setLogoutDateTime(Instant logoutDateTime) {
		this.logoutDateTime = logoutDateTime;
	}
}
