package com.ats.project.monolith.service.dto;

import java.util.List;


public class UserDTO {

	private Long id;
	
	private String email;

	private String name;
	
	private String passphrase;
	
	private List<UserLoginDTO> logins;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<UserLoginDTO> getLogins() {
		return logins;
	}

	public String getPassphrase() {
		return passphrase;
	}

	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
	}

	public void setLogins(List<UserLoginDTO> logins) {
		this.logins = logins;
	}
}
