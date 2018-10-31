package com.pityubak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pityubak.entity.User;
import com.pityubak.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public User findByName(String name) {
		return userRepository.findByUsername(name);
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	
}
