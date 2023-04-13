package com.ats.project.monolith.entity;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "name")
	private String name;
	@Column(name = "phone_number", unique = true)
	private String phoneNumber;
	
	@Column(name= "passphrase", nullable=false)
	private String passphrase;
	
	@OneToMany(targetEntity=com.ats.project.monolith.entity.UserLogin.class,mappedBy = "user")
	private List<UserLogin> logins;

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<UserLogin> getLogins() {
		return logins;
	}

	public void setLogins(List<UserLogin> logins) {
		this.logins = logins;
	}
}
