package com.project.questapp.responses;

import com.project.questapp.entities.Like;

import lombok.Data;

@Data
public class LikeResponse {

	int id;
	int userId;
	int postId;
	
	public LikeResponse(Like entity) {
		this.id = entity.getId();
		this.userId = entity.getUser().getId();
		this.postId = entity.getPost().getId();
	} 
}