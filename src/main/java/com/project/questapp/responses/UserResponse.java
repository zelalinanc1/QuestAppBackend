package com.project.questapp.responses;

import com.project.questapp.entities.User;

import lombok.Data;

@Data
public class UserResponse {
	
	int id;
	int avatarId;
	String userName;
	
	public UserResponse(User entity) {
		this.id =id;
		this.avatarId = entity.getAvatar();
		this.userName = entity.getUserName();
	}

}
