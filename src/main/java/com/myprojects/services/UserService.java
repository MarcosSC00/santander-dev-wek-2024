package com.myprojects.services;

import com.myprojects.domain.models.User;

public interface UserService {
	
	User findById(Long id);
	
	User create(User user);
}
