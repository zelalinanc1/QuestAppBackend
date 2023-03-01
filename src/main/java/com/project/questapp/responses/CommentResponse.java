package com.project.questapp.responses;

import com.project.questapp.entities.Comment;

import lombok.Data;

@Data
public class CommentResponse {
	
	int id;
	int userId;
	String text;
	String userName;
	
	public CommentResponse(Comment entity) {
		this.id = entity.getId();
		this.userId = entity.getUser().getId();
		this.text = entity.getText();
		this.userName = entity.getUser().getUserName();
	}

}
