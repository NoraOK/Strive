package com.noraokeeffe.strive.services;

import org.springframework.stereotype.Service;

import com.noraokeeffe.strive.respositories.UserRepo;

@Service
public class UserService {
	private final UserRepo userRepo;

	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	
}
