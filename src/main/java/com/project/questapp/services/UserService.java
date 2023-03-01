package com.project.questapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.questapp.entities.Comment;
import com.project.questapp.entities.Like;
import com.project.questapp.entities.User;
import com.project.questapp.repository.CommentRepository;
import com.project.questapp.repository.LikeRepository;
import com.project.questapp.repository.PostRepository;
import com.project.questapp.repository.UserRepository;

@Service
public class UserService {

	 private UserRepository userRepository;
	 private LikeRepository likeRepository;
	 private CommentRepository commentRepository;
	 private PostRepository postRepository;

	 //@Autowired
	public UserService(UserRepository userRepository,LikeRepository likeRepository,CommentRepository commentRepository,PostRepository postRepository) {
		super();
		this.userRepository = userRepository;
		this.likeRepository = likeRepository;
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
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
			foundUser.setAvatar(newUser.getAvatar());
			userRepository.save(foundUser);
			return foundUser;
			
		}else {
			return null;
		}
	}

	public void deleteById(int userId) {
		userRepository.deleteById(userId);
	}

	public User getOneUserByUserName(String userName) {
		
		return userRepository.findByUserName(userName);
	}

	public List<Object> getUserActivity(int userId) {
		List<Integer> postIds = postRepository.findTopByUserId(userId);
		if(postIds.isEmpty())
			return null;
		List<Object> comments = commentRepository.findUserCommentsByPostId(postIds);
		List<Object> likes = likeRepository.findUserLikesByPostId(postIds);
		List<Object> result = new ArrayList<>();
		result.addAll(comments);
		result.addAll(likes);
		System.out.println(result);
		return result;
		
		
	}

	
	
	
	
	
}
