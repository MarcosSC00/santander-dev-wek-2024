package com.myprojects.services.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.myprojects.domain.models.User;
import com.myprojects.domain.repository.UserRepository;
import com.myprojects.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User user) {
		if(userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
			throw new IllegalArgumentException("User already exist");
		}
		return userRepository.save(user);
	}

}
