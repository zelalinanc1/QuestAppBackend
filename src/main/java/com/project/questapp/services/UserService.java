package com.project.questapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.questapp.entities.User;
import com.project.questapp.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public User saveOneUser(User newUser) {
		// TODO Auto-generated method stub
		return userRepository.save(newUser);
	}

	public User getOneUserById(int userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElse(null);
	}

	public User updateOneUser(int userId, User newUser) {
		
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
			
		}else {
			return null;
		}
	}

	public void deleteById(int userId) {
		userRepository.deleteById(userId);
	}
	
	
	
	
	
}