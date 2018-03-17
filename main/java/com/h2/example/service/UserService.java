package com.h2.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.h2.example.entity.User;
import com.h2.example.repository.UserRepository;

@Service
@CacheConfig(cacheNames = "users")
public class UserService {
	
	@Autowired
	UserRepository userRepo;

	public User addUser(User user) {
		 return userRepo.save(user);
	}

	public List<User> addListOfUser(List<User> user) {
		return (List<User>) userRepo.saveAll(user);	
	}

	@Cacheable()
	public List<User> getAllUsers() {	
		return (List<User>) userRepo.findAll();	
	}

}
