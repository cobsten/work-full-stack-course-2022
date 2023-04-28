package com.ats.project.monolith.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ats.project.monolith.entity.User;
import com.ats.project.monolith.repository.UserRepository;
import com.ats.project.monolith.service.dto.UserDTO;
import com.ats.project.monolith.service.mapper.UserMapper;

@Service
@Transactional
public class UserService {
	
	Logger log = LoggerFactory.getLogger(getClass());

	private UserMapper userMapper;

	private UserRepository userRepository;
	
	
	public UserService(UserMapper userMapper, UserRepository userRepository) {
		this.userMapper = userMapper;
		this.userRepository = userRepository;
	}
	
	public UserDTO createUser(UserDTO dto) {
		User user = userMapper.toEntity(dto);
		user = userRepository.save(user);
		return userMapper.toDto(user);
	}
	
	public Boolean checkEmailExists(String email) {
		log.info(email);
		return !userRepository.findByEmail(email).isEmpty();
	}
	
	public Boolean checkUserCredentials(UserDTO dto) {
		User credentials = new User();
		credentials.setEmail(dto.getEmail());
		credentials.setPassphrase(dto.getPassphrase());
		return userRepository.findOne(Example.of(credentials)).isPresent();
	}
	
}
